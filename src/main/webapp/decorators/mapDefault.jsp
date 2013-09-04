<!DOCTYPE html>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<html lang="en">
<head>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<c:url value="/images/favicon.ico"/>"/>
    <title><decorator:title/> | <fmt:message key="webapp.name"/></title>

    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/lib/bootstrap.min.css'/>" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/lib/bootstrap-responsive-2.2.1.min.css'/>" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/datepicker/css/datepicker.css'/>" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/style.css'/>" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/lib/select2/select2.css'/>" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/main.css'/>" />

    <decorator:head/>

    <script type="text/javascript">
        var Territory = Territory || {};
        Territory.DAO = {};
    </script>

    <script type="text/javascript" src="<c:url value='/scripts/lib/jquery-1.8.2.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/bootstrap.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/datepicker/js/bootstrap-datepicker.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/plugins/jquery.cookie.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/script.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/lib/select2/select2.js'/>"></script>

    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=7a47709620e13098e9ac9539b39ddf9a"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/DistanceTool/1.2/src/DistanceTool_min.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/GeoUtils/1.2/src/GeoUtils_min.js"></script>
    <script type="text/javascript" src="<c:url value='/scripts/classHelper.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/printPage.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/createMap.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/createCong.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/dialogue.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/dao/congDAO.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/dao/blockDAO.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/dao/recordDAO.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/map.js'/>"></script>

</head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>
    <c:set var="currentMenu" scope="request"><decorator:getProperty property="meta.menu"/></c:set>

    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container-fluid">
                <%-- For smartphones and smaller screens --%>
                <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="brand" href="<c:url value='/'/>"><fmt:message key="webapp.name"/></a>
                <%@ include file="/common/menu.jsp" %>
                <c:if test="${pageContext.request.locale.language ne 'en'}">
                    <div id="switchLocale"><a href="<c:url value='/?locale=en'/>">
                        <fmt:message key="webapp.name"/> in English</a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>

    <decorator:body/>

    <div id="footer">
            <span class="left"><fmt:message key="webapp.version"/>
                <c:if test="${pageContext.request.remoteUser != null}">
                | <fmt:message key="user.status"/> ${pageContext.request.remoteUser}
                </c:if>
            </span>
            <span class="right">
                &copy; <fmt:message key="copyright.year"/> <a href="<fmt:message key="company.url"/>"><fmt:message key="company.name"/></a>
            </span>
        </div>

    <%= (request.getAttribute("scripts") != null) ?  request.getAttribute("scripts") : "" %>
</body>
</html>
