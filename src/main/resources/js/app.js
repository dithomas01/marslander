var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/plot/terrain', function(terrainData) {
            var data = JSON.parse(terrainData.body);
            plotTerrain(data.terrainX, data.terrainY);
        });
        stompClient.subscribe('/plot/sim', function (viewData) {
            console.log("sim");
            var data = JSON.parse(viewData.body);
            plotChromosome(data.lines, data.crashes);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendTerrain() {
    stompClient.send("/app/terrain", {}, $("#terrainId").val());
}

function sendSimStart() {
    stompClient.send("/app/simStart");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#btn-loadTerrain" ).click(function() { sendTerrain(); });
    $( "#btn-startSim" ).click(function() { sendSimStart(); });
});
