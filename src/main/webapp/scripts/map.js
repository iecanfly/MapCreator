Territory.Map = Class.extend({
	DEFAULT_CURSOR : null,
	BUILDING_CURSOR : null,
	BLOCK : null,
	BUILDING : null,
	NON_DRAWING : null,
	_this : null,
	_map : null,
	_myDis : null,
	_blockDAO : null,
	_buildingDAO : null,
	_recordDAO : null,
	_congDAO : null,
	_dialogue : null,
	_cong : null,
	_centerCoord : null,
	_zoomLevel : null,
	_blocks : null,
	_buildings : null,
	_currentBlock : null,
    _currentDrawingMode : null,

	init : function(cong, centerCoord, zoomLevel) {
	    DEFAULT_CURSOR = "url(http://api0.map.bdimg.com/images/openhand.cur) 8 8,default";
        BUILDING_CURSOR = "url('../images/building-icon.png')25 23, default";
        BLOCK = "block";
        BUILDING = "building";
        NON_DRAWING = "non_drawing";

		_this = this;
		_cong = cong;
		_centerCoord = centerCoord;
		_zoomLevel = zoomLevel;
		_map = new BMap.Map("container", {enableHighResolution : true});
		_map.addControl(new BMap.ScaleControl());
		_map.addControl(new BMap.NavigationControl());
		_map.addControl(new BMap.OverviewMapControl());
		_map.addControl(new BMap.MapTypeControl());
		_map.enableScrollWheelZoom();
		_map.disableDoubleClickZoom();

		_myDis = new BMapLib.DistanceTool(_map);
		_myDis.addEventListener("drawend", function(e) {
		        _this._openSaveBlockDialogue(e.points);
		    });

		_blockDAO = new Territory.DAO.Block(_this);
		_buildingDAO = new Territory.DAO.Building(_this);
		_recordDAO = new Territory.DAO.Record(_this);
		_congDAO = new Territory.DAO.Cong(_this);
		_dialogue = new Territory.Dialogue(_cong, _this);

		_this._init();
	},
	
	_initViewFilterCombo : function(type, data) {
	    var seperator = $("#viewFilterSeperatorTmpl").html();
	    var currentComboHTML = $("#cboViewFilter").html();
	    var currentComboBlockHTML = currentComboHTML.split(seperator)[0];
	    var currentComboBuildingHTML = currentComboHTML.split(seperator)[1];

        $("#cboViewFilter").unbind("change");
        $("#cboViewFilter").on("change", function(){
            _this._filterBlocks($("#cboViewFilter option:selected").attr("class"), this.value);
        });

	    if(type == BLOCK) {
	        var uniqueBlockNames = this._getUniqueBlockNames(data);
            var options = $("#viewFilterBlockOptionTmpl").html().replace(/{val}/gi, "").replace(/{name}/gi, "View All");

            for(var i = 0; i < uniqueBlockNames.length; i++) {
                options = options + $("#viewFilterBlockOptionTmpl").html().replace(/{val}/gi, uniqueBlockNames[i]).replace(/{name}/gi, uniqueBlockNames[i]);
            }

            options = options + seperator + currentComboBuildingHTML;
            $("#cboViewFilter").html(options);
	    } else if(type == BUILDING) {
            var uniqueBlockNames = this._getUniqueBlockNames(data);
            var options = currentComboBlockHTML +  seperator;

            for(var i = 0; i < uniqueBlockNames.length; i++) {
                options = options + $("#viewFilterBuildingOptionTmpl").html().replace(/{val}/gi, uniqueBlockNames[i]).replace(/{name}/gi, uniqueBlockNames[i]);
            }

            $("#cboViewFilter").html(options);
	    }

	},

	saveBlock : function(block, number, pts) {
		var coord = "";
		for ( var i = 0; i < pts.length; i++) {
			coord = coord.concat(pts[i]["lat"]  + "," + pts[i]["lng"] );
			if (i !== pts.length - 1) {
				coord = coord.concat(";");
			}
		}
		_blockDAO.saveBlock(_cong, block,number, coord);
	},

	saveBuilding : function(buildingBlock, buildingNumber, buildingName, buildingAddress, floor, pt) {
        _buildingDAO.saveBuilding(_cong, buildingBlock, buildingNumber, buildingName, buildingAddress, floor, pt["lat"]  + "," + pt["lng"]);
    },

	_openSaveBlockDialogue : function(pts) {
	    if(_currentDrawingMode == BLOCK) {
	        _dialogue.openSaveBlockDialogue(pts);
	    }
	},
	
	openBlockViewCoverage : function() {
		window.open("/coverage/blockView/" + _cong + "/" + $("#coverageFromDate").val());
	},
	
	openChartViewCoverage : function() {
		window.open("/coverage/chartView/" + _cong + "/" + $("#coverageFromDate").val());
	},
	
	openPrintBlocksDialogue : function() {
		_dialogue.openPrintBlocksDialogue(_this._blocks);
	},

    openPrintBuildingsDialogue : function() {
        _dialogue.openPrintBuildingsDialogue(_this._buildings);
    },

	startDrawingBlocks : function() {
	    _this._changeDrawingMode(BLOCK);
		_myDis.open();
	},

	startDrawingBuildings : function() {
	   _this._changeDrawingMode(BUILDING);
    },

	_finishDrawingBuildings : function(e) {
		_this._buildingMarkEnd(e);
		_this._changeDrawingMode(NON_DRAWING);
	},

	_changeDrawingMode : function(drawingMode) {
	    _currentDrawingMode = drawingMode;

	    if(_currentDrawingMode == BLOCK) {
            _map.removeEventListener("dblclick", _this._finishDrawingBuildings);
            _map.setDefaultCursor(DEFAULT_CURSOR);
	    } else if(_currentDrawingMode == BUILDING) {
	        _myDis.close();
	        _map.addEventListener("dblclick", _this._finishDrawingBuildings);
            _map.setDefaultCursor(BUILDING_CURSOR);
	    } else if(_currentDrawingMode == NON_DRAWING) {
	        _map.removeEventListener("dblclick", _this._finishDrawingBuildings);
            _map.setDefaultCursor(DEFAULT_CURSOR);
            _myDis.close();
	    }
	},

	_buildingMarkEnd : function(e) {
        _dialogue.openSaveBuildingDialogue(e.point);
	},

	_init : function() {
		_this._centerAndZoom(_centerCoord, _zoomLevel);
		_this.refreshMap();
	},
	
	_centerAndZoom : function(centerCoord, zoomLevel) {
		var lat = centerCoord.split(",")[0];
        var lng = centerCoord.split(",")[1];
        _map.centerAndZoom(new BMap.Point(parseFloat(lng), parseFloat(lat)), parseInt(zoomLevel));
	},

	refreshMap : function() {
        _map.clearOverlays();
		_blockDAO.getAllBlocks(_cong);
		_buildingDAO.getAllBuildings(_cong);
	},
	
	_filterBlocks : function(type, blockName) {
		if(blockName === "") {
			_this._init();
			return;
		}

        _map.clearOverlays();
        var centerPoint;
        var appendedCoord = "";

        if(type == BLOCK) {
            for (var i = 0; i < _this._blocks.length; i++) {
                var block = _this._blocks[i];
                if(block.block === blockName) {
                    _this.drawBlock(block.block, block.number, block.coord);
                    appendedCoord = appendedCoord + block.coord;
                }
            }

            centerPoint = _this._findMarkerPosition(appendedCoord);
        } else if(type == BUILDING) {
            for (var i = 0; i < _this._buildings.length; i++) {
                var building = _this._buildings[i];
                if(building.block === blockName) {
                    _this.drawBuilding(building.block, building.number, building.name, building.coord);
                    appendedCoord = appendedCoord + building.coord;
                }
            }

            centerPoint = _this._findMarkerPosition(appendedCoord);
        }

        _map.centerAndZoom(new BMap.Point(centerPoint[0], centerPoint[1]), _map.getZoom());
	},

	drawBlocks : function(data) {
		_this._blocks = data;

		for ( var i = 0; i < _this._blocks.length; i++) {
			var block = _this._blocks[i];
			_this.drawBlock(block.block, block.number, block.coord);
		}

		_this._initViewFilterCombo(BLOCK, _this._blocks);
	},

	drawBlock : function(block, number, pts) {
		var pointStrArray = pts.split(";");
		var pointArray = [];

		for ( var i = 0; i < pointStrArray.length; i++) {
			var point = new BMap.Point(pointStrArray[i].split(",")[1], pointStrArray[i].split(",")[0]);
			pointArray.push(point);
		}

		_this._drawPolygon(pointArray);
		_this._drawBlockMarker(block, number, pts);
	},

	drawBuildings : function(data) {
        _this._buildings = data;

        for ( var i = 0; i < _this._buildings.length; i++) {
            var building = _this._buildings[i];
            _this.drawBuilding(building.block, building.number, building.name, building.coord);
        }

        _this._initViewFilterCombo(BUILDING, _this._buildings);
    },

    drawBuilding : function(block, number, name, pt) {
        _this.addBuilding(block, number, name, pt);
    },

	_drawPolygon : function(pts) {
		var ply = new BMap.Polygon(pts);
		_map.addOverlay(ply);
	},
	
	showRecords : function(data) {
		_dialogue.openViewRecordDialogue(data);
	},

	addBuilding : function(block, number, buildingName, pt) {
	    var lat = pt.split(",")[0];
        var lng = pt.split(",")[1];
        var mkr = new BMap.Marker(new BMap.Point(parseFloat(lng), parseFloat(lat)) , {icon: new BMap.Icon("../images/building-icon.png", new BMap.Size(50, 55))});
        var lbl = new BMap.Label(block + "-" + number + ":" + buildingName, { offset : new BMap.Size(12, -20) });
        lbl.setStyle({ border : "solid 1px gray" });
        mkr.setLabel(lbl);
        _map.addOverlay(mkr);
	},

	_getMarkerContextMenu : function() {
		var contextMenu = new BMap.ContextMenu();
		var txtMenuItem = [];
		txtMenuItem["writeRecord"] = { 
			text : 'Write Record',
			callback : function() {
				_dialogue.openSaveRecordDialogue(_currentBlock);
			}
		};
		
		txtMenuItem["returnCard"] = { 
				text : 'Return Card',
				callback : function() {
					_dialogue.openReturnCardDialogue(_currentBlock);
				}
		};
		
		txtMenuItem["viewRecord"] = {
			text : 'View record',
			callback : function() {
				_recordDAO.getBlockRecords(_cong, _currentBlock);
			}
		};
		
		txtMenuItem["deleteBlock"] = {
			text : 'Delete Block',
			callback : function() {
				if(confirm("Are you sure you want to Delete?")) {
					_blockDAO.deleteBlock(_cong, _currentBlock);
				}
			}
		};

		contextMenu.addItem(new BMap.MenuItem(txtMenuItem["writeRecord"].text, txtMenuItem["writeRecord"].callback, 100));
		contextMenu.addItem(new BMap.MenuItem(txtMenuItem["returnCard"].text, txtMenuItem["returnCard"].callback, 100));
		contextMenu.addItem(new BMap.MenuItem(txtMenuItem["viewRecord"].text, txtMenuItem["viewRecord"].callback, 100));
		contextMenu.addSeparator();
		contextMenu.addItem(new BMap.MenuItem(txtMenuItem["deleteBlock"].text, txtMenuItem["deleteBlock"].callback, 100));

		return contextMenu;
	},

	saveWorkRecord : function(record) {
		_recordDAO.saveRecord(record);
	},
	
	returnCard : function(record) {
		_recordDAO.returnCard(record);
	},

	_drawBlockMarker : function(block, number, pts) {
		var markerPosition = _this._findMarkerPosition(pts);
		var icon = new BMap.Icon("/images/red_marker.png", new BMap.Size(14,23))
		var mkr = new BMap.Marker(new BMap.Point(markerPosition[0],	markerPosition[1]));
		mkr.addContextMenu(_this._getMarkerContextMenu());
		mkr.addEventListener("rightclick", function() {
			_currentBlock = this._config.label.content;
		})
		mkr.setIcon(icon);

		var lbl = new BMap.Label(block + "-" + number, { offset : new BMap.Size(20, 1) });
		lbl.setStyle({ border : "solid 1px gray" });
		mkr.setLabel(lbl);
		_map.addOverlay(mkr);
	},

	_findMarkerPosition : function(pts) {
		var pointStrArray = pts.split(";");
		var latAvg = 0.0;
		var lngAvg = 0.0;

		for ( var i = 0; i < pointStrArray.length; i++) {
			latAvg += parseFloat(pointStrArray[i].split(",")[1]);
			lngAvg += parseFloat(pointStrArray[i].split(",")[0]);
		}

		latAvg /= parseFloat(pointStrArray.length);
		lngAvg /= parseFloat(pointStrArray.length);

		return [ latAvg, lngAvg ];
	},
	
	_getUniqueBlockNames : function(blocks) {
		var currentBlock = "";
		var blockNameArray = [];
		for(var i = 0; i < blocks.length; i++) {
			if(currentBlock != blocks[i].block) {
				blockNameArray.push(blocks[i].block);
			}
			
			currentBlock = blocks[i].block;
		}
		
		return blockNameArray;
	}

});
