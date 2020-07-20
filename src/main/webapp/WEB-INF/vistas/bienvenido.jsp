<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/${armarHeader}1.jsp" />

<title>Inserte titulo aquí</title>
    
<jsp:include page="../../partial/${armarHeader}2.jsp" />

                <div class="jumbotron">
                    <h1 class="display-4">Bienvenido/a</h1>
                    <p class="lead">Desde aquí acceda a las opciones principales de:
                        ${nombre}</p>
                    <p class="lead">La institución ${nombre} posee ${camas} camas en total.</p>
                    <a class="btn btn-outline-primary" href="verMensajes" role="button">Ver Mensajes Recibidos</a>
                    <a class="btn btn-outline-primary" href="crearMensaje" role="button">Enviar Mensaje</a>
                    <hr class="my-4">
                    		<p class="lead">
			<a class="btn btn-primary btn-lg" href="listaPacientesInternados" role="submit">
				Panel de Control</a>
		</p>
                </div>
            </div>

</div>


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
