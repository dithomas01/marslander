<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
Test bla!
<div>
    <div id="crunchifyMessage"></div>
</div>
<svg id="mars-plot">
    <g transform="translate(490, 210)">
        <line x1="0" y1="0" x2="7000" y2="3000"/>
    </g>
</svg>
</body>
</html>
