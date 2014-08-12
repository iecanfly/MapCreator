Territory.DAO.Block = Class.extend({
	_territoryMap : null,
	
	init : function(map) {
		this._territoryMap = map;
	},
	
	saveBlock : function(cong, block, number, coord) {
		var me = this;
		$.ajax({
			  type : "POST",
			  url : "/blocks/new",
			  data : JSON.stringify({cong: cong , block: block, number: number, coord: coord }),
              dataType : 'json',
              contentType : "application/json"
			}).done(function(msg) {
				if(msg.status == "OK") {
				     me.drawBlock({block : block, number : number, coord : coord});
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

	drawBlock : function(block) {
        _territoryMap.addBlock(block);
        _territoryMap.drawBlock(block);
        _territoryMap.initViewFilterCombo("block");
    },

	getAllBlocks : function(cong) {
		$.ajax({
			  url: "/blocks/" + cong
			}).done(function(data) {
				_territoryMap.drawBlocks(data);
			});
	},
	
	getBlocks : function(cong, block) {
		$.ajax({
			  url: "/blocks/" + cong + "/" + block
			}).done(function(msg) {
				_territoryMap.drawBlocks(msg.data);
			});
	},

	updateBlock : function(block, callback) {
        $.ajax({
            url: "/blocks/update",
            type: "POST",
                dataType : 'json',
                contentType : "application/json",
            data : JSON.stringify({ id: block.id, block: block.block, cong:block.cong, coord:block.coord, number: block.number, recommendedWorkerNum: block.recommendedWorkerNum, note: block.note })
        }).done(function(result) {
            alert(result.message);
        });
    },
	
	deleteBlock : function(id, callback) {
		$.ajax({
            url: "/blocks/delete",
            type: "POST",
            dataType : 'json',
            contentType : "application/json",
            data : id
        }).done(function(result) {
            callback(id, result);
        });
        
	}
    

});