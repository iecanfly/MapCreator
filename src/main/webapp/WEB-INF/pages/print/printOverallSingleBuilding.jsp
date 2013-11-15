<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
    var buildingInfo = {};
    buildingInfo["blockName"] = "${building.block}";
    buildingInfo["blockNumber"] = "${building.number}";
    buildingInfo["name"] = "${building.name}";
    buildingInfo["address"] = "${building.address}";
    buildingInfo["floor"] = "${building.floor}";
    buildingInfo["coord"] = "${building.coord}";
    buildingInfo["note"] = "${building.note}";
    buildingInfo["printZoomLevel"] = 15;

    var isDisplayBusInfo = ${isDisplayBusInfo};
    var printMap;

    $(document).ready(function(){
        printMap = new Territory.PrintMap("building", buildingInfo);
    });
</script>

<body id="printBody">
    <div style="width: 100%; height: 100%; border:none;" id="printContainer"></div>
    <h4 id="printBlockNumberHeader">${building.block}-${building.number}</h4>
     <c:if test="${isDisplayBusInfo}">
        <div id="busInfoDiv"></div>
     </c:if>
</body>

