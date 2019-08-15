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
<body>${message}
<script>
    plotTerrain(${terrainX}, ${terrainY});
</script>
<svg id="mars-plot">
    <g transform="translate(490, 210)">
        <line x1="0" y1="0" x2="${terrainX[0]}" y2="${terrainY[0]}"/>
        <c:forEach varStatus="item" items="${terrainX}">
            <:c:if test="${not item.first}">
                <line x1="${terrainX[item.index - 1]}" y1="${terrainY[item.index - 1]}" x2="${terrainX[item.index]}" y2="${terrainY[item.index]}"/>
            </:c:if>
        </c:forEach>
    </g>
</svg>
</body>
</html>
