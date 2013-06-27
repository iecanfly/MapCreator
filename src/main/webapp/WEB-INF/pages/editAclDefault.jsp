<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="editAclMenu.title"/></title>
    <meta name="menu" content="EditACLMenu"/>
</head>
<body class="home">
    <div class="row-fluid">
       <div class="span12"/></div>
    </div>
    <div class="row-fluid">
       <div class="span12"/></div>
    </div>

    <body>
    <div class="row-fluid">
      <div class="span12 pagination-centered">
        <select id="e1">
            <c:forEach var="cong" items="${congList}">
                <option value="${cong.name}">${cong.name}</option>
            </c:forEach>
        </select>
        <button id="btnGoToEditScreen" class="btn btn-primary" type="button">Edit Access Control List</button>
      </div>
    </div>

    <div class="row-fluid">
       <div class="span12"/></div>
    </div>
    <div class="row-fluid">
        <div class="span12"/>
    </div>

</body>

<c:set var="scripts" scope="request">
<script type="text/javascript">
    $(document).ready(function() {
        $("#e1").select2();

        $("#btnGoToEditScreen").click(function(e){
            location.href = "/acl/edit/" + $("#e1").val();
        });
    });
</script>
</c:set>



