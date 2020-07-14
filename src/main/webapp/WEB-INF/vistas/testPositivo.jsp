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
            Coronavirus COVID-19 conocé información y recomendaciones del Ministerio de Salud</strong>
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
        <button type="button" class="btn btn-dark ml-5">Log in</button>
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
                                       data-msg="Ingrese número de CUIT valido" required/>
                                <small id="calleHelp" class="form-text text-muted">Ingrese la calle en donde
                                    reside actualmente</small>
                            </div>
                            <div class="form-group col-3">
                                <label for="numero">Número <span class="text-primary font-weight-bold">*</span></label>
                                <input type="number" name="numero" class="form-control br-radius-zero"
                                       id="numero" data-rule="minlen:1"
                                       data-msg="Ingrese número de CUIT valido" required/>
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
                                        required>
                                    <option id="Vicente López" name="Vicente López">Vicente López
                                    <option id="Villa Martelli" name="Villa Martelli">Villa Martelli
                                    <option id="Munro" name="Munro">Munro
                                    <option id="Martínez" name="Martínez">Martínez
                                    <option id="San Isidro" name="San Isidro">San Isidro
                                    <option id="Beccar" name="Beccar">Beccar
                                    <option id="Victoria" name="Victoria">Victoria
                                    <option id="Tigre" name="Tigre">Tigre
                                    <option id="General Pacheco" name="General Pacheco">General Pacheco
                                    <option id="Don Torcuato" name="Don Torcuato">Don Torcuato
                                    <option id="Villa Sarmiento" name="Villa Sarmiento">Villa Sarmiento
                                    <option id="El Palomar" name="El Palomar">El Palomar
                                    <option id="Haedo" name="Haedo">Haedo
                                    <option id="Morón" name="Morón">Morón
                                    <option id="Castelar" name="Castelar">Castelar
                                    <option id="Hurlingham" name="Hurlingham">Hurlingham
                                    <option id="William C. Morris" name="William C. Morris">William C. Morris
                                    <option id="Udaondo" name="Udaondo">Udaondo
                                    <option id="Trujui" name="Trujui">Trujui
                                    <option id="Paso del Rey" name="Paso del Rey">Paso del Rey
                                    <option id="Moreno" name="Moreno">Moreno
                                    <option id="La Reja" name="La Reja">La Reja
                                    <option id="Lomas del Mirador" name="Lomas del Mirador">Lomas del Mirador
                                    <option id="La Tablada" name="La Tablada">La Tablada
                                    <option id="Isidro Casanova" name="Isidro Casanova">Isidro Casanova
                                    <option id="Gregorio de Laferrere" name="Gregorio de Laferrere">Gregorio de
                                        Laferrere
                                    <option id="San Justo" name="San Justo">San Justo
                                    <option id="Wilde" name="Wilde">Wilde
                                    <option id="Valentín Alsina" name="Valentín Alsina">Valentín Alsina
                                    <option id="Villa Fiorito" name="Villa Fiorito">Villa Fiorito
                                    <option id="Banfield" name="Banfield">Banfield
                                    <option id="José María Ezeiza" name="José María Ezeiza">José María Ezeiza
                                    <option id="Canning" name="Canning">Canning
                                    <option id="Carlos Spegazzini" name="Carlos Spegazzini">Carlos Spegazzini
                                </select>
                                <small id="localidadHelp" class="form-text text-muted">Seleccione la localidad en donde
                                    reside actualmente</small>
                            </div>
                            <div class="form-group col-6">
                                <label for="nombrePartido">Partido <span
                                        class="text-primary font-weight-bold">*</span></label>
                                <select name="nombrePartido" id="nombrePartido" class="form-control br-radius-zero"
                                        required>
                                    <option id="vicenteLopezMunicipio" name="Vicente López">Vicente López
                                    <option id="sanIsidroMunicipio" name="San Isidro">San Isidro
                                    <option id="sanFernandoMunicipio" name="San Fernando">San Fernando
                                    <option id="tigreMunicipio" name="Tigre">Tigre
                                    <option id="moronMunicipio" name="Morón">Morón
                                    <option id="hurlinghamMunicipio" name="hurlinghamMunicipio">Hurlingham
                                    <option id="ituzaingoMunicipio" name="ituzaingoMunicipio">Ituzaingó
                                    <option id="morenoMunicipio" name="morenoMunicipio">Moreno
                                    <option id="laMatanzaMunicipio" name="laMatanzaMunicipio">La Matanza
                                    <option id="avellanedaMunicipio" name="avellanedaMunicipio">Avellaneda
                                    <option id="lomasDeZamoraMunicipio" name="lomasDeZamoraMunicipio">Lomas de Zamora
                                    <option id="ezeizaMunicipio" name="ezeizaMunicipio">Ezeiza
                                    <option id="florencioVarelaMunicipio" name="florencioVarelaMunicipio">Florencio
                                        Varela
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
                            <label for="password">Contraseña <span
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
                                    <option id="tipoDocumentoLibretaCivica">LIBRETA CÍVICA
                                </select>
                            </div>
                            <div class="form-group col-6">
                                <label for="numeroDocumento">Numero de documento <span
                                        class="text-primary font-weight-bold">*</span></label>
                                <input type="text" name="numeroDocumento" class="form-control br-radius-zero"
                                       id="numeroDocumento"
                                       data-rule="minlen:1"
                                       data-msg="Ingrese número de CUIT valido" required/>
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
                    <label for="password">Contraseña</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>

                <div class="form-row">

                    <div class="col-4 mb-3">
                        <label for="tipoDni">Tipo Documento</label>
                        <select name="tipoDocumento" id="tipoDocumento" class="form-control br-radius-zero" required>
                            <option id="tipoDocumento">DNI
                            <option id="tipoDocumento">PASAPORTE
                            <option id="tipoDocumento">LIBRETA CÍVICA
                        </select>
                    </div>

                    <div class="col-8 mb-3">
                        <label for="numeroDni">Numero de documento</label>
                        <input type="text" name="numeroDocumento" class="form-control br-radius-zero"
                               id="numeroDocumento"
                               placeholder="Ingrese número de documento" data-rule="minlen:1"
                               data-msg="Ingrese número de CUIT valido" required/>
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
                <h6 class="text-uppercase mb-4 font-weight-bold">ENLACES ÚTILES</h6>
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