var plotChromosome = function() {
    var g = d3.select("#parentG").insert("g").classed("lineContainer", true);
    for (i = 0; i < polyArray.length; i++) {
        g.insert("polyline").attr("points", polyArray[i]);
    }
}
