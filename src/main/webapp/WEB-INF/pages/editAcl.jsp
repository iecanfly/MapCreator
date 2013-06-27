<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="editAclMenu.title"/></title>
    <meta name="menu" content="EditACLMenu"/>
</head>
<body class="home">
    <div class="row-fluid">
        <div class="span4"></div>
        <div class="span3">
            <select id="selectAllUsers">
                <c:forEach var="user" items="${allUserList}">
                    <option value="${user.username}">${user.username}</option>
                </c:forEach>
            </select>
            <button id="btnAddUser" class="btn btn-primary" type="button">Add User</button>
        </div>
        <div class="span5"></div>
    </div>
    <div class="row-fluid">
        <div class="span12"> </div>
    </div>
    <div class="row-fluid">
        <div class="span4"></div>
        <div class="span3">
            <select id="userList" name="userList" multiple="true">
                <c:forEach items="${userList}" var="user">
                    <option value="${user.username}">${user.username}</option>
                </c:forEach>
            </select>
        </div>
        <div class="span5"></div>
    </div>

</body>

<c:set var="scripts" scope="request">
<script type="text/javascript">
    var cong = "${cong}";
    $(document).ready(function() {
        $("#selectAllUsers").select2();
    });

    var editAcl = new Territory.EditAcl(cong);


</script>
</c:set>



