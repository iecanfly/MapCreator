<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
    <div style="width: 1650px;">
        <c:forEach var="building" items="${buildingList}" >
            <iframe style="width: 800px; height: 550px;  margin-right:20px; margin-bottom: 10px; border:dotted 1px"
                src="/print/buildings/printOverallSingle/${building.cong}/${isDisplayBusInfo}/${isDisplayBusinessTypeInfo}/${isDisplayColourDivision}/${building.block}^${building.number}"></iframe>
        </c:forEach>
    </div>
</body>