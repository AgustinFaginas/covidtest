<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/${armarHeader}1.jsp" />

<title>Disponibilidad De Camas</title>
    
<jsp:include page="../../partial/${armarHeader}2.jsp" />

<div class="progress my-1">
    <div class="progress-bar bg-success" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0"
         aria-valuemax="100">100%
    </div>
</div>

<div class="container-fluid mt-5 mb-3">
    <div class="row">
        <div class="col-3"></div>
        <div class="col-2">
            <div id="qrcode">
                <img src="https://www.codigos-qr.com/qr/php/qr_img.php?d=https%3A%2F%2Fwww.argentina.gob.ar%2Fsalud%2Fcoronavirus-COVID-19&s=6&e=m"
                     alt="Generador de C�digos QR Codes"/>
            </div>
        </div>
        <div class="col-4 pt-4 text-justify">
            <h4 class="mb-4"><strong>DECLARACI�N JURADA - CORONAVIRUS COVID-19</strong></h4>
            <h6 style="line-height: 200%">Declaraci�n Jurada de Excepci�n para Circulaci�n en Emergencia
                Sanitaria - COVID 19 conforme Art�culo 6� Decreto 297/2020</h6>
        </div>
        <div class="col-3"></div>
    </div>
</div>

<div class="container-fluid my-5 text-justify">
    <div class="row">

        <div class="col-2"></div>

        <div class="col-8">
            <h6 style="line-height: 200%">Por medio de la presente, se procede a exceptuar
                a ${apellido}, ${nombre}, ${tipoDocumento} ${numeroDocumento}, con domicilio en ${calle} ${numeroCalle}
                - ${nombreLocalidad}, del partido de ${nombrePartido} tel�fono ${telefono}, correo electr�nico ${email}, <strong>de los alcances establecidos por el
                    Decreto
                    2020-
                    297-APN-PTE</strong> del presente a�o, <strong>en virtud de la criticidad de las
                    tareas
                    desarrolladas y
                    contempladas como excepciones dentro del cumplimiento del "aislamiento social, preventivo y
                    obligatorio"
                    y de la prohibici�n de circular.</strong></h6>

            <h6 style="line-height: 200%">Se deja constancia que la persona exceptuada ha sido informada sobre las
                recomendaciones y medidas de
                prevenci�n del Ministerio de Salud de la Naci�n sobre el Coronavirus COVID-19 establecidos en el sitio
                web
                <a href="https://www.argentina.gob.ar/salud/coronavirus-COVID-19">https://www.argentina.gob.ar/salud/coronavirus-COVID-19</a>.
            </h6>

            <h6 style="line-height: 200%"> Dicha declaraci�n jurada, se emite en virtud del Decreto de Necesidad y
                Urgencia que establece para
                todas las
                personas que habitan en el pa�s o se encuentren en �l en forma temporaria, la medida de "aislamiento
                social,
                preventivo y obligatorio", destinadas a proteger la salud p�blica, constituyendo de esta manera una
                obligaci�n
                inalienable del Estado Nacional.</h6>

            <h6 style="line-height: 200%">La declaraci�n jurada tendr� validez mientras est� en vigencia el decreto
                mencionado en el primer
                p�rrafo.</h6>

            <h6 class="my-2"><strong>Car�cter de la excepci�n:</strong> ${motivo}.</h6>

            <h6 class="my-2" style="line-height: 200%">Declaro bajo juramento que los datos consignados en este
                formulario son veraces, reales y completos sin omitir ni
                falsear dato alguno que deba contener, siendo fiel expresi�n de la verdad.
                Si se verifica que tu informaci�n es falsa, incurrir�s en un delito con consecuencias penales.</h6>


        </div>
        <div class="col-2"></div>
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

</html>