<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="editBuildingMenu.title"/></title>
    <meta name="menu" content="EditBuildingMenu"/>
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
        <button id="btnGoToEditScreen" class="btn btn-primary" type="button">Edit Buildings</button>
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
        $("#e1").select2({placeholder : "<fmt:message key="mapMenu.select.heading"/>"});

        $("#btnGoToEditScreen").click(function(e){
            location.href = "/buildings/edit/" + $("#e1").val();
        });
    });
</script>
</c:set>



