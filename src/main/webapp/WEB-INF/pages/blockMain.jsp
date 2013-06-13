<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="mapMenu.title"/></title>
    <meta name="menu" content="MapMenu"/>
</head>
<body class="home">

    <%@ include file="sidecontrol.jsp"%>
    <div id="container"></div>
    <%@ include file="/common/dialog.jsp"%>

    <script type="text/javascript">
        var territoryMap;

        function initTerritoryMap() {
            var cong = '${cong.name}';
            var zoomLevel = ${cong.zoomLevel};
            var centerCoord = '${cong.centerCoord}';
            territoryMap = new Territory.Map(cong, centerCoord, zoomLevel);
        }

        $(document).ready(function(){
            setTimeout("initTerritoryMap();", 500);
        });
    </script>

</body>

