<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
    var blockInfo = {};
    blockInfo["blockName"] = "${block.block}";
    blockInfo["blockNumber"] = "${block.number}";
    blockInfo["coord"] = "${block.coord}";
    blockInfo["markerCoord"] = "${block.markerCoord}";
    blockInfo["printCoord"] = "${block.printCoord}";
    blockInfo["printZoomLevel"] = "${block.printZoomLevel}";

    var isDisplayBusInfo = ${isDisplayBusInfo};
    var printMap;

    $(document).ready(function(){
        printMap = new Territory.PrintMap("block", blockInfo);
    });
</script>


<body id="printBody">
    <div style="width: 100%; height: 100%; border:none;" id="printContainer"></div>
    <h4 id="printBlockNumberHeader">${block.block}-${block.number}</h4>
    <span id="recommendedWorkerImageSpan">
        <img src="/images/num_people.png">
    </span>
    <span id="recommendedWorkerSpan">${block.recommendedWorkerNum}</span>
    <c:if test="${isDisplayBusInfo}">
        <div id="busInfoDiv"></div>
    </c:if>
    <c:if test="${not empty block.note}">
        <div id="noteDiv">${block.note}</div>
    </c:if>
</body>


