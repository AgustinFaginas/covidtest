<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <title>Dashboard Template · Bootstrap</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/dashboard/">

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        #navbar-top:hover {
            text-decoration: none;
        }

        .container-chart {
            margin-top: 10em;
        }

    </style>
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
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
<nav class="navbar navbar-dark sticky-top bg-primary flex-md-nowrap p-0 shadow">
    <%--    <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">COVIDTEST</a>--%>
    <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="home">
        <img src="img/share2.png" width="35" height="35" class="d-inline-block align-top" alt="logo">
        AsignAR
    </a>
    <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse"
            data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <!--   <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search"> -->
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a href="login" class="btn btn-dark ml-5" role="button"
               aria-disabled="true">Log out</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block sidebar collapse">
            <div class="sidebar-sticky pt-3">
                <ul class="nav flex-column">
                    <li class="nav-item mt-3 mb-3">
                        <a class="nav-link" href="#">
                            <span data-feather="home"></span>
                            Home Institución
                        </a>
                    </li>
                    <li class="nav-item mt-3 mb-3">
                        <a class="nav-link" href="#">
                            <span data-feather="inbox"></span>
                            Disponibilidad Camas
                        </a>
                    </li>
                    <li class="nav-item mt-3 mb-3">
                        <a class="nav-link" href="pacientes">
                            <span data-feather="users"></span>
                            Lista de Espera
                        </a>
                    </li>
                    <li class="nav-item mt-3 mb-3">
                        <a class="nav-link" href="grafico-pacientes">
                            <span data-feather="bar-chart-2"></span>
                            Reportes
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
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

        </main>

    </div>
</div>

</main>

</div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
<script src="../assets/dist/js/bootstrap.bundle.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
<script src="js/dashboard.js"></script>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>
