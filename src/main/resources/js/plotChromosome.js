var plotTerrain = function(terrainX, terrainY) {
    var g = d3.select("#parentG");
    for (var i = 1; i < terrainX.length; i++) {
        g.insert("line").attr("x1", terrainX[i-1]).attr("y1", terrainY[i-1])
            .attr("x2", terrainX[i]).attr("y2", terrainY[i]);
    }
    d3.select("#terrainId").attr("disabled", true);
    d3.select("#loadTerrain").attr("disabled", true);
};

var plotChromosome = function(polyArray, crashArray) {
    console.log("plotChromosome")
    var g = d3.select("#parentG").insert("g").classed("lineContainer", true);
    for (var i = 0; i < polyArray.length; i++) {
        var line = g.insert("polyline").attr("points", polyArray[i]);
        if (!crashArray[i]) {
            line.classed("landed", true);
        }
    }
};
