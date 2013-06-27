Territory.EditAcl = Class.extend({
	_this : null,
	_aclDAO : null,
    _cong : null,

	init : function(cong) {
		_this = this;
		_aclDAO = new Territory.DAO.Acl();
		_this._init();
	},

	_init : function() {

        $("#btnAddUser").click(function(e){
            _this._addUserToAcl();
        });

	},

    _addUserToAcl : function() {
	    _aclDAO.addUserToAcl(cong, $("#selectAllUsers").val(), _this.addUserToAclCallback);
	},

    addUserToAclCallback : function(result) {
        if(result.status === "OK") {
            $('#userList').append($("<option/>", {
                value: $("#selectAllUsers").val(),
                text: $("#selectAllUsers").val()
            }));

        } else {
            alert(result.message);
        }

    }
});
