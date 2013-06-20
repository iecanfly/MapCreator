<%@ include file="/common/taglibs.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
    <title><fmt:message key="mapMenu.select.heading"/></title>
    <meta name="menu" content="MapMenu"/>
</head>


<body>

<div class="row-fluid">
   <div class="span12"/></div>
</div>
<div class="row-fluid">
    <div class="span3"/></div>
    <div class="span6 pagination-centered"/>
        <div id="divInfoText" class="alert alert-info text-">
            <fmt:message key="mapMenu.url.type.message"/>
        </div>
        <div id="divWarningText" class="alert alert-warning" style="display:none">
            <fmt:message key="mapMenu.url.alreadyexists.message"/>
        </div>
        <div id="divSuccessText" class="alert alert-success"  style="display:none">
            <fmt:message key="mapMenu.url.success.message"/>
        </div>
    </div>
    <div class="span3"/></div>
</div>

<div class="row-fluid">
    <div class="span3"/></div>
    <div class="span6 pagination-centered"/>
        <div class="input-prepend input-append">
            <span class="add-on"><fmt:message key="webapp.url"/></span>
            <input id="txtURL" type="text" placeholder="URL..."/>
            <button id="btnCreateURL" class="btn" type="button">Create URL</button>
        </div>

    </div>
    <div class="span3"/></div>
</div>


<div class="row-fluid">
   <div class="span12"/></div>
</div>

<div class="row-fluid">
   <div class="span12 pagination-centered">
        <div class="pagination">
          <ul>
            <li><a href="#">&laquo;</a></li>
            <li class="disabled"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">&raquo;</a></li>
          </ul>
        </div>
   </div>
</div>
</body>


<c:set var="scripts" scope="request">
<script type="text/javascript">
    var placeholder = "<fmt:message key="mapMenu.select.heading"/>";
    $(document).ready(function(){
        new Territory.CreateMap();
    });

</script>
</c:set>

