Territory.EditBuilding = Class.extend({
	_this : null,
	_buildingDAO : null,
	_dataTable : null,

	init : function() {
		_this = this;
		_buildingDAO = new Territory.DAO.Building(_this);
		_this._init();
	},

	_init : function() {
        _dataTable = $("#editTable").dataTable({
            "sScrollY": "450px",
            "bFilter": false,
            "aaSorting": [],
            "bPaginate": false,
            "aoColumns": [
                { "sWidth": "5%" }, // id
                { "sWidth": "5%" }, // block
                { "sWidth": "5%" }, // number
                { "sWidth": "10%" }, // name
                { "sWidth": "15%" }, // address
                { "sWidth": "15%" }, // floor
                { "sWidth": "5%" }, // recommended worker #
                { "sWidth": "30%" }, // note
                { "sWidth": "5%" }, // update
                { "sWidth": "5%" } // delete
            ]
        });

        $(".btnUpdate").click(function(e){
            var buildingAttribute = $(this).attr("buildingAttribute");
            var buildingAttributeArray = buildingAttribute.split(":");
            var building = [];
            building["id"] = buildingAttributeArray[0];
            building["block"] = $("#txtBlock" + building["id"]).val();
            building["number"] = $("#txtNumber" + building["id"]).val();
            building["name"] = $("#txtName" + building["id"]).val();
            building["address"] = $("#txtAddress" + building["id"]).val();
            building["floor"] = $("#txtFloor" + building["id"]).val();
            building["recommendedWorkerNum"] = $("#txtWorkerNum" + building["id"]).val();
            building["note"] = $("#txtNote" + building["id"]).val();
            building["cong"] = buildingAttributeArray[7];
            building["coord"] = buildingAttributeArray[8];
            _this._updateBuilding(building);
        });

        $(".btnDelete").click(function(e){
            var id = $(this).attr("buildingAttribute");
             _this._deleteBuilding(id);
        });
	},

	_updateBuilding : function(building) {
	    _buildingDAO.updateBuilding(building);
	},

	_deleteBlock : function(id) {
	    _buildingDAO.deleteBuilding(id, _this._deleteBuildingCallback);
	},

	_deleteBuildingCallback : function(id, result) {
        if(result.status === "OK") {
            _dataTable.fnDeleteRow($("#tr" + id).get(0));
        } else {
            alert(result.message);
        }

	}

});
