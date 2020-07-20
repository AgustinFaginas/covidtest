<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/${armarHeader}1.jsp" />

<title>Inserte titulo aquí</title>
    
<jsp:include page="../../partial/${armarHeader}2.jsp" />

<div class="progress my-1">
    <div class="progress-bar bg-success" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0"
         aria-valuemax="100">50%
    </div>
</div>

<div class="container-fluid my-5">
    <div class="row">

        <div class="col-4"></div>

        <div class="col-4">

            <div class="card border-dark mb-3">
                <div class="card-header">
                    <h3 class="text-center my-2">Complete el formulario con sus síntomas</h3>
                </div>
                <div class="card-body text-dark">
                    <form action="validarTest" method="get"
                          class="d-flex justify-content-center flex-column justify-content-center">
                        <div class="form-group row my-4">
                            <label for="fiebre" class="col-6 col-form-label h6">Indique su temperatura corporal</label>
                            <div class="col-6 align-self-center">
                                <input type="number" class="form-control" id="fiebre" name="fiebre" min="35" max="42"
                                       required>
                            </div>
                        </div>
                        <div class="form-group">
                            <ul class="list-group">
                                <li class="list-group-item list-group-item-secondary text-center">Consejos para medir la
                                    temperatura
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center disabled">
                                    Medir la temperatura siempre en el mismo lugar (oído y axila), ya que de otro modo
                                    pueden variar los valores.
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center disabled">
                                    No se debe tomar la temperatura después del baño o de haber realizado una actividad
                                    física. Se debe esperar por lo menos 20 minutos.
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center disabled">
                                    La fiebre hay que medirla, no hay que fiarse de la percepción que se tenga al
                                    momento de tocar la frente.
                                </li>
                            </ul>

                        </div>
                        <div class="form-group form-check my-4">
                            <input type="checkbox" class="form-check-input" id="perdidaOlfato" name="perdidaOlfato">
                            <label class="form-check-label h6" for="perdidaOlfato">¿Sentís perdida parcial del olfato?
                            </label></label>
                        </div>
                        <div class="form-group form-check my-4">
                            <input type="checkbox" class="form-check-input" id="perdidaGusto" name="perdidaGusto">
                            <label class="form-check-label h6" for="perdidaGusto">¿Sentís una perdida parcial del
                                gusto?</label>
                        </div>
                        <div class="form-group form-check my-4">
                            <input type="checkbox" class="form-check-input" id="tos" name="tos">
                            <label class="form-check-label h6" for="tos">¿Tenés tos o dolor de garganta?</label>
                        </div>
                        <div class="form-group form-check my-4">
                            <input type="checkbox" class="form-check-input" id="perdidaRespiracion"
                                   name="perdidaRespiracion">
                            <label class="form-check-label h6" for="perdidaRespiracion">¿Tenés dificultad respiratoria o
                                falta
                                de aire?</label>
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