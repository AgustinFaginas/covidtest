<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/${armarHeader}1.jsp" />

<title>Inserte titulo aquí</title>
    
<jsp:include page="../../partial/${armarHeader}2.jsp" />

<script>
    window.onload = function () {

        //Grafico de barras
        var chart = new CanvasJS.Chart("chartContainerBarras", {
            animationEnabled: true,
            theme: "light1", // "light1", "light2", "dark1", "dark2",
            title: {
                text: "Casos totales de contagiados y recuperados",
                    fontFamily: "calibri light",
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
                    {y: ${cantidadPacientesInfectados}, label: "Infectados", color:"#0080FF"},
                    {y: ${cantidadPacientesNoInfectados}, label: "Recuperados", color: "#01DF01"}
                ]
            }]
        });

        chart.render();

        //Grafico de barras 2
        var chart = new CanvasJS.Chart("chartContainerBarras2", {
            animationEnabled: true,
            theme: "light1", // "light1", "light2", "dark1", "dark2",
            title: {
                text: "Cantidad total de camas ocupadas y disponibles",
                fontFamily: "calibri light",
            },
            axisY: {
                title: "Cantidad total de camas"
            },
            data: [{
                type: "column",
                showInLegend: true,
                legendMarkerColor: "grey",
                legendText: "Estado",
                dataPoints: [
                    {y: ${cantidadCamasOcupadas}, label: "Ocupadas", color:"#0080FF"},
                    {y: ${cantidadCamasDisponibles}, label: "Disponibles", color: "#01DF01"}
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
                text: "Casos totales de contagiados y recuperados",
                	fontFamily: "calibri light"
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
                    {y: porcentaje1, label: "Infectados", color:"#0080FF"},
                    {y: porcentaje2, label: "Recuperados", color:"#01DF01"}

                ]
            }]
        });
        chart.render();

    }

</script>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
        
        
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1>Reportes</h1>
       
      </div>
            <div class="">
                <div class="row container-chart">
                    <div class="col"></div>
                    <div class="col-6">
                        <div id="chartContainerBarras" style="height: 40em; width: 100%;"></div>
                    </div>
                    <div class="col"></div>
                </div>
            </div>

            <div class="">
                <div class="row container-chart">
                    <div class="col"></div>
                    <div class="col-6">
                        <div id="chartContainerBarras2" style="height: 40em; width: 100%;"></div>
                    </div>
                    <div class="col"></div>
                </div>
            </div>

            <div class="">
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
