<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!doctype html>

<html lang="es">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Grafico Pacientes</title>

    <style>
        #navbar-top:hover {
            text-decoration: none;
        }

        .container-chart {
            margin-top: 10em;
        }
    </style>

</head>


<script>
    window.onload = function () {

        //Grafico de barras
        var chart = new CanvasJS.Chart("chartContainerBarras", {
            animationEnabled: true,
            theme: "light1", // "light1", "light2", "dark1", "dark2",
            title: {
                text: "Casos totales de contagiados y recuperados"
            },
            axisY: {
                title: "Cantidad de personas"
            },
            data: [{
                type: "column",
                showInLegend: true,
                legendMarkerColor: "grey",
                legendText: "Estado",
                dataPoints: [
                    {y: ${cantidadPacientesInfectados}, label: "Infectados"},
                    {y: ${cantidadPacientesNoInfectados}, label: "Recuperados"}
                ]
            }]
        });

        chart.render();

        //Grafico de torta
        var porcentaje1 = (${cantidadPacientesInfectados} * 100 /
        ${cantidadPacientes})
        ;
        var porcentaje2 = (${cantidadPacientesNoInfectados} * 100 /
        ${cantidadPacientes})
        ;

        var chart = new CanvasJS.Chart("chartContainerTorta", {
            theme: "light1", // "light1", "light2", "dark1", "dark2"
            //exportEnabled: true,
            //animationEnabled: true,
            title: {
                text: "Casos totales de contagiados y recuperados"
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
                    {y: ${cantidadPacientesInfectados}, label: "Infectados"},
                    {y: ${cantidadPacientesNoInfectados}, label: "Recuperados"}

                ]
            }]
        });
        chart.render();

    }

</script>


<body>

<nav class="navbar sticky-top bg-dark text-white justify-content-center align-items-center">
    <a class="text-center text-white" href="#" id="navbar-top">
        <h5>
            Coronavirus COVID-19 conocé información y recomendaciones del Ministerio de Salud</strong>
        </h5>
    </a>
</nav>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="home">
        <img src="img/share2.png" width="35" height="35" class="d-inline-block align-top" alt="logo">
        AsignAR
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
            aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
<%--        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item ml-5 active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item ml-5">
                <a class="nav-link" href="autoTest">Realizar test</a>
            </li>
        </ul>--%>
        <button type="button" class="btn btn-dark ml-5">Sign out</button>
    </div>
</nav>

<div class="container-fluid m-5">
    <div class="row container-chart">
        <div class="col"></div>
        <div class="col-6">
            <div id="chartContainerBarras" style="height: 40em; width: 100%;"></div>
        </div>
        <div class="col"></div>
    </div>
</div>

<div class="container-fluid m-5">
    <div class="row container-chart">
        <div class="col"></div>
        <div class="col-6">
            <div id="chartContainerTorta" style="height: 40em; width: 100%;"></div>
        </div>
        <div class="col"></div>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>


<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>

</html>