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


    <title>AsignAR</title>

    <link rel="icon" href="img/asignar-logo.ico">

    <style>
        #navbar-top:hover {
            text-decoration: none;
        }
    </style>

</head>

<body>

<nav class="navbar sticky-top bg-dark text-white justify-content-center align-items-center">
    <a class="text-center text-white" href="#" id="navbar-top">
        <h5>
            Coronavirus COVID-19 conoc� informaci�n y recomendaciones del Ministerio de Salud</strong>
        </h5>
    </a>
</nav>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="#">
        <img src="img/share2.png" width="35" height="35" class="d-inline-block align-top" alt="logo">
        AsignAR
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
            aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item ml-5 active">
                <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item ml-5">
                <a class="nav-link" href="autoTest">Realizar test</a>
            </li>
        </ul>
    </div>
</nav>

<div class="progress my-1">
    <div class="progress-bar bg-success" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0"
         aria-valuemax="100">75%
    </div>
</div>

<h1 class="text-center mb-3 mt-5">El resultado de su test ha sido positivo</h1>

<div class="text-center my-5">
    <img src="img/virus.png" class="rounded" alt="virus" width="350" height="350">
</div>

<div class="container my-5">
    <h3 class="text-center my-3">Complete los siguientes datos y sera contactado en la brevedad </h3>
</div>

<div class="container-fluid my-5">
    <div class="row">

        <div class="col-4"></div>

        <div class="col-4">

            <div class="card border-dark mb-3">
                <div class="card-header">
                    <h3 class="text-center my-2">Complete el formulario con sus datos</h3>
                    <p class="mt-4 text-right">(<span class="text-primary font-weight-bold">*</span>) Campos
                        obligatorios</p>
                </div>
                <div class="card-body text-dark">
                    <form action="detalleRegistroPaciente" method="POST" modelAttribute="paciente"
                          class="d-flex justify-content-center flex-column justify-content-center">

                        <div class="form-row my-4">
                            <label for="nombre">Nombre <span class="text-primary font-weight-bold">*</span></label>
                            <input type="text" class="form-control" id="nombre" name="nombre" required>
                        </div>

                        <div class="form-row my-4">
                            <label for="apellido">Apellido <span class="text-primary font-weight-bold">*</span></label>
                            <input type="text" class="form-control" id="apellido" name="apellido" required>
                        </div>

                        <div class="form-row my-4">
                            <label for="edad">Edad <span class="text-primary font-weight-bold">*</span></label>
                            <input type="number" class="form-control" id="edad" name="edad" required>
                        </div>

                        <div class="form-row my-4">
                            <div class="form-group col-9">
                                <label for="calle">Calle <span class="text-primary font-weight-bold">*</span></label>
                                <input type="text" name="calle" class="form-control br-radius-zero"
                                       id="calle" data-rule="minlen:1"
                                       data-msg="Ingrese n�mero de CUIT valido" required/>
                                <small id="calleHelp" class="form-text text-muted">Ingrese la calle en donde
                                    reside actualmente</small>
                            </div>
                            <div class="form-group col-3">
                                <label for="numero">N�mero <span class="text-primary font-weight-bold">*</span></label>
                                <input type="number" name="numero" class="form-control br-radius-zero"
                                       id="numero" data-rule="minlen:1"
                                       data-msg="Ingrese n�mero de CUIT valido" required/>
                            </div>
                        </div>

                        <%--<div class="form-row my-4">
                            <label for="nombreLocalidad">Localidad <span class="text-primary font-weight-bold">*</span></label>
                            <input type="text" class="form-control" id="nombreLocalidad" name="nombreLocalidad" required>
                        </div>--%>

                        <div class="form-row my-4">
                            <div class="form-group col-6">
                                <label for="nombreLocalidad">Localidad <span
                                        class="text-primary font-weight-bold">*</span></label>
                                <select name="nombreLocalidad" id="nombreLocalidad" class="form-control br-radius-zero"
                                        required onchange="ShowSelected();">
                                    <option id="Banfield" class="partido11" name="Banfield">Banfield
                                    <option id="Beccar" class="partido2" name="Beccar">Beccar
                                    <option id="Carlos Spegazzini" class="partido12" name="Carlos Spegazzini">Carlos
                                        Spegazzini
                                    <option id="Canning" class="partido12" name="Canning">Canning
                                    <option id="Castelar" class="partido5" name="Castelar">Castelar
                                    <option id="Don Torcuato" class="partido4" name="Don Torcuato">Don Torcuato
                                    <option id="El Palomar" class="partido5" name="El Palomar">El Palomar
                                    <option id="General Pacheco" class="partido4" name="General Pacheco">General Pacheco
                                    <option id="Gregorio de Laferrere" class="partido9" name="Gregorio de Laferrere">
                                        Gregorio de
                                        Laferrere
                                    <option id="Haedo" class="partido9" name="Haedo">Haedo
                                    <option id="Hurlingham" class="partido6" name="Hurlingham">Hurlingham
                                    <option id="Isidro Casanova" class="partido9" name="Isidro Casanova">Isidro Casanova
                                    <option id="Jos� Mar�a Ezeiza" class="partido12" name="Jos� Mar�a Ezeiza">Jos� Mar�a
                                        Ezeiza
                                    <option id="La Reja" class="partido8" name="La Reja">La Reja
                                    <option id="La Tablada" class="partido9" name="La Tablada">La Tablada
                                    <option id="Lomas del Mirador" class="partido9" name="Lomas del Mirador">Lomas del
                                        Mirador
                                    <option id="Mart�nez" class="partido2" name="Mart�nez">Mart�nez
                                    <option id="Moreno" class="partido8" name="Moreno">Moreno
                                    <option id="Mor�n" class="partido9" name="Mor�n">Mor�n
                                    <option id="Munro" class="partido1" name="Munro">Munro
                                    <option id="Paso del Rey" class="partido8" name="Paso del Rey">Paso del Rey
                                    <option id="San Isidro" class="partido2" name="San Isidro">San Isidro
                                    <option id="San Justo" class="partido9" name="San Justo">San Justo
                                    <option id="Tigre" class="partido4" name="Tigre">Tigre
                                    <option id="Trujui" class="partido8" name="Trujui">Trujui
                                    <option id="Udaondo" class="partido7" name="Udaondo">Udaondo
                                    <option id="Valent�n Alsina" class="partido10" name="Valent�n Alsina">Valent�n
                                        Alsina
                                    <option id="Vicente L�pez" class="partido1" name="Vicente L�pez">Vicente L�pez
                                    <option id="Victoria" class="partido3" name="Victoria">Victoria
                                    <option id="Villa Fiorito" class="partido11" name="Villa Fiorito">Villa Fiorito
                                    <option id="Villa Martelli" class="partido1" name="Villa Martelli">Villa Martelli
                                    <option id="Villa Sarmiento" class="partido5" name="Villa Sarmiento">Villa Sarmiento
                                    <option id="Wilde" class="partido10" name="Wilde">Wilde
                                    <option id="William C. Morris" class="partido6" name="William C. Morris">William C.
                                        Morris
                                </select>
                                <small id="localidadHelp" class="form-text text-muted">Seleccione la localidad en donde
                                    reside actualmente</small>
                            </div>
                            <div class="form-group col-6">
                                <label for="nombrePartido">Partido <span
                                        class="text-primary font-weight-bold">*</span></label>
                                <select name="nombrePartido" id="nombrePartido" class="form-control br-radius-zero"
                                        required>
                                    <option id="avellanedaMunicipio" name="avellanedaMunicipio">Avellaneda
                                    <option id="ezeizaMunicipio" name="ezeizaMunicipio">Ezeiza
                                    <option id="florencioVarelaMunicipio" name="florencioVarelaMunicipio">Florencio
                                        Varela
                                    <option id="hurlinghamMunicipio" name="hurlinghamMunicipio">Hurlingham
                                    <option id="ituzaingoMunicipio" name="ituzaingoMunicipio">Ituzaing�
                                    <option id="laMatanzaMunicipio" name="laMatanzaMunicipio">La Matanza
                                    <option id="lomasDeZamoraMunicipio" name="lomasDeZamoraMunicipio">Lomas de Zamora
                                    <option id="morenoMunicipio" name="morenoMunicipio">Moreno
                                    <option id="moronMunicipio" name="Mor�n">Mor�n
                                    <option id="sanIsidroMunicipio" name="San Isidro">San Isidro
                                    <option id="sanFernandoMunicipio" name="San Fernando">San Fernando
                                    <option id="tigreMunicipio" name="Tigre">Tigre
                                    <option id="vicenteLopezMunicipio" name="Vicente L�pez">Vicente L�pez
                                </select>
                                <small id="partidoHelp" class="form-text text-muted">Seleccione el partido en donde
                                    reside actualmente</small>
                            </div>
                        </div>

                        <div class="form-row my-4">
                            <label for="email">Email <span class="text-primary font-weight-bold">*</span></label>
                            <input type="email" class="form-control" id="email" name="email" required>
                            <small id="emailHelp" class="form-text text-muted">Ej: maria@email.com</small>

                        </div>

                        <div class="form-row my-4">
                            <label for="password">Contrase�a <span
                                    class="text-primary font-weight-bold">*</span></label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>

                        <div class="form-row my-4">
                            <div class="form-group col-6">
                                <label for="tipoDocumento">Tipo Documento <span
                                        class="text-primary font-weight-bold">*</span></label>
                                <select name="tipoDocumento" id="tipoDocumento" class="form-control br-radius-zero"
                                        required>
                                    <option id="tipoDocumentoDNI">DNI
                                    <option id="tipoDocumentoPasaporte">PASAPORTE
                                    <option id="tipoDocumentoLibretaCivica">LIBRETA C�VICA
                                </select>
                            </div>
                            <div class="form-group col-6">
                                <label for="numeroDocumento">Numero de documento <span
                                        class="text-primary font-weight-bold">*</span></label>
                                <input type="text" name="numeroDocumento" class="form-control br-radius-zero"
                                       id="numeroDocumento"
                                       data-rule="minlen:1"
                                       data-msg="Ingrese n�mero de CUIT valido" required/>
                                <small id="numeroDocumentoHelp" class="form-text text-muted">Sin puntos ni espacios. Ej:
                                    30758124</small>
                            </div>
                        </div>

                        <div class="text-center">
                            <button type="submit" class="btn btn-primary text-center mt-5 w-50">
                                Enviar
                            </button>
                        </div>

                    </form>
                </div>
            </div>


        </div>

        <div class="col-4"></div>

    </div>
</div>

<%--<div class="d-flex my-5 justify-content-center">

    <div class="row">

        <div class="col-1">

        </div>

        <div class="col-10" style="width: 30rem;">

            <form action="detalleRegistroPaciente" method="POST" modelAttribute="paciente">

                <div class="form-row">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                </div>

                <div class="form-row">
                    <label for="apellido">Apellido</label>
                    <input type="text" class="form-control" id="apellido" name="apellido" required>

                </div>

                <div class="form-row">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>

                <div class="form-row">
                    <label for="password">Contrase�a</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>

                <div class="form-row">

                    <div class="col-4 mb-3">
                        <label for="tipoDni">Tipo Documento</label>
                        <select name="tipoDocumento" id="tipoDocumento" class="form-control br-radius-zero" required>
                            <option id="tipoDocumento">DNI
                            <option id="tipoDocumento">PASAPORTE
                            <option id="tipoDocumento">LIBRETA C�VICA
                        </select>
                    </div>

                    <div class="col-8 mb-3">
                        <label for="numeroDni">Numero de documento</label>
                        <input type="text" name="numeroDocumento" class="form-control br-radius-zero"
                               id="numeroDocumento"
                               placeholder="Ingrese n�mero de documento" data-rule="minlen:1"
                               data-msg="Ingrese n�mero de CUIT valido" required/>
                    </div>
                </div>


                <div class="form-col">
                    <button class="btn btn-primary" type="submit">Enviar</button>
                </div>

            </form>


        </div>

        <div class="col-1">

        </div>

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
<!-- Footer -->
<footer class="page-footer font-small mdb-color pt-4 bg-whiteborder border-top">

    <!-- Footer Links -->
    <div class="container text-center text-md-left">

        <!-- Footer links -->
        <div class="row text-center text-md-left mt-3 pb-3">

            <!-- Grid column -->
            <div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3 text-left">
                <h6 class="text-uppercase mb-4 font-weight-bold">asignAR</h6>
                <img src="img/share2.png" width="50" height="50" class="d-inline-block align-top" alt="">
            </div>
            <!-- Grid column -->

            <hr class="w-100 clearfix d-md-none">

            <!-- Grid column -->
            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mt-3">
                <h6 class="text-uppercase mb-4 font-weight-bold">ENLACES �TILES</h6>
                <p>
                    <a href="#!">Ministerio de Salud</a>
                </p>
                <p>
                    <a href="#!">Hospitales y establecimientos de salud</a>
                </p>
            </div>

            <!-- Grid column -->
            <hr class="w-100 clearfix d-md-none">

            <!-- Grid column -->
            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
                <h6 class="text-uppercase mb-4 font-weight-bold">Tel�fono</h6>
                <p>
                    <i class="fas fa-home"></i> Llam� al <strong>120</strong>, es gratuito desde cualquier lugar del
                    pa�s y te atienden las 24 horas.</p>
                <hr>
                <h6 class="text-uppercase mb-4 font-weight-bold">Whatsapp</h6>
                <i class="fas fa-home"></i> Escrib� "Hola" al <strong>+54 9 11
                2256-0566</strong> para que encuentres respuestas a las preguntas m�s
                frecuentes y recibas consejos de prevenci�n.</p>


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
                <p class="text-center text-md-left">� 2020 Copyright:

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
<script>
    //  document.getElementById("Tigre").style.display = "none";
    // document.getElementsByClassName("partido1").style.display = "none";
