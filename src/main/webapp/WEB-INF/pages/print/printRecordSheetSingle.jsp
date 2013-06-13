<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<script type="text/javascript">
    var blockInfo = {};
    blockInfo["blockName"] = "${block.block}";
    blockInfo["blockNumber"] = "${block.number}";
    blockInfo["coord"] = "${block.coord}";
    blockInfo["markerCoord"] = "${block.markerCoord}";
    blockInfo["printCoord"] = "${block.printCoord}";
    blockInfo["printZoomLevel"] = "${block.printZoomLevel}";
    blockInfo["lastWorkedDate"] = "${block.lastWorkedDate}";

    var printMap;

    $(document).ready(function(){
        printMap = new Territory.PrintMap(blockInfo);
    });
</script>

<body id="printBody">
    <div style="width: 100%; height: 100%; border:none;" id="printContainer"></div>
    <h4 style="height:45px;width:120px;text-align:center; border:2px solid; background-color:white; position:absolute;top: -35px;left: 5px;font-size: 200%">${block.block}-${block.number}</h4>
    <span class="recommendedWorkerNumSpan" style="position:absolute;top:512px;left: 3px;padding:3px 3px 3px 3px;">
        <img src="/images/num_people.png">
    </span>
    <span style="font-family: Microsoft YaHei;font-size:150%;position:absolute;top:513px;left: 51px;" >${block.recommendedWorkerNum}</span>
    <div id="busInfoDiv" style="width: 95px; border:1px solid;background-color:white; position:absolute;top:5px;left: 690px;font-size: 68%;font-family: Microsoft YaHei;padding:3px 3px 3px 3px;"></div>
    <span id="lastWorkedDateSpan"  style="width:110px;border:1px solid;background-color:white; position:absolute;top:520px;left: 675px;font-size: 60%;font-family: Microsoft YaHei;padding:3px 3px 3px 3px;">最近工作日:${block.lastWorkedDateString}</span>
</body>


