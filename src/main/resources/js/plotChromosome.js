var plotTerrain = function(terrainX, terrainY) {
    var g = d3.select("#parentG");
    for (var i = 1; i < terrainX.length; i++) {
        g.insert("line").attr("x1", terrainX[i-1]).attr("y1", terrainY[i-1])
            .attr("x2", terrainX[i]).attr("y2", terrainY[i]);
    }
    d3.select("#sel-terrainId").attr("disabled", true);
    d3.select("#btn-loadTerrain").attr("disabled", true);
    d3.select("#btn-startSim").attr("disabled", null);
};

var plotChromosome = function(polyArray, crashArray) {
    console.log("plotChromosome")
    d3.selectAll("#line").remove();
    var g = d3.select("#parentG").insert("g").classed("lineContainer", true);
    for (var i = 0; i < polyArray.length; i++) {
        var line = g.insert("polyline").attr("id", "line").attr("points", polyArray[i]);
        if (!crashArray[i]) {
            line.classed("landed", true);
        }
    }
};
