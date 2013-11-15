<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="editBuildingMenu.title"/></title>
    <meta name="menu" content="EditBuildingMenu"/>
</head>
<body>
    <div class="row-fluid">
       <div class="span12"/></div>
    </div>
    <div class="row-fluid">
        <div class="span12">
            <table id="editTable" class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Block</th>
                        <th>Number</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Floor Info</th>
                        <th>Recommended Worker #</th>
                        <th>Note</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="building" items="${buildingList}">
                    <tr id="tr${building.id}">
                        <td>${building.id}</td>
                        <td><input id="txtBlock${building.id}" class="input-mini input-narrow" type="text" value="${building.block}"></td>
                        <td><input id="txtNumber${building.id}" class="input-mini input-narrow" type="text" value="${building.number}"></td>
                        <td><input id="txtName${building.id}" class="input-small input-narrow" type="text" value="${building.name}"></td>
                        <td><input id="txtAddress${building.id}" class="input-small input-narrow" type="text" value="${building.address}"></td>
                        <td><input id="txtFloor${building.id}" class="input-small input-narrow" type="text" value="${building.floor}"></td>
                        <td><input id="txtWorkerNum${building.id}" class="input-mini input-narrow" type="text" value="${building.recommendedWorkerNum}"></td>
                        <td><input id="txtNote${building.id}" class="input-xxlarge input-narrow" type="text" value="${building.note}"></td>
                        <td><button buildingAttribute="${building.id}:${building.block}:${building.number}:${building.name}:${building.address}:${building.floor}:${building.recommendedWorkerNum}:${building.cong}:${building.coord}" class="btnUpdate btn btn-small" type="button">Update</button></td>
                        <td><button buildingAttribute="${building.id}" class="btnDelete btn btn-primary btn-small" type="button">Delete</button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>


<c:set var="scripts" scope="request">
<script type="text/javascript">
    $(document).ready(function() {
        new Territory.EditBuilding();
    });
</script>
</c:set>