<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/${armarHeader}1.jsp" />

<title>Inserte Título Aquí</title>
    
<jsp:include page="../../partial/${armarHeader}2.jsp" />

        <main role="main" class="col-md-9 ml-sm-auto col-lg-12 px-md-4">

            
            <div class="container">
				
<br>
            <h2>Mensajes</h2>
            <br>
                
                 <table class="table table-bordered table-hover responsive nowrap text-center align-middle">
                    <tr class="text-center align-middle">
                        <th scope="col">De: </th>
                        <th scope="col">Mensaje</th>
                        <th scope="col">Fecha y Hora</th>
                        <th scope="col">Rol</th>
                        <th scope="col">Acciones</th>
                    </tr>
						<c:forEach items="${list}" var="notificacion">
							<tr>
								<td class="align-middle"><c:out
										value="${notificacion.getRemitente().getNombre()}" /></td>
								<td class="align-middle"><c:out
										value="${notificacion.getMsg()}" /></td>
								<td class="align-middle"><c:out
										value="${notificacion.getFechaHora()}" /></td>
										<td class="align-middle"><c:out
										value="${notificacion.getRemitente().getRol().name()}" /></td>
										
										
										<td><a class="btn btn-primary" href="#"
										role="button">Ver Mensaje</a></td>

								

									</form>
									</div>
								</td>
						</c:forEach>
					</table>
            </div>
        </main>
    </div>
</div>
<script>

</script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script>
    window.jQuery
    || document
        .write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')
</script>
<script src="../assets/dist/js/bootstrap.bundle.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
<script src="js/dashboard.js"></script>
<script>
    
</script>
</body>

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
