var Territory = Territory || {};
Territory.DAO = {};

Territory.PrintMap = Class.extend({
	_this : null,
	_map : null,
	_centerPoint : null,
	_blockInfo : null,
	_buildingInfo : null,
	_defaultZoomLevel : null,
	_localSearch : null,
	_type : null,
	BUILDING : "building",
	BLOCK : "block",
	DISTANCE_BASED_STATION_FILTER_COUNT : 10,
	NUM_BUS_STATIONS : 4,
	
	init: function(type, blockOrBuildingInfo){
	    _this = this;
	    _type = type;

		if(_type == _this.BUILDING) {
		    _buildingInfo = blockOrBuildingInfo;
		    _centerPoint = new BMap.Point(_buildingInfo["coord"].split(",")[1], _buildingInfo["coord"].split(",")[0]);
		} else if(_type ==  _this.BLOCK) {
		    _blockInfo = blockOrBuildingInfo;
		    _centerPoint = new BMap.Point(_this.getCentreCoord()[0], _this.getCentreCoord()[1]);
		}

		_defaultZoomLevel = 17;

		_map = new BMap.Map("printContainer", {enableHighResolution : true});
		_map.addControl(new BMap.ScaleControl());
		_map.centerAndZoom(_centerPoint, _this.getPrintZoomLevel());
		_map.enableScrollWheelZoom();
		
		_localSearch = new BMap.LocalSearch(_map, {
			renderOptions : {map : _map,  
							 autoViewport : false, 
							 selectFirstResult : false
							 },
			pageCapacity : 70,
			onSearchComplete : function(result) {
				
			},
			
			onMarkersSet : function(pois) {
				// sort by number of buses available
				pois.sort(function(a, b){
					return b.address.split(";").length - a.address.split(";").length;
				});
				
				var lbl;
				var selectedStationCnt = 0;
				var stationInfoHtml = "";
				
				for(var j = 0; j < pois.length; j++) {
					if((selectedStationCnt < _this.NUM_BUS_STATIONS) && (_this._getDistanceFromCenterMarker(pois[j]) < 400)) {
						selectedStationCnt++;
						var cleanedBusNumberInfo = _this._getCleanedBusNumberInfo(pois[j].address);
						stationInfoHtml = stationInfoHtml + selectedStationCnt + "." + pois[j].title + "<br>" + cleanedBusNumberInfo + "<br><br>";
						lbl = new BMap.Label(selectedStationCnt, {offset: new BMap.Size(15, 1)});
						lbl.setStyle({paddingBottom:"5px",fontSize:"15px", color:"black", border: "1px solid"});
						var icon = new BMap.Icon("/images/no_marker.png", new BMap.Size(14,23))
						pois[j].marker.setLabel(lbl);	
						pois[j].marker.setIcon(icon);	
					} else {
						pois[j].marker.remove();
					}
				}

				_this._addBusStationInfo(stationInfoHtml);
			}
		});

        if(isDisplayBusInfo) {
		    _localSearch.searchNearby("公交车站", _centerPoint, 800);
		}

		if(_type == _this.BLOCK) {
		    _this.drawBlock(blockInfo["blockName"], blockInfo["blockNumber"], blockInfo["coord"]);
            _this._drawBlockMarker(blockInfo["blockName"], blockInfo["blockNumber"], blockInfo["coord"]);
		} else if(_type == _this.BUILDING) {
            _this.drawBuilding(buildingInfo);
            _this._drawFloorInfo(buildingInfo);
		}


		// Scale control takes time to initialize. Without this line, it won't be printed out.
        setTimeout(function(){
                $(".BMap_scaleCtrl").css("display", "inline");
                    $("html body div#printContainer div.anchorBL a img").css("display", "none");
            }, 5000);
	},
	
	_getCleanedBusNumberInfo : function(busInfo) {
		var trimmedBusIinfo = busInfo.trim();
		var numberOnlyBusInfo = busInfo.replace(/[^0-9;]*/gi, "");
		var cleanedBusInfo = $.unique(numberOnlyBusInfo.split(";")).sort(function (a,b){
			  return parseInt(a) > parseInt(b) ? 1 : -1;
		}).join(" ");

		return cleanedBusInfo;
						
	},
	
	_addBusStationInfo : function(stationInfoHtml) {
		$("#busInfoDiv").html(stationInfoHtml);
	},
	
	getCentreCoord : function() {
		var centreCoord;
		
		if(_blockInfo["printCoord"] != "") {
			centreCoord = [blockInfo["printCoord"].split(",")[1], _blockInfo["printCoord"].split(",")[0]];  
		} else if(_blockInfo["markerCoord"] != ""){
			centreCoord = [blockInfo["markerCoord"].split(",")[1], _blockInfo["markerCoord"].split(",")[0]];  
		} else {
			centreCoord = _this._findMarkerPosition(_blockInfo["coord"]);
		}
		
		return centreCoord;
	},
	
	getPrintZoomLevel : function() {
		if(_type == _this.BLOCK && _blockInfo["printZoomLevel"] != "") {
			return _blockInfo["printZoomLevel"];
        }

		if(_type == _this.BUILDING && _buildingInfo["printZoomLevel"] != "") {
			return _buildingInfo["printZoomLevel"];
		}

		return _defaultZoomLevel;
	},
	
	drawBlock : function(block, number, pts) {
		var pointStrArray = pts.split(";");
		var pointArray = [];
		
		for(var i = 0; i < pointStrArray.length; i++) {
			var point = new BMap.Point(pointStrArray[i].split(",")[1], pointStrArray[i].split(",")[0]);
			pointArray.push(point);
		}
		
		_this._drawPolygon(pointArray);
	},

	drawBuilding : function(buildingInfo) {
		var lat = buildingInfo["coord"].split(",")[0];
        var lng = buildingInfo["coord"].split(",")[1];
        var block = buildingInfo["blockName"];
        var number = buildingInfo["blockNumber"];
        var buildingName = buildingInfo["name"];
        var address = buildingInfo["address"];
        var mkr = new BMap.Marker(new BMap.Point(parseFloat(lng), parseFloat(lat)) , {icon: new BMap.Icon("/images/building-icon.png", new BMap.Size(50, 55))});
        _map.addOverlay(mkr);
	},

	_drawFloorInfo : function(buildingInfo)   {
	    var floorInfo = buildingInfo["floor"];
	    var sortedFloors = _this._getReverseSortedIndividualFloors(floorInfo);
	    var floorTmplHtml = $("#floorTmpl").html();
	    var floorInfoHtml = "";

	    for(var i = 0; i < sortedFloors.length; i++) {
	        floorInfoHtml += floorTmplHtml.replace("{floor}", sortedFloors[i]);
	    }

        $("#floorInfoDiv").html(floorInfoHtml);
	},

	_drawPolygon : function(pts){
		var ply = new BMap.Polygon(pts, { strokeColor: "blue", strokeWeight: 3, strokeOpacity: 0.6, fillOpacity: 0.000001 });    
	    _map.addOverlay(ply);  
	},
	
	_drawBlockMarker : function(block, number, pts) {
		var markerPosition = _this._findMarkerPosition(pts);
		var mkr = new BMap.Marker(new BMap.Point(markerPosition[0], markerPosition[1]));
		var icon = new BMap.Icon("/images/red_marker.png", new BMap.Size(14,23))
		var title = "Block : " + block + "- "+ number;
		mkr.setTitle(title); 
		mkr.setIcon(icon);
		_map.addOverlay(mkr);
	},

	_getReverseSortedIndividualFloors : function(floorInfo) {
	    var sortedFloorInfo = [];
	    var floorInfoArray = floorInfo.split(",");

	    for(var i = 0; i < floorInfoArray.length; i++) {
	        var floorInfo = floorInfoArray[i];

	        if(floorInfo.indexOf("-") != -1) {
	            for(var j = parseInt(floorInfo.split("-")[0]); j <= parseInt(floorInfo.split("-")[1]); j++) {
	                sortedFloorInfo.push(j);
	            }
	        } else {
	            sortedFloorInfo.push(parseInt(floorInfo));
	        }
	    }

	    sortedFloorInfo.sort(function(a, b){
            return parseInt(b) - parseInt(a);
        });

        return sortedFloorInfo;
	},
	
	_findMarkerPosition : function(pts) {
		var pointStrArray = pts.split(";");
		var latAvg = 0.0;
		var lngAvg = 0.0;
		
		for(var i = 0; i < pointStrArray.length; i++) {
			latAvg += parseFloat(pointStrArray[i].split(",")[1]);
			lngAvg += parseFloat(pointStrArray[i].split(",")[0]);
		}
		
		latAvg /= parseFloat(pointStrArray.length);
		lngAvg /= parseFloat(pointStrArray.length);
		
		return [latAvg, lngAvg];
	},
	
	_getDistanceFromCenterMarker : function(poi) {
		 var p1 = new LatLon(_centerPoint.lat, _centerPoint.lng);   
		 var p2 = new LatLon(poi.point.lat, poi.point.lng);

		 return p1.distanceTo(p2) * 1000;   
	}
	
});