<!DOCTYPE html>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<html style="overflow: hidden">
    <head>
        <title>${block.block}-${block.number}</title>
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=1.2"></script>
		<script type="text/javascript" src="http://api.map.baidu.com/library/DistanceTool/1.2/src/DistanceTool_min.js"></script>
		<script type="text/javascript" src="http://api.map.baidu.com/library/GeoUtils/1.2/src/GeoUtils_min.js"></script>
		<link rel="stylesheet" media="screen" href="<c:url value='/styles/main.css'/>">
		<script type="text/javascript" src="<c:url value='/scripts/lib/jquery-1.8.2.min.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/lib/jquery-ui-1.8.18.min.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/classHelper.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/latlon.js'/>"></script>
		<!-- DO NOT CHANGE THE ORDER OF JS! map.js should be on top of other custom made js files -->
		<script type="text/javascript" src="<c:url value='/scripts/printMapOverall.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/printMap.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/printPage.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/dao/blockDAO.js'/>"></script>
        <script type="text/javascript">
            <decorator:head/>
        </script>

    </head>
    <body>
        <decorator:body/>
    </body>
</html>