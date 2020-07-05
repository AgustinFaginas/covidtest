<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!doctype html>

<html lang="es">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Grafico Pacientes</title>

    <style>
        #map {
            height: 50em;
            width: 100%;
        }
    </style>

    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"
          integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
          crossorigin=""/>
    <script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"
            integrity="sha512-gZwIG9x3wUXg2hdXF6+rVkLF/0Vi9U8D2Ntg4Ga5I5BZpVkVxlJWbSQtXPSiUTtC0TjtGOmxa1AJPuV0CPthew=="
            crossorigin=""></script>

</head>

<body>

<nav class="navbar sticky-top bg-dark text-white justify-content-center align-items-center">
    <a class="text-center text-white" href="https://www.argentina.gob.ar/salud/coronavirus-COVID-19" id="navbar-top">
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
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <%--<li class="nav-item ml-5">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>--%>
        </ul>
        <%--        <button type="button" class="btn btn-dark ml-5">Log in</button>--%>
    </div>
</nav>

<div class="progress my-1">
    <div class="progress-bar bg-success" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0"
         aria-valuemax="100">100%
    </div>
</div>

<div class="alert alert-success alert-dismissible fade show text-center" role="alert">
    <h5>Registro exitoso</h5>
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</div>

<div class="form-group">
    <c:if test="${not empty error}">
        <h4><span>${error}</span></h4>
        <br>
    </c:if>
</div>

<h1 class="text-center m-5">Mapa de instituciones</h1>

<div class="container-fluid mt-5">
    <div class="row container-chart">
        <div class="col-2"></div>
        <div class="col-8">
            <h5 class="text-justify m-5">En este mapa podrá visualizar facilmente su ubicación. Así como también la
                ubicación de hospitales, centros de salud, e instituciones que prestan sus instalaciones
                para el alojamiento de pacientes
                con Coronavirus. En estos Centros de Aislamiento permanecerán, en el caso
                de que el Sistema de Salud se encuentre desbordado por la falta de espacio físico, aquellos pacientes
                que necesiten estar aislados, sin asistencia médica puntual, junto a los casos menos graves y puedan
                realizar su aislamiento individual o familiar.</h5>
        </div>
        <div class="col-2"></div>
    </div>
</div>

<div class="container-fluid m-5">
    <div class="row container-chart">
        <div class="col"></div>
        <div class="col-6">
            <div id="map"></div>
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

<script>
    var hospitales = [
        {
            "nombre": "HOSPITAL GENERAL DE AGUDOS D. VELEZ SARSFIELD",
            "lat": -34.6253368,
            "lon": -58.50761514
        },
        {
            "nombre": "HOSP. DE PEDIATRIA DR. J. GARRAHAN",
            "lat": -34.62994536,
            "lon": -58.39187918
        },
        {
            "nombre": "HOSPITAL GENERAL DE NIÑOS PEDRO DE ELIZALDE",
            "lat": -34.62884736,
            "lon": -58.37755085
        },
        {
            "nombre": "HOSPITAL DE REHABILITACION RESPIRATORIA MARIA FERRER",
            "lat": -34.630211204449473,
            "lon": -58.3758433488021
        },
        {
            "nombre": "HOSPITAL INFANTO JUVENIL C. TOBAR GARCIA",
            "lat": -34.635702235155911,
            "lon": -58.382328450948762
        },
        {
            "nombre": "HOSPITAL GENERAL DE AGUDOS B. RIVADAVIA",
            "lat": -34.58476595812138,
            "lon": -58.400513457442273
        },
        {
            "nombre": "HOSPITAL GENERAL DE AGUDOS DR C. ARGERICH",
            "lat": -34.628344858167651,
            "lon": -58.365985088719015
        },
        {
            "nombre": "HOSPITAL GENERAL DE AGUDOS DR. J. A. FERNANDEZ",
            "lat": -34.581141710888993,
            "lon": -58.406893914278655
        },
        {
            "nombre": "HOSPITAL CECILIA GRIERSON",
            "lat": -34.67184801407717,
            "lon": -58.456642849110352
        },
        {
            "nombre": "HOSPITAL DE REHABILITACION M. ROCCA",
            "lat": -34.617981754059123,
            "lon": -58.502144922222243
        },
        {
            "nombre": "HOSPITAL DE OFTALMOLOGIA SANTA LUCIA",
            "lat": -34.622712507512453,
            "lon": -58.394064160474649
        },
        {
            "nombre": "HOSPITAL DE QUEMADOS DR. ARTURO UMBERTO ILLIA",
            "lat": -34.625503195248271,
            "lon": -58.432396695024352
        },
        {
            "nombre": "HOSPITAL DE ODONTOLOGIA  JOSE DUEÑAS",
            "lat": -34.614634834842903,
            "lon": -58.427659754283688
        },
        {
            "nombre": "HOSPITAL OFTALMOLOGICO DR. PEDRO LAGLEYZE",
            "lat": -34.605434275020741,
            "lon": -58.460185577552785
        },
        {
            "nombre": "HOSPITAL MATERNO INFANTIL R. SARDA",
            "lat": -34.634856308414967,
            "lon": -58.402750627537664
        }

    ]

    var map = L.map('map').fitWorld();

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
        maxZoom: 18,
        tileSize: 512,
        zoomOffset: -1
    }).addTo(map);

    map.locate({setView: true, maxZoom: 16});

    function onLocationFound(e) {
        L.marker(e.latlng).addTo(map)
    }

    for (var i = 0; i < hospitales.length; i++) {
        marker = new L.marker([hospitales[i].lat, hospitales[i].lon])
            .bindPopup(hospitales[i].nombre)
            .addTo(map);
    }

    function onLocationFound(e) {
        //var radius = 0;

        L.marker(e.latlng).addTo(map)
            .bindPopup("Su ubicación").openPopup();

        //L.circle(e.latlng, radius).addTo(map);

    }

    map.on('locationfound', onLocationFound);

    function onLocationError(e) {
        alert(e.message);
    }

    map.on('locationerror', onLocationError);
</script>

<!-- Footer -->
<footer class="page-footer font-small mdb-color pt-4 bg-whiteborder border-top">

    <!-- Footer Links -->
    <div class="container text-center text-md-left">

        <!-- Footer links -->
        <div class="row text-center text-md-left mt-3 pb-3">

            <!-- Grid column -->
            <div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3 text-left">
                <h6 class="text-uppercase mb-4 font-weight-bold">asignAR</h6>
                <img src="img/share2.png" width="50" height="50" class="d-inline-block align-top" alt="logo">
            </div>
            <!-- Grid column -->

            <hr class="w-100 clearfix d-md-none">

            <!-- Grid column -->
            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mt-3">
                <h6 class="text-uppercase mb-4 font-weight-bold">ENLACES ÚTILES</h6>
                <p>
                    <a href="https://www.argentina.gob.ar/salud/coronavirus-COVID-19">Ministerio de Salud</a>
                </p>
                <p>
                    <a href="#!">Hospitales y establecimientos de salud</a>
                </p>
            </div>

            <!-- Grid column -->
            <hr class="w-100 clearfix d-md-none">

            <!-- Grid column -->
            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
                <h6 class="text-uppercase mb-4 font-weight-bold">Teléfono</h6>
                <p>
                    <i class="fas fa-home"></i> Llamá al <strong>120</strong>, es gratuito desde cualquier lugar del
                    país y te atienden las 24 horas.</p>
                <hr>
                <h6 class="text-uppercase mb-4 font-weight-bold">Whatsapp</h6>
                <i class="fas fa-home"></i> Escribí "Hola" al <strong>+54 9 11
                2256-0566</strong> para que encuentres respuestas a las preguntas más
                frecuentes y recibas consejos de prevención.</p>


            </div>
            <!-- Grid column -->

        </div>
        <!-- Footer links -->

        <hr>

        <!-- Grid row -->
        <div class="row d-flex align-items-center">

            <!-- Grid column -->
            <div class="col-md-7 col-lg-8">

                <!--Copyright-->
                <p class="text-center text-md-left">© 2020 Copyright:

                    <strong>ASIGNAR</strong>

                </p>

            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-5 col-lg-4 ml-lg-0">

                <!-- Social buttons -->
                <div class="text-center text-md-right">
                    <ul class="list-unstyled list-inline">
                        <li class="list-inline-item">
                            <a class="btn-floating btn-sm rgba-white-slight mx-1">
                                <i class="fab fa-facebook-f"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a class="btn-floating btn-sm rgba-white-slight mx-1">
                                <i class="fab fa-twitter"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a class="btn-floating btn-sm rgba-white-slight mx-1">
                                <i class="fab fa-google-plus-g"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a class="btn-floating btn-sm rgba-white-slight mx-1">
                                <i class="fab fa-linkedin-in"></i>
                            </a>
                        </li>
                    </ul>
                </div>

            </div>
            <!-- Grid column -->

        </div>
        <!-- Grid row -->

    </div>
    <!-- Footer Links -->

</footer>
<!-- Footer -->
</body>

</html>