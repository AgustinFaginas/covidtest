<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1" %>
		 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		 
<!doctype html>

<html lang="es">

<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		  integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<title>Ver Mensajes</title>

	<link rel="icon" href="img/asignar-logo.ico">

	<style>
		#navbar-top:hover {
			text-decoration: none;
		}
	</style>

</head>

<body>

<nav class="navbar sticky-top bg-dark text-white justify-content-center align-items-center">
	<a class="text-center text-white" href="https://www.argentina.gob.ar/salud/coronavirus-COVID-19" id="navbar-top">
		<h5>
			Coronavirus COVID-19 conoc� informaci�n y recomendaciones del Ministerio de Salud</strong>
		</h5>
	</a>
</nav>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="#"> <img src="img/share2.png"
			width="35" height="35" class="d-inline-block align-top" alt="logo">
			AsignAR
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item ml-5 active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<!-- <li class="nav-item ml-5"><a class="nav-link" href="autoTest">Realizar
						test</a></li> -->
						
						<li class="nav-item ml-5"><a class="btn btn-danger" href="autoTest" role="button">Realizar Autotest</a></li>
						<li class="nav-item ml-5"><a class="btn btn-secondary" href="registrarInstitucion" role="button">Registrar Instituci�n</a></li>
						<!-- <li class="nav-item ml-5"><a class="nav-link" href="registrarInstitucion">Registrar Institucion</a></li> -->
			</ul>
			<c:if test="${alert == null}">
				<a href="/covidtest/logout" class="btn btn-dark ml-5" role="button"
					aria-disabled="true">Log out</a>
			</c:if>

		</div>
	</nav>

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
				<h6 class="text-uppercase mb-4 font-weight-bold">ENLACES �TILES</h6>
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
