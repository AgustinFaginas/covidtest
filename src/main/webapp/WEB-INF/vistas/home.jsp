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
				<li class="nav-item ml-5"><a class="nav-link" href="autoTest">Realizar
						test</a></li>
			</ul>
			<c:if test="${alert == null}">
				<a href="login" class="btn btn-dark ml-5" role="button"
					aria-disabled="true">Log in</a>
			</c:if>

		</div>
	</nav>

	<h2 class="text-center mb-3 mt-5">Consejos para prevenir el Coronavirus</h2>

<div class="container mb-5">
	<div class="row">
		<div class="col">
			<div class="container mt-5">
				<div class="row">
					<div class="col-xl-3 col-sm-12">
						<img class="d-inline" src="img/handwash1.png" width="100" height="100"
							 alt="Generic placeholder image">
					</div>
					<div class="col-xl-9 col-sm-12">
						<h4 class="d-inline">Lavarse las manos con jab�n regularmente al menos por 20 segundos</h4>
					</div>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="container mt-5">
				<div class="row">
					<div class="col-xl-3 col-sm-12">
						<img class="d-inline" src="img/nottouch.png" width="100" height="100"
							 alt="Generic placeholder image">
					</div>
					<div class="col-xl-9 col-sm-12">
						<h4 class="d-inline">No llevarse las manos a los ojos y la nariz</h4>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<div class="container mt-5">
				<div class="row">
					<div class="col-xl-3 col-sm-12">
						<img class="d-inline" src="img/window.png" width="100" height="100"
							 alt="Generic placeholder image">
					</div>
					<div class="col-xl-9 col-sm-12">
						<h4 class="d-inline">Ventilar los ambientes</h4>
					</div>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="container mt-5">
				<div class="row">
					<div class="col-xl-3 col-sm-12">
						<img class="d-inline" src="img/clean.png" width="100" height="100"
							 alt="Generic placeholder image">
					</div>
					<div class="col-xl-9 col-sm-12">
						<h4 class="d-inline">Desinfectar los objetos que se usan con frecuencia</h4>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<div class="container mt-5">
				<div class="row">
					<div class="col-xl-3 col-sm-12">
						<img class="d-inline" src="img/bat.png" width="100" height="100"
							 alt="Generic placeholder image">
					</div>
					<div class="col-xl-9 col-sm-12">
						<h4 class="d-inline">No comer sopita de murci�lago y/o derivados</h4>
					</div>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="container mt-5">
				<div class="row">
					<div class="col-xl-3 col-sm-12">
						<img class="d-inline" src="img/stayhome.png" width="100" height="100"
							 alt="Generic placeholder image">
					</div>
					<div class="col-xl-9 col-sm-12">
						<h4 class="d-inline">Permanecer en su hogar el mayor tiempo posible. Salir en casos
							extremos</h4>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<div class="container mt-5">
				<div class="row">
					<div class="col-xl-3 col-sm-12">
						<img class="d-inline" src="img/physical.png" width="100" height="100"
							 alt="Generic placeholder image">
					</div>
					<div class="col-xl-9 col-sm-12">
						<h4 class="d-inline">Mantener distancia de otras personas fueras de su hogar</h4>
					</div>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="container mt-5">
				<div class="row">
					<div class="col-xl-3 col-sm-12">
						<img class="d-inline" src="img/medical-mask.png" width="100" height="100"
							 alt="Generic placeholder image">
					</div>
					<div class="col-xl-9 col-sm-12">
						<h4 class="d-inline">Cubrirse la boca y la nariz con barbijo o tapaboca al estar rodeado de
							personas</h4>
					</div>
				</div>
			</div>
		</div>
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