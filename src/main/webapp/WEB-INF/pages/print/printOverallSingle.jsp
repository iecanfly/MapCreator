<script type="text/javascript">
    var blockInfo = {};
    blockInfo["blockName"] = "${block.block}";
    blockInfo["blockNumber"] = "${block.number}";
    blockInfo["coord"] = "${block.coord}";
    blockInfo["markerCoord"] = "${block.markerCoord}";
    blockInfo["printCoord"] = "${block.printCoord}";
    blockInfo["printZoomLevel"] = 15;

    var printMap;

    $(document).ready(function(){
        printMap = new Territory.PrintMapOverall(blockInfo);
    });
</script>

<body id="printBody">
    <div style="width: 100%; height: 100%; border:none;" id="printContainer"></div>
    <h4 style="height:45px;width:120px;text-align:center; border:2px solid; background-color:white; position:absolute;top: -35px;left: 5px;font-size: 200%">${block.block}-${block.number}</h4>

</body>

