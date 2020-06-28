<%--
  Created by IntelliJ IDEA.
  User: juanp
  Date: 28/06/2020
  Time: 01:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Grafico Pacientes</title>
</head>
<script>
    window.onload = function () {

        //Grafico de barras
        var chart = new CanvasJS.Chart("chartContainerBarras", {
            animationEnabled: true,
            theme: "light2", // "light1", "light2", "dark1", "dark2",
            title: {
                text: "Pacientes"
            },
            axisY: {
                title: "#"
            },
            data: [{
                type: "column",
                showInLegend: true,
                legendMarkerColor: "grey",
                legendText: "#",
                dataPoints: [
                    {y: ${cantidadPacientesInfectados}, label: "Infectados"},
                    {y: ${cantidadPacientesNoInfectados}, label: "No infectados"}
                ]
            }]
        });
        chart.render();

        /*------------------------------------------------------------------------------*/
        //Grafico de torta
        var porcentaje1 = (${cantidadPacientesInfectados} * 100 /
        ${cantidadPacientes})
        ;
        var porcentaje2 = (${cantidadPacientesNoInfectados} * 100 /
        ${cantidadPacientes})
        ;

        var chart = new CanvasJS.Chart("chartContainerTorta", {
            theme: "light2", // "light1", "light2", "dark1", "dark2"
            //exportEnabled: true,
            //animationEnabled: true,
            title: {
                text: "Pacientes"
            },
            data: [{
                type: "pie",
                startAngle: 25,
                toolTipContent: "<b>{label}</b>: {y}%",
                showInLegend: "true",
                legendText: "{label}",
                indexLabelFontSize: 16,
                indexLabel: "{label} - {y}%",
                dataPoints: [
                    {y: porcentaje1, label: "Infectados"},
                    {y: porcentaje2, label: "No infectados"}

                ]
            }]
        });
        chart.render();

    }

</script>

</head>
<body>
<div id="chartContainerBarras" style="height: 370px; width: 100%;"></div>
<div id="chartContainerTorta" style="height: 370px; width: 100%;"></div>


<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>
