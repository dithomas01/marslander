<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/base.css">
    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="/js/terrain.js"></script>
    <title>Marslander Algo</title>
</head>
<body>
<svg id="mars-plot">
    <g transform="translate(490, 210)">
        <line x1="0" y1="0" x2="${terrainX[0]}" y2="${terrainY[0]}"/>
        <c:forEach varStatus="state" items="${terrainX}" var="item">
            <c:if test="${not state.first}">
                <line x1="${terrainX[state.index - 1]}" y1="${terrainY[state.index - 1]}"
                      x2="${terrainX[state.index]}" y2="${terrainY[state.index]}"/>
            </c:if>
        </c:forEach>
    </g>
</svg>
</body>
</html>
