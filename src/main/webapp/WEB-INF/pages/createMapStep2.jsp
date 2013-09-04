<%@ include file="/common/taglibs.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
    <title><fmt:message key="mapMenu.select.heading"/></title>
    <meta name="menu" content="MapMenu"/>
</head>


<body>
<div id="sideControl" class="span3">
    <div class="input-prepend">
        <span class="add-on">Latitude</span>
        <input class="span2" id="inputLat" type="text" readonly>
    </div>
    <div class="input-prepend">
        <span class="add-on">Longitude</span>
        <input class="span2" id="inputLng" type="text" readonly>
    </div>
    <div class="input-prepend">
        <span class="add-on">Zoom Level</span>
        <input class="span2" id="inputZoom" type="text" readonly>
    </div>

    <button class="btn" onclick="newCong.saveCong();">Save Location</button>

</div>
<div style="border:1px solid gray;" id="firstContainer">
</div>

<div class="row-fluid">
   <div class="span12 pagination-centered">
        <div class="pagination">
          <ul>
            <li><a href="#">&laquo;</a></li>
            <li><a href="#">1</a></li>
            <li class="disabled"><a href="#">2</a></li>
            <li><a href="#">&raquo;</a></li>
          </ul>
        </div>
   </div>
</div>
</body>


<c:set var="scripts" scope="request">
<script type="text/javascript">
    var cong = '${cong}';
    var newCong;
    $(document).ready(function(){
        newCong = new Territory.NewCong();
    });
</script>
</c:set>

