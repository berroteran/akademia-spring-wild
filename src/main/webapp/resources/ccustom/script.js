function fnLeerPesoBascula() {
    var doc = document.document.getElementsByClassName('read-peso-bascula')
    console.log(doc);
    doc.value = "0.00";

    $.ajax({
        url: 'http://127.0.0.1:8001/?puerto=b',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        type: "POST", /* or type:"GET" or type:"PUT" */
        dataType: "json",
        data: {},
        success: function (result) {
            console.log(result);
            console.log(result.data);
            document.document.getElementsByClassName('read-peso-bascula').value = result.data[0].port1;
            document.getElementById("msgBascula").style = "display:none;"
        },
        error: function (result) {
            console.log("error");
            console.log(result);
            document.getElementById("msgBascula").style = "display:block;"
            document.getElementById("msgBascula").style = "display:none;"
        }
    });
}

function fnSumarLecturaActualPeso() {
    console.log("peso manual:  " + pesoManual);
    var pesoLecturaActual = document.getElementsByClassName('read-peso-bascula').value;

    remoteCommandSumarLecturaPeso([{
        name: 'pesoLecturaActualParam'
        , value: pesoLecturaActual
    }, {
        name: 'pesoManualParam',
        value: pesoManual
    }]);
}

function fnCapturarValorHumedadSensor() {
    let control = document.getElementsByClassName('read-peso-bascula');
    control.value = "0.00";

    $.ajax({
        url: 'http://127.0.0.1:8001/?puerto=b',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        type: "POST", /* or type:"GET" or type:"PUT" */
        dataType: "json",
        data: {},
        success: function (result) {
            console.log(result);
            console.log(result.data);

            var porcentajeHumedadCapturadoSensor = result.data[1].port2;
            control.value = porcentajeHumedadCapturadoSensor;

            document.getElementById("msgBascula").style = "display:none;"
            remoteCommandLeerPorcentajeHumedadSensor([{
                name: 'porcentajeHumedadCapturadoSensorParam'
                , value: porcentajeHumedadCapturadoSensor
            }]);
        },
        error: function (result) {
            console.log("error");
            console.log(result);
            document.getElementById("msgBascula").style = "display:block;"
            document.getElementById("msgBascula").style = "display:none;"
        }
    });
}