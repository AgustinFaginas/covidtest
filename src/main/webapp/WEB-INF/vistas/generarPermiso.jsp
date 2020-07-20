<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/${armarHeader}1.jsp" />

<title>Inserte titulo aquí</title>
    
<jsp:include page="../../partial/${armarHeader}2.jsp" />

<div class="progress my-1">
    <div class="progress-bar bg-success" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0"
         aria-valuemax="100">75%
    </div>
</div>

<div class="container my-5">
    <h3 class="text-center my-3">Complete los siguientes datos y genere su permiso de circulacion </h3>
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
                    <form action="validarPermiso" method="POST"
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

                        <div class="form-group">
                            <label for="nombreLocalidad" class="h6 my-3">Localidad <span
                                    class="text-primary font-weight-bold">*</span></label>
                            <select name="nombreLocalidad" id="nombreLocalidad" class="form-control br-radius-zero"
                                    required>
                                <option id="Banfield" name="Banfield">Banfield
                                <option id="Beccar" name="Beccar">Beccar
                                <option id="Carlos Spegazzini" name="Carlos Spegazzini">Carlos Spegazzini
                                <option id="Canning" name="Canning">Canning
                                <option id="Castelar" name="Castelar">Castelar
                                <option id="Don Torcuato" name="Don Torcuato">Don Torcuato
                                <option id="El Palomar" name="El Palomar">El Palomar
                                <option id="General Pacheco" name="General Pacheco">General Pacheco
                                <option id="Gregorio de Laferrere" name="Gregorio de Laferrere">Gregorio de
                                    Laferrere
                                <option id="Haedo" name="Haedo">Haedo
                                <option id="Hurlingham" name="Hurlingham">Hurlingham
                                <option id="Isidro Casanova" name="Isidro Casanova">Isidro Casanova
                                <option id="José María Ezeiza" name="José María Ezeiza">José María Ezeiza
                                <option id="La Reja" name="La Reja">La Reja
                                <option id="La Tablada" name="La Tablada">La Tablada
                                <option id="Lomas del Mirador" name="Lomas del Mirador">Lomas del Mirador
                                <option id="Martínez" name="Martínez">Martínez
                                <option id="Moreno" name="Moreno">Moreno
                                <option id="Morón" name="Morón">Morón
                                <option id="Munro" name="Munro">Munro
                                <option id="Paso del Rey" name="Paso del Rey">Paso del Rey
                                <option id="San Isidro" name="San Isidro">San Isidro
                                <option id="San Justo" name="San Justo">San Justo
                                <option id="Tigre" name="Tigre">Tigre
                                <option id="Trujui" name="Trujui">Trujui
                                <option id="Udaondo" name="Udaondo">Udaondo
                                <option id="Valentín Alsina" name="Valentín Alsina">Valentín Alsina
                                <option id="Vicente López" name="Vicente López">Vicente López
                                <option id="Victoria" name="Victoria">Victoria
                                <option id="Villa Fiorito" name="Villa Fiorito">Villa Fiorito
                                <option id="Villa Martelli" name="Villa Martelli">Villa Martelli
                                <option id="Villa Sarmiento" name="Villa Sarmiento">Villa Sarmiento
                                <option id="Wilde" name="Wilde">Wilde
                                <option id="William C. Morris" name="William C. Morris">William C. Morris
                            </select>
                            <small id="localidadHelp" class="form-text text-muted">Seleccione la localidad en donde
                                reside actualmente</small>
                        </div>

                        <div class="form-row my-4">
                            <div class="form-group col-6">
                                <label for="calle">Calle <span class="text-primary font-weight-bold">*</span></label>
                                <input type="text" name="calle" class="form-control br-radius-zero"
                                       id="calle" required/>
                                <small id="calleHelp" class="form-text text-muted">Ingrese la calle en donde
                                    reside actualmente</small>
                            </div>
                            <div class="form-group col-6">
                                <label for="numeroCalle">Número <span
                                        class="text-primary font-weight-bold">*</span></label>
                                <input type="number" name="numeroCalle" class="form-control br-radius-zero"
                                       id="numeroCalle"
                                       data-msg="Ingrese número de calle válido" required/>
                            </div>
                        </div>

                        <div class="form-row my-4">
                            <label for="telefono">Teléfono <span class="text-primary font-weight-bold">*</span></label>
                            <input type="tel" class="form-control" id="telefono" name="telefono" required> <small
                                id="numeroTelefonoHelp" class="form-text text-muted">Sin puntos guiones ni espacios. Ej:
                            1530874512</small>
                        </div>

                        <div class="form-row my-4">
                            <label for="email">Correo electrónico <span
                                    class="text-primary font-weight-bold">*</span></label>
                            <input type="text" class="form-control" id="email" name="email" required>
                            <small id="emailHelp" class="form-text text-muted">Ej: maria@email.com</small>
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
                                <label for="numeroDocumento">Número de documento <span
                                        class="text-primary font-weight-bold">*</span></label>
                                <input type="text" name="numeroDocumento" class="form-control br-radius-zero"
                                       id="numeroDocumento"
                                       data-msg="Ingrese número de documento válido" required/>
                                <small id="numeroDocumentoHelp" class="form-text text-muted">Sin puntos ni espacios. Ej:
                                    30758124</small>
                            </div>
                        </div>

                        <div class="form-row my-4">
                            <label for="motivo">Motivo del permiso <span class="text-primary font-weight-bold">*</span></label>
                            <select name="motivo" id="motivo" class="form-control br-radius-zero"
                                    required>
                                <option id="motivo1">Asistencia a un adulto mayor
                                <option id="motivo2">Turno médico
                                <option id="motivo3">Trámite
                                <option id="motivo4">Trabajo escencial
                            </select>
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