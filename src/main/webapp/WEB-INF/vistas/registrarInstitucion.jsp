<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/headerInstitucionesParte1.jsp"/>

<title>Registrar Institucion</title>

<jsp:include page="../../partial/headerInstitucionesParte2.jsp"/>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">


 

    <div class="container">
    
       <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h4>Registrar Institución</h4>

    </div>
    
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
                        <option id="José María Ezeiza" class="partido12" name="José María Ezeiza">José María
                            Ezeiza
                        <option id="La Reja" class="partido8" name="La Reja">La Reja
                        <option id="La Tablada" class="partido9" name="La Tablada">La Tablada
                        <option id="Lomas del Mirador" class="partido9" name="Lomas del Mirador">Lomas del
                            Mirador
                        <option id="Martínez" class="partido2" name="Martínez">Martínez
                        <option id="Moreno" class="partido8" name="Moreno">Moreno
                        <option id="Morón" class="partido9" name="Morón">Morón
                        <option id="Munro" class="partido1" name="Munro">Munro
                        <option id="Paso del Rey" class="partido8" name="Paso del Rey">Paso del Rey
                        <option id="San Isidro" class="partido2" name="San Isidro">San Isidro
                        <option id="San Justo" class="partido9" name="San Justo">San Justo
                        <option id="Tigre" class="partido4" name="Tigre">Tigre
                        <option id="Trujui" class="partido8" name="Trujui">Trujui
                        <option id="Udaondo" class="partido7" name="Udaondo">Udaondo
                        <option id="Valentín Alsina" class="partido10" name="Valentín Alsina">Valentín
                            Alsina
                        <option id="Vicente López" class="partido1" name="Vicente López">Vicente López
                        <option id="Victoria" class="partido3" name="Victoria">Victoria
                        <option id="Villa Fiorito" class="partido11" name="Villa Fiorito">Villa Fiorito
                        <option id="Villa Martelli" class="partido1" name="Villa Martelli">Villa Martelli
                        <option id="Villa Sarmiento" class="partido5" name="Villa Sarmiento">Villa Sarmiento
                        <option id="Wilde" class="partido10" name="Wilde">Wilde
                        <option id="William C. Morris" class="partido6" name="William C. Morris">William C.
                            Morris
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

        if (cod == "Munro" || cod == "Villa Martelli"|| cod == "Vicente López"){
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

        if (cod == "Martínez" || cod == "San Isidro" || cod == "Beccar"){
            document.getElementById("hurlinghamMunicipio").style.display = "none";
            document.getElementById("ituzaingoMunicipio").style.display = "none";
            document.getElementById("laMatanzaMunicipio").style.display = "none";
            document.getElementById("lomasDeZamoraMunicipio").style.display = "none";
            document.getElementById("morenoMunicipio").style.display = "none";
            document.getElementById("moronMunicipio").style.display = "none";
            document.getElementById("sanFernandoMunicipio").style.display = "none";
            document.getElementById("tigreMunicipio").style.display = "none";
            document.getElementById("avellanedaMunicipio").style.display = "none";
            document.getElementById("ezeizaMunicipio").style.display = "none";
            document.getElementById("florencioVarelaMunicipio").style.display = "none";
            document.getElementById("vicenteLopezMunicipio").style.display = "none";
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

        if (cod == "Villa Sarmiento" || cod == "El Palomar" || cod == "Haedo"|| cod == "Morón"|| cod == "Castelar"){
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

        if (cod == "Ituzaingó" || cod == "Udaondo"){
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

        if (cod == "Wilde" || cod == "Valentín Alsina"){
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

        if (cod == "Canning" || cod == "José María Ezeiza" || cod == "Carlos Spegazzini"){
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
</body>
</html>