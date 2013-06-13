var Territory = Territory || {};
Territory.DAO = {};

Territory.CreateMap = Class.extend({
	_this : null,
	_congDAO : null,

	init : function() {
		_this = this;
		_congDAO = new Territory.DAO.Cong(_this);
		_this._initEvents();
	},

	_initEvents : function() {
        $("#e1").select2({placeholder : placeholder});

        $("#btnGoToTerritoryMap").click(function(e){
            location.href = "/map/" + $("#e1").val();
        });

        $("#btnCreateURL").click(function(e){
            var cong = $("#txtURL").val();
            if(cong == "") {
                alert("The field cannot be empty!");
                return;
            }

            _congDAO.checkCong(cong, _this.displayResultAlert);
        });
	},

	displayResultAlert : function(status) {
        if(status == "OK") {
            _this.displaySuccess();
        } else {
            _this.displayAlreadyExists();
        }
	},

	displayAlreadyExists : function() {
	    $("#divInfoText").hide();
	    $("#divWarningText").show();
	    $("#divSuccessText").hide();
	},

	displaySuccess : function() {
	    $("#divInfoText").hide();
        $("#divWarningText").hide();
        $("#divSuccessText").show();
        location.href = "/map-create/" + $("#txtURL").val();
	}

});
