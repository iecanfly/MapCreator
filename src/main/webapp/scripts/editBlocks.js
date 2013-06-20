Territory.EditBlock = Class.extend({
	_this : null,
	_blockDAO : null,
	_dataTable : null,

	init : function() {
		_this = this;
		_blockDAO = new Territory.DAO.Block(_this);
		_this._init();
	},

	_init : function() {
        _dataTable = $("#editTable").dataTable({
            "sScrollY": "450px",
            "bFilter": false,
            "bPaginate": false,
            "aoColumns": [
                { "sWidth": "10%" }, // 1st column width
                { "sWidth": "10%" }, // 2nd column width
                { "sWidth": "10%" }, // 3rd column width
                { "sWidth": "50%" }, // 4th column width
                { "sWidth": "10%" }, // 5th column width
                { "sWidth": "10%" } // 6th column width
            ]
        });

        $(".btnUpdate").click(function(e){
            var blockAttribute = $(this).attr("blockAttribute");
            var blockAttributeArray = blockAttribute.split(":");
            var block = [];
            block["id"] = blockAttributeArray[0];
            block["block"] = $("#txtBlock" + block["id"]).val();
            block["number"] = $("#txtNumber" + block["id"]).val();
            block["recommendedWorkerNum"] = $("#txtWorkerNum" + block["id"]).val();
            block["cong"] = blockAttributeArray[4];
            block["coord"] = blockAttributeArray[5];
            _this._updateBlock(block);
        });

        $(".btnDelete").click(function(e){
            var id = $(this).attr("blockAttribute");
             _this._deleteBlock(id);
        });
	},

	_updateBlock : function(block) {
	    _blockDAO.updateBlock(block);
	},

	_deleteBlock : function(id) {
	    _blockDAO.deleteBlock(id, _this._deleteBlockCallback);
	},

	_deleteBlockCallback : function(id, result) {
        if(result.status === "OK") {
            _dataTable.fnDeleteRow($("#tr" + id).get(0));
        } else {
            alert(result.message);
        }

	}

});
