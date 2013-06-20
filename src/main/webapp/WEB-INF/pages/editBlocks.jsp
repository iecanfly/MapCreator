<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="editBlockMenu.title"/></title>
    <meta name="menu" content="EditBlockMenu"/>
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
                        <th>Recommended Worker #</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="block" items="${blockList}">
                    <tr id="tr${block.id}">
                        <td>${block.id}</td>
                        <td><input id="txtBlock${block.id}" class="input-mini input-narrow" type="text" value="${block.block}"></td>
                        <td><input id="txtNumber${block.id}" class="input-mini input-narrow" type="text" value="${block.number}"></td>
                        <td><input id="txtWorkerNum${block.id}" class="input-mini input-narrow" type="text" value="${block.recommendedWorkerNum}"></td>
                        <td><button blockAttribute="${block.id}:${block.block}:${block.number}:${block.recommendedWorkerNum}:${block.cong}:${block.coord}" class="btnUpdate btn btn-small" type="button">Update</button></td>
                        <td><button blockAttribute="${block.id}" class="btnDelete btn btn-primary btn-small" type="button">Delete</button></td>
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
        new Territory.EditBlock();
    });
</script>
</c:set>