<%@ include file="/common/taglibs.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
    <title><fmt:message key="mapMenu.select.heading"/></title>
    <meta name="menu" content="MapMenu"/>
</head>
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
    <button id="btnGoToTerritoryMap" class="btn btn-primary" type="button">Go!</button>
  </div>
</div>
<div class="row-fluid">
  <div class="span12 pagination-centered"/><h5>or</h5></div>
</div>
<div class="row-fluid">
  <div class="span5"/></div>
  <div class="span2 pagination-centered"/><a id="btnCreateMap" href="/map-create" class="btn btn-block" type="button">Create a new one!</a></div>
  <div class="span5"/></div>
</div>


<div class="row-fluid">
   <div class="span12"/></div>
</div>
<div class="row-fluid">
   <div class="span12"/></div>
</div>
</body>


<c:set var="scripts" scope="request">
<script type="text/javascript">
    $(document).ready(function() {
        $("#e1").select2({placeholder : "<fmt:message key="mapMenu.select.heading"/>"});

        $("#btnGoToTerritoryMap").click(function(e){
            location.href = "/map/" + $("#e1").val();
        });
    });
</script>
</c:set>

