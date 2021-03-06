<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<script type="text/javascript">
    var blockInfo = {};
    blockInfo["blockName"] = "${block.block}";
    blockInfo["blockNumber"] = "${block.number}";
    blockInfo["coord"] = "${block.coord}";
    blockInfo["markerCoord"] = "${block.markerCoord}";
    blockInfo["printCoord"] = "${block.printCoord}";
    blockInfo["printZoomLevel"] = 15;

    var isDisplayBusInfo = ${isDisplayBusInfo};
    var printMap;

    $(document).ready(function(){
        printMap = new Territory.PrintMap("block", blockInfo);
    });
</script>

<body id="printBody">
    <div style="width: 100%; height: 100%; border:none;" id="printContainer"></div>
    <h4 id="printBlockNumberHeader">${block.block}-${block.number}</h4>
     <c:if test="${isDisplayBusInfo}">
        <div id="busInfoDiv" ></div>
     </c:if>

    <c:if test="${isDisplayBusinessTypeInfo}">
        <div id="foodDiv"><img id="foodImg" src="/images/food.png"></div>
        <div id="clothingDiv"><img id="clothingImg" src="/images/clothing.png"></div>
        <div id="electronicsDiv"><img id="electronicsImg" src="/images/electronics.png"></div>
        <div id="etcDiv"><span id="etcSpan">其他</span></div>
    </c:if>
</body>

