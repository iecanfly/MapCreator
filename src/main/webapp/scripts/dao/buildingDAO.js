Territory.DAO.Building = Class.extend({
	_territoryMap : null,
	
	init : function(map) {
		this._territoryMap = map;
	},

	saveBuilding : function(cong, buildingBlock, buildingNumber, buildingName, buildingAddress, floor, pt) {
		var me = this;
		$.ajax({
			  type : "POST",
			  url : "/buildings/new",
			  data : JSON.stringify({cong: cong , block: buildingBlock, number: buildingNumber, name: buildingName, address: buildingAddress, floor: floor, coord: pt }),
              dataType : 'json',
              contentType : "application/json"
			}).done(function(msg) {
				if(msg.status == "OK") {
				    me.refreshMap();
				} else {
				    alert(msg.message);
				}
			}).fail(function(e){
			    alert("Unexpected error occurred. Please try again later.");
			});
	},

	refreshMap : function() {
	    _territoryMap.refreshMap();
	},
	
	addBuilding : function(block, number, buildingName, pt) {
		_territoryMap.addBuilding(block, number, buildingName, pt);
	},

	getAllBuildings : function(cong, buildingBlock) {
        $.ajax({
              url: "/buildings/" + cong
            }).done(function(msg) {
                _territoryMap.drawBuildings(msg);
            });
    },
	
	getBuildings : function(cong, buildingBlock) {
		$.ajax({
			  url: "/buildings/" + cong + "/" + buildingBlock
			}).done(function(msg) {
				_territoryMap.drawBuildings(msg.data);
			});
	},

	updateBuilding : function(building, callback) {
        $.ajax({
            url: "/buildings/update",
            type: "POST",
            dataType : 'json',
            contentType : "application/json",
            data : JSON.stringify({ id: building.id, cong: building.cong, block: building.block, number: building.number, name: building.name, address: building.address, floor: building.floor,coord: building.coord, recommendedWorkerNum: building.recommendedWorkerNum, note: building.note })
        }).done(function(result) {
            alert(result.message);
        });
    },
	
	deleteBuiding : function(id, callback) {
		$.ajax({
            url: "/buildings/delete",
            type: "POST",
            dataType : 'json',
            contentType : "application/json",
            data : id
        }).done(function(result) {
            callback(id, result);
        });
        
	}
});