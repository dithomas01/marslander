<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>
    <link rel="stylesheet" href="../css/base.css">
    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="/webjars/sockjs-client/1.0.2/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/2.3.3/stomp.min.js"></script>
    <script src="/webjars/d3js/5.9.7/d3.min.js"></script>
    <script src="../js/app.js"></script>
    <script src="/js/plotChromosome.js"></script>
    <script>
        function loadTerrain() {
            var crashArray = [];
            var polyArray = [];
            <c:forEach varStatus="state" items="${lines}" var="item">
            polyArray.push("${lines[state.index]}");
            crashArray.push(${isCrashed[state.index]});
            </c:forEach>
        }
    </script>
</head>
<body>
<script>connect()</script>
<svg id="mars-plot">
    <g id="parentG" transform="translate(490, 210)">
        <line x1="0" y1="0" x2="${terrainX[0]}" y2="${terrainY[0]}"/>
        <c:forEach varStatus="state" items="${terrainX}" var="item">
            <c:if test="${not state.first}">
                <line x1="${terrainX[state.index - 1]}" y1="${terrainY[state.index - 1]}"
                      x2="${terrainX[state.index]}" y2="${terrainY[state.index]}"/>
            </c:if>
        </c:forEach>
    </g>
</svg>
<div id="terrain-loader">
    <form class=form-inline">
        <select id="terrainId">
            <option value="0">0</option>
            <option value="1">1</option>
            <option value="2">2</option>
        </select>
        <button id="loadTerrain" class="btn" type="button">Load Terrain</button>
    </form>
</div>
</body>
</html>
