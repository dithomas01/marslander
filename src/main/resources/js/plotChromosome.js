var plotChromosome = function(line) {
    var g = d3.select("#parentG").insert("g").classed("lineContainer", true);
    var line = g.insert("polyline").attr("points", line);
}
