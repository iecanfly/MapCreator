Territory.DAO.Acl = Class.extend({

	init : function() {
	},
	
    addUserToAcl : function(cong, user, callback) {
        $.ajax({
            url: "/acl/add",
            type: "POST",
            dataType : 'json',
            data : { congName: cong, userName : user}
        }).done(function(result) {
            callback(result);
        });
    }
});