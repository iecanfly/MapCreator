<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
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

    <c:if test="${isDisplayBusinessTypeInfo}">
        <div id="foodDiv"><img id="foodImg" src="/images/food.png"></div>
        <div id="clothingDiv"><img id="clothingImg" src="/images/clothing.png"></div>
        <div id="electronicsDiv"><img id="electronicsImg" src="/images/electronics.png"></div>
        <div id="etcDiv"><span id="etcSpan">其他</span></div>
    </c:if>

    <c:if test="${isDisplayColourDivision}">
        <div id="redDiv"><div id="redInnerDiv">红色</div></div>
        <div id="greenDiv"><div id="greenInnerDiv">绿色</div></div>
        <div id="blueDiv"><div id="blueInnerDiv">蓝色</div></div>
        <div id="yellowDiv"><div id="yellowInnerDiv">黄色</div></div>
        <div id="etcColDiv"><div id="etcColInnerDiv">其他</div></div>
    </c:if>

    <div id="floorTmpl" style="display:none">
        <div class="floor"><div>{floor}</div></div>
    </div>
</body>




