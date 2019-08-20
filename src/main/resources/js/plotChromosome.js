var plotChromosome = function(polyArray, crashArray) {
    var g = d3.select("#parentG").insert("g").classed("lineContainer", true);
    for (var i = 0; i < polyArray.length; i++) {
        var line = g.insert("polyline").attr("points", polyArray[i]);
        if (!crashArray[i]) {
            line.classed("landed", true);
        }
    }
}
