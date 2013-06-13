Territory.DAO.Block = Class.extend({
	_territoryMap : null,
	
	init : function(map) {
		this._territoryMap = map;
	},
	
	saveBlock : function(cong, block, number, coord) {
		var me = this;
		$.ajax({
			  type : "POST",
			  url : "/blocks",
			  data : JSON.stringify({cong: cong , block: block, number: number, coord: coord }),
              dataType : 'json',
              contentType : "application/json"
			}).done(function(msg) {
				if(msg.status != "OK") {
				    alert(msg.message);
				}
			}).fail(function(e){
			    alert("Unexpected error occurred. Please try again later.");
			}).always(function(e){
			    me.getAllBlocks(cong);
			});

		
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
	
	deleteBlock : function(cong, block) {
		var me = this;
		$.ajax({
			  url: "/blocks/delete/" + cong + "/" + block
			}).done(function(msg) {
				me.getAllBlocks(cong);
			});
	}
	
});