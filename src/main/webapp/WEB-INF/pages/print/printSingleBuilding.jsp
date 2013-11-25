<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
    var buildingInfo = {};
    buildingInfo["blockName"] = "${building.block}";
    buildingInfo["blockNumber"] = "${building.number}";
    buildingInfo["name"] = "${building.name}";
    buildingInfo["address"] = "${building.address}";
    buildingInfo["floor"] = "${building.floor}";
    buildingInfo["coord"] = "${building.coord}";
    buildingInfo["note"] = "${building.note}";
    buildingInfo["printZoomLevel"] = 18;

    var isDisplayBusInfo = ${isDisplayBusInfo};
    var printMap;

    $(document).ready(function(){
        printMap = new Territory.PrintMap("building", buildingInfo);
    });
</script>


<body id="printBody">
    <div style="width: 100%; height: 100%; border:none;" id="printContainer"></div>
    <h4 id="printBlockNumberHeader">${building.block}-${building.number}</h4>
    <div id="printBuildingInfoDiv"><span>${building.name}, ${building.address}</span></div>
    <span id="recommendedWorkerImageSpan">
        <img src="/images/num_people.png">
    </span>

    <div id="floorInfoDiv"></div>

    <span id="recommendedWorkerSpan">${building.recommendedWorkerNum}</span>
    <c:if test="${isDisplayBusInfo}">
        <div id="busInfoDiv"></div>
    </c:if>
    <c:if test="${not empty building.note}">
        <div id="noteDiv">${building.note}</div>
    </c:if>

    <div id="floorTmpl" style="display:none">
        <div class="floor"><div>{floor}</div><div>
    </div>
</body>