/*    if (document.getElementsByClassName("partido1").select) {
        alert("Hola");
    } else {
        alert("Chau");
    }*/
    function ShowSelected()
    {
        /* Para obtener el valor */
        var cod = document.getElementById("nombreLocalidad").value;
        //alert(cod);

        if (cod == "Munro" || cod == "Villa Martelli"|| cod == "Vicente L�pez"){
            document.getElementById("hurlinghamMunicipio").style.display = "none";
            document.getElementById("ituzaingoMunicipio").style.display = "none";
            document.getElementById("laMatanzaMunicipio").style.display = "none";
            document.getElementById("lomasDeZamoraMunicipio").style.display = "none";
            document.getElementById("morenoMunicipio").style.display = "none";
            document.getElementById("moronMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("sanFernandoMunicipio").style.display = "none";
            document.getElementById("tigreMunicipio").style.display = "none";
            document.getElementById("avellanedaMunicipio").style.display = "none";
            document.getElementById("ezeizaMunicipio").style.display = "none";
            document.getElementById("florencioVarelaMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
        }

        if (cod == "Victoria"){
            document.getElementById("hurlinghamMunicipio").style.display = "none";
            document.getElementById("ituzaingoMunicipio").style.display = "none";
            document.getElementById("laMatanzaMunicipio").style.display = "none";
            document.getElementById("lomasDeZamoraMunicipio").style.display = "none";
            document.getElementById("morenoMunicipio").style.display = "none";
            document.getElementById("moronMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("tigreMunicipio").style.display = "none";
            document.getElementById("avellanedaMunicipio").style.display = "none";
            document.getElementById("ezeizaMunicipio").style.display = "none";
            document.getElementById("florencioVarelaMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("vicenteLopezMunicipio").style.display = "none";
        }

        if (cod == "Mart�nez" || cod == "San Isidro" || cod == "Beccar"){
            document.getElementById("hurlinghamMunicipio").style.display = "none";
            document.getElementById("ituzaingoMunicipio").style.display = "none";
            document.getElementById("lomasDeZamoraMunicipio").style.display = "none";
            document.getElementById("morenoMunicipio").style.display = "none";
            document.getElementById("moronMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("sanFernandoMunicipio").style.display = "none";
            document.getElementById("tigreMunicipio").style.display = "none";
            document.getElementById("avellanedaMunicipio").style.display = "none";
            document.getElementById("ezeizaMunicipio").style.display = "none";
            document.getElementById("florencioVarelaMunicipio").style.display = "none";
        }

        if (cod == "Tigre" || cod == "General Pacheco" || cod == "Don Torcuato"){
            document.getElementById("hurlinghamMunicipio").style.display = "none";
            document.getElementById("ituzaingoMunicipio").style.display = "none";
            document.getElementById("laMatanzaMunicipio").style.display = "none";
            document.getElementById("lomasDeZamoraMunicipio").style.display = "none";
            document.getElementById("morenoMunicipio").style.display = "none";
            document.getElementById("moronMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("sanFernandoMunicipio").style.display = "none";
            document.getElementById("avellanedaMunicipio").style.display = "none";
            document.getElementById("ezeizaMunicipio").style.display = "none";
            document.getElementById("florencioVarelaMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("vicenteLopezMunicipio").style.display = "none";
        }

        if (cod == "Villa Sarmiento" || cod == "El Palomar" || cod == "Haedo"|| cod == "Mor�n"|| cod == "Castelar"){
            document.getElementById("hurlinghamMunicipio").style.display = "none";
            document.getElementById("ituzaingoMunicipio").style.display = "none";
            document.getElementById("laMatanzaMunicipio").style.display = "none";
            document.getElementById("lomasDeZamoraMunicipio").style.display = "none";
            document.getElementById("morenoMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("sanFernandoMunicipio").style.display = "none";
            document.getElementById("tigreMunicipio").style.display = "none";
            document.getElementById("avellanedaMunicipio").style.display = "none";
            document.getElementById("ezeizaMunicipio").style.display = "none";
            document.getElementById("florencioVarelaMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("vicenteLopezMunicipio").style.display = "none";
        }

        if (cod == "Ituzaing�" || cod == "Udaondo"){
            document.getElementById("hurlinghamMunicipio").style.display = "none";
            document.getElementById("laMatanzaMunicipio").style.display = "none";
            document.getElementById("lomasDeZamoraMunicipio").style.display = "none";
            document.getElementById("morenoMunicipio").style.display = "none";
            document.getElementById("moronMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("sanFernandoMunicipio").style.display = "none";
            document.getElementById("tigreMunicipio").style.display = "none";
            document.getElementById("avellanedaMunicipio").style.display = "none";
            document.getElementById("ezeizaMunicipio").style.display = "none";
            document.getElementById("florencioVarelaMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("vicenteLopezMunicipio").style.display = "none";
        }

        if (cod == "Trujui" || cod == "Paso del Rey" || cod == "Moreno"|| cod == "La Reja"){
            document.getElementById("hurlinghamMunicipio").style.display = "none";
            document.getElementById("ituzaingoMunicipio").style.display = "none";
            document.getElementById("laMatanzaMunicipio").style.display = "none";
            document.getElementById("lomasDeZamoraMunicipio").style.display = "none";
            document.getElementById("moronMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("sanFernandoMunicipio").style.display = "none";
            document.getElementById("tigreMunicipio").style.display = "none";
            document.getElementById("avellanedaMunicipio").style.display = "none";
            document.getElementById("ezeizaMunicipio").style.display = "none";
            document.getElementById("florencioVarelaMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("vicenteLopezMunicipio").style.display = "none";
        }

        if (cod == "Lomas del Mirador" || cod == "La Tablada" || cod == "Isidro Casanova"|| cod == "San Justo"|| cod == "Gregorio de Laferrere"){
            document.getElementById("hurlinghamMunicipio").style.display = "none";
            document.getElementById("ituzaingoMunicipio").style.display = "none";
            document.getElementById("lomasDeZamoraMunicipio").style.display = "none";
            document.getElementById("morenoMunicipio").style.display = "none";
            document.getElementById("moronMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("sanFernandoMunicipio").style.display = "none";
            document.getElementById("tigreMunicipio").style.display = "none";
            document.getElementById("avellanedaMunicipio").style.display = "none";
            document.getElementById("ezeizaMunicipio").style.display = "none";
            document.getElementById("florencioVarelaMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("vicenteLopezMunicipio").style.display = "none";
        }

        if (cod == "Wilde" || cod == "Valent�n Alsina"){
            document.getElementById("hurlinghamMunicipio").style.display = "none";
            document.getElementById("ituzaingoMunicipio").style.display = "none";
            document.getElementById("laMatanzaMunicipio").style.display = "none";
            document.getElementById("lomasDeZamoraMunicipio").style.display = "none";
            document.getElementById("morenoMunicipio").style.display = "none";
            document.getElementById("moronMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("sanFernandoMunicipio").style.display = "none";
            document.getElementById("tigreMunicipio").style.display = "none";
            document.getElementById("ezeizaMunicipio").style.display = "none";
            document.getElementById("florencioVarelaMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("vicenteLopezMunicipio").style.display = "none";
        }

        if (cod == "Villa Fiorito" || cod == "Banfield"){
            document.getElementById("hurlinghamMunicipio").style.display = "none";
            document.getElementById("ituzaingoMunicipio").style.display = "none";
            document.getElementById("laMatanzaMunicipio").style.display = "none";
            document.getElementById("morenoMunicipio").style.display = "none";
            document.getElementById("moronMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("sanFernandoMunicipio").style.display = "none";
            document.getElementById("tigreMunicipio").style.display = "none";
            document.getElementById("avellanedaMunicipio").style.display = "none";
            document.getElementById("ezeizaMunicipio").style.display = "none";
            document.getElementById("florencioVarelaMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("vicenteLopezMunicipio").style.display = "none";
        }

        if (cod == "Canning" || cod == "Jos� Mar�a Ezeiza" || cod == "Carlos Spegazzini"){
            document.getElementById("hurlinghamMunicipio").style.display = "none";
            document.getElementById("ituzaingoMunicipio").style.display = "none";
            document.getElementById("laMatanzaMunicipio").style.display = "none";
            document.getElementById("lomasDeZamoraMunicipio").style.display = "none";
            document.getElementById("morenoMunicipio").style.display = "none";
            document.getElementById("moronMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("sanFernandoMunicipio").style.display = "none";
            document.getElementById("tigreMunicipio").style.display = "none";
            document.getElementById("avellanedaMunicipio").style.display = "none";
            document.getElementById("florencioVarelaMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("vicenteLopezMunicipio").style.display = "none";
        }

        if (cod == "Hurlingham" || cod == "William C. Morris"){
            document.getElementById("ituzaingoMunicipio").style.display = "none";
            document.getElementById("lomasDeZamoraMunicipio").style.display = "none";
            document.getElementById("morenoMunicipio").style.display = "none";
            document.getElementById("moronMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("sanFernandoMunicipio").style.display = "none";
            document.getElementById("tigreMunicipio").style.display = "none";
            document.getElementById("avellanedaMunicipio").style.display = "none";
            document.getElementById("ezeizaMunicipio").style.display = "none";
            document.getElementById("florencioVarelaMunicipio").style.display = "none";
            document.getElementById("sanIsidroMunicipio").style.display = "none";
            document.getElementById("vicenteLopezMunicipio").style.display = "none";
            document.getElementById("laMatanzaMunicipio").style.display = "none";
        }

        /* Para obtener el texto
        var combo = document.getElementById("nombreLocalidad");
        var selected = combo.options[combo.selectedIndex].text;
        alert(selected);*/
    }
</script>
</html>