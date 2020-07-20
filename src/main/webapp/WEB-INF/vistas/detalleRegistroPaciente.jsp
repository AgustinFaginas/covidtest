<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/${armarHeader}1.jsp" />

<title>Inserte titulo aquí</title>
    
<jsp:include page="../../partial/${armarHeader}2.jsp" />

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

<h1 class="text-center mb-3 mt-5">Gracias por registrarse</h1>

<div class="text-center my-5">
    <img src="img/right.png" class="rounded" alt="virus" width="200" height="200">
</div>

<div class="container my-5">
    <h4 class="text-center mt-3 mb-2">Por favor, ingrese con su email y contraseña para poder ver notificaciones</h4>
    <h4 class="text-center mt-3 mb-5">Usted será contactado en la brevedad</h4>
</div>

<div class="container-fluid mt-5">
    <div class="row container-chart">

        <div class="col-2"></div>

        <div class="col-8">
            <div class="card text-white bg-dark border-dark mb-3">
                <h1 class="card-header text-center">Mapa de instituciones</h1>
                <div id="map"></div>
                <div class="card-body">
                    <p class="card-text text-justify">En este mapa podrá visualizar facilmente su ubicación.
                        Así como
                        también la
                        ubicación de hospitales, centros de salud, e instituciones que prestan sus instalaciones
                        para el alojamiento de pacientes
                        con Coronavirus. En estos Centros de Aislamiento permanecerán, en el caso
                        de que el Sistema de Salud se encuentre desbordado por la falta de espacio físico, aquellos
                        pacientes
                        que necesiten estar aislados, sin asistencia médica puntual, junto a los casos menos graves y
                        puedan
                        realizar su aislamiento individual o familiar</p>
                </div>
            </div>
        </div>

        <div class="col-2"></div>

    </div>
</div>

<%--<div class="container-fluid m-5">
    <div class="row container-chart">
        <div class="col"></div>
        <div class="col-6">
            <div id="map"></div>
        </div>
        <div class="col"></div>
    </div>
</div>--%>

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
            "nombre": "UNIVERSIDAD NACIONAL DE LA MATANZA",
            "lat": -34.670520,
            "lon": -58.562806
        },
        {
            "nombre": "CLUB PORTUGUÉS DEL GRAN BUENOS AIRES",
            "lat": -34.700021,
            "lon": -58.589954
        },
        {
            "nombre": "PREDIO DEPORTIVO JUAN DOMINGO PERÓN",
            "lat": -34.784184,
            "lon": -58.625167
        },
        {
            "nombre": "HOSPITAL DE AGUDOS PAROISSIEN",
            "lat": -34.695668,
            "lon": -58.579381
        },
        {
            "nombre": "SKYLAB",
            "lat": -34.693365,
            "lon": -58.572578
        },
        {
            "nombre": "COMPLEJO DEPORTIVO PEDRO MENDOZA",
            "lat": -34.696371,
            "lon": -58.585985
        },
        {
            "nombre": "CLUB SOCIAL Y DEPORTIVO LAFERRERE",
            "lat": -34.752396,
            "lon": -58.593529
        },
        {
            "nombre": "HOSPITAL DR. ALBERTO BALESTRINI",
            "lat": -34.707360,
            "lon": -58.532926
        },
        {
            "nombre": "HOSPITAL DE MORÓN",
            "lat": -34.658637,
            "lon": -58.609762
        },
        {
            "nombre": "POLICLÍNICO PROFESOR ALEJANDRO POSADAS",
            "lat": -34.628968,
            "lon": -58.574673
        },
        {
            "nombre": "HOSPITAL INTERZONAL GENERAL DE AGUDOS PROFESOR DR. LUIS GÜEMES",
            "lat": -34.641730,
            "lon": -58.579906
        },
        {
            "nombre": "HOSPITAL MATERNO INFANTIL R. SARDA",
            "lat": -34.634856308414967,
            "lon": -58.402750627537664
        }

    ];

    var amba = [
        {
            "nombre": "BERAZATEGUI",
            "lat": -34.76531,
            "lon": -58.21278
        },
        {
            "nombre": "FLORENCIO VARELA",
            "lat": -34.8272200,
            "lon": -58.3955600
        },
        {
            "nombre": "PRESIDENTE PERÓN",
            "lat": -38.416097,
            "lon": -63.616672
        },
        {
            "nombre": "QUILMES",
            "lat": -34.72904,
            "lon": -58.26374
        },
        {
            "nombre": "ESTEBAN ECHEVERRÍA",
            "lat": -58.4562500,
            "lon": -34.8184400
        },
        {
            "nombre": "AVELLANEDA",
            "lat": -34.66018,
            "lon": -58.36744
        },
        {
            "nombre": "LANÚS",
            "lat": -34.70252,
            "lon": -58.3955
        },
        {
            "nombre": "LOMAS DE ZAMORA",
            "lat": -34.76088,
            "lon": -58.40632
        },
        {
            "nombre": "LA MATANZA",
            "lat": -34.6831,
            "lon": -58.5519
        },
        {
            "nombre": "VICENTE LÓPEZ",
            "lat": -34.5106,
            "lon": -58.4964
        },
        {
            "nombre": "SAN ISIDRO",
            "lat": -22.2666700,
            "lon": -66.1666700
        },
        {
            "nombre": "SAN FERNANDO",
            "lat": -34.4417,
            "lon": -58.5583
        },
        {
            "nombre": "GRAL. SAN MARTÍN",
            "lat": -34.5758,
            "lon": -58.5372
        },
        {
            "nombre": "TRES DE FEBRERO",
            "lat": -34.59987,
            "lon": -58.56606
        },
        {
            "nombre": "HÚRLINGAM",
            "lat": -34.6,
            "lon": -58.63333
        },
        {
            "nombre": "ITUZAINGÓ",
            "lat": -34.6667,
            "lon": -58.6667
        },
        {
            "nombre": "MORÓN",
            "lat": -34.6534400,
            "lon": -58.6197500
        },
        {
            "nombre": "MERLO",
            "lat": -32.3428800,
            "lon": -65.0139600
        },
        {
            "nombre": "MORENO",
            "lat": -34.4633,
            "lon": -58.9292
        },
        {
            "nombre": "SAN MIGUEL",
            "lat": -34.5239,
            "lon": -58.7794
        },
        {
            "nombre": "JOSÉ C. PAZ",
            "lat": -34.5,
            "lon": -58.75
        },
        {
            "nombre": "TIGRE",
            "lat": -34.42603,
            "lon": -58.57962
        },
        {
            "nombre": "ESCOBAR",
            "lat": -34.34833,
            "lon": -58.79265
        },
        {
            "nombre": "PILAR",
            "lat": -34.45866,
            "lon": -58.9142
        },
        {
            "nombre": "CABA",
            "lat": -34.61315,
            "lon": -58.37723
        }
    ];

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
    ;
    //[amba[0].lat, amba[0].lon],[amba[1].lat, amba[1].lon],[amba[2].lat, amba[2].lon],[amba[3].lat, amba[3].lon]
    //[-34.61315,-58.37723],[-34.45866,-58.9142],[-34.34833,-58.79265]
    //AMBA
    /*var area = L.polygon([[amba[0].lat, amba[0].lon], [amba[1].lat, amba[1].lon], [amba[2].lat, amba[2].lon], [amba[3].lat, amba[3].lon], [amba[4].lat, amba[4].lon], [amba[5].lat, amba[5].lon], [amba[6].lat, amba[6].lon], [amba[7].lat, amba[7].lon], [amba[8].lat, amba[8].lon], [amba[9].lat, amba[9].lon], [amba[10].lat, amba[10].lon], [amba[11].lat, amba[11].lon], [amba[12].lat, amba[12].lon], [amba[13].lat, amba[13].lon], [amba[14].lat, amba[14].lon], [amba[15].lat, amba[15].lon], [amba[16].lat, amba[16].lon], [amba[17].lat, amba[17].lon], [amba[18].lat, amba[18].lon], [amba[19].lat, amba[19].lon], [amba[20].lat, amba[20].lon], [amba[21].lat, amba[21].lon], [amba[22].lat, amba[22].lon], [amba[23].lat, amba[23].lon], [amba[24].lat, amba[24].lon]], {
        fillColor: 'red',
        opacity: 1,
        color: 'red'
    }).addTo(map);*/


    /*//AMBA
    for (var i = 0; i < amba.length; i++) {
        var radio = 5000;

        marker = new L.circle([amba[i].lat, amba[i].lon], {
            color: 'red',
            fillColor: 'red',
            radius: radio,
            opacity: .75,
        }).addTo(map);

        //L.marker([amba[i].lat, amba[i].lon])
        //.bindPopup(amba[i].nombre)

    }*/

    function onLocationFound(e) {
        //var radius = 100;

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