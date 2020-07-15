<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/headerInstitucionesParte1.jsp"/>

<title>Registrar Institucion</title>

<jsp:include page="../../partial/headerInstitucionesParte2.jsp"/>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">


    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h4>Registrar Institución</h4>

    </div>

    <div class="">
        <div>

            <form action="detalleRegistroInstitucion" method="POST" modelAttribute="institcuion" role="form"
                  class="contactForm">

                <div class="form-group">
                    <label for="nombre" class="h6 my-3">Nombre de la Institución<span
                            class="text-primary font-weight-bold">*</span></label>
                    <input type="text" name="nombre" class="form-control br-radius-zero" id="nombre"
                           placeholder="Ingrese el nombre de la institución" data-rule="minlen:3"
                           data-msg="Ingrese un nombre válido"/>
                    <div class="validation"></div>
                </div>

                <div class="form-group">
                    <label for="numeroDocumento" class="h6 my-3">Número de CUIT<span
                            class="text-primary font-weight-bold">*</span></label>
                    <input type="text" name="numeroDocumento" class="form-control br-radius-zero" id="numeroDocumento"
                           placeholder="Ingrese número de CUIT" data-rule="minlen:1"
                           data-msg="Ingrese número de CUIT valido"/>
                    <div class="validation"></div>
                </div>

                <div class="form-row">
                    <div class="form-group col-9">
                        <label for="calle" class="h6 my-3">Calle <span
                                class="text-primary font-weight-bold">*</span></label>
                        <input type="text" name="calle" class="form-control br-radius-zero"
                               id="calle" data-rule="minlen:1"
                               data-msg="Ingrese número de CUIT valido" required/>

                    </div>
                    <div class="form-group col-3">
                        <label for="numero" class="h6 my-3">Número <span class="text-primary font-weight-bold">*</span></label>
                        <input type="number" name="numero" class="form-control br-radius-zero"
                               id="numero" data-rule="minlen:1"
                               data-msg="Ingrese número de CUIT valido" required/>
                    </div>
                </div>

                <%--<div class="form-row my-4">
                    <label for="nombreLocalidad">Localidad <span class="text-primary font-weight-bold">*</span></label>
                    <input type="text" class="form-control" id="nombreLocalidad" name="nombreLocalidad" required>
                </div>--%>

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
                </div>

                <div class="form-group">
                    <label for="nombrePartido" class="h6 my-3">Partido <span
                            class="text-primary font-weight-bold">*</span></label>
                    <select name="nombrePartido" id="nombrePartido" class="form-control br-radius-zero"
                            required>
                        <option id="avellanedaMunicipio" name="avellanedaMunicipio">Avellaneda
                        <option id="ezeizaMunicipio" name="ezeizaMunicipio">Ezeiza
                        <option id="florencioVarelaMunicipio" name="florencioVarelaMunicipio">Florencio
                            Varela
                        <option id="hurlinghamMunicipio" name="hurlinghamMunicipio">Hurlingham
                        <option id="ituzaingoMunicipio" name="ituzaingoMunicipio">Ituzaingó
                        <option id="laMatanzaMunicipio" name="laMatanzaMunicipio">La Matanza
                        <option id="lomasDeZamoraMunicipio" name="lomasDeZamoraMunicipio">Lomas de Zamora
                        <option id="morenoMunicipio" name="morenoMunicipio">Moreno
                        <option id="moronMunicipio" name="Morón">Morón
                        <option id="sanIsidroMunicipio" name="San Isidro">San Isidro
                        <option id="sanFernandoMunicipio" name="San Fernando">San Fernando
                        <option id="tigreMunicipio" name="Tigre">Tigre
                        <option id="vicenteLopezMunicipio" name="Vicente López">Vicente López
                    </select>
                </div>

                <div class="form-group">
                    <label for="cantidadCamas" class="h6 my-3">Cantidad de camas<span
                            class="text-primary font-weight-bold">*</span></label>
                    <input type="number" class="form-control input-sm" id="cantidadCamas" name="cantidadCamas" min="1"
                           max="2000"
                           placeholder="Ingrese la cantidad de camas de la institución">
                </div>

                <div class="form-group">
                    <label for="email" class="h6 my-3">Email<span class="text-primary font-weight-bold">*</span></label>
                    <input type="text" name="email" class="form-control br-radius-zero" id="email"
                           placeholder="Ingrese un mail" data-rule="mail"
                           data-msg="Ingrese un mail valido"/>
                    <div class="validation"></div>
                </div>

                <div class="form-group">
                    <label for="password" class="h6 my-3">Contraseña de la cuenta<span
                            class="text-primary font-weight-bold">*</span></label>
                    <input type="text" name="password" class="form-control br-radius-zero" id="password"
                           placeholder="Ingrese una contraseña" data-rule="minlen:1"
                           data-msg="Ingrese una contraseña valida"/>
                    <div class="validation"></div>
                </div>

                <br>
                <div class="form-action">
                    <button type="submit" class="btn btn-outline-secondary">
                        Registrar institución
                    </button>
                </div>
                <br>
                <div class="form-group">
                    <c:if test="${not empty error}">
                    <h6><span>${error}</span></h6>
                    <br>
                </div>
                </c:if>

            </form>

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
</body>
</html>