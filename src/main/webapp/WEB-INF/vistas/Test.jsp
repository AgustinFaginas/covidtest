<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<title>Test</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">CovidTest</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Principal</a></li>
				<li><a href="#">FAQ</a></li>
				<li><a href="#">Ingresar</a></li>
				<li><a href="#">Regístrese</a></li>
			</ul>
		</div>
	</nav>
	<div class="container mt-3">
		<h1>Covid-19 Test Online</h1>
		<br>
		<br>

		<form action="/action">
			<div class="custom-control custom-checkbox mb-3">

				<label class="custom-control-label" for="customCheck">1-¿Tiene
					pérdida del gusto o de olfato?</label>
			</div>
			<br>
			<br> Si <input type="checkbox" class="custom-control-input"
				id="customCheck" name="example1"><br> No <input
				type="checkbox" class="custom-control-input" id="customCheck"
				name="example1">
			<div class="custom-control custom-checkbox mb-3">
				<br>
				<br> <label class="custom-control-label" for="customCheck">2-¿Es
					Personal de Salud y tiene fiebre o síntomas (tos, dolor de
					garganta, dificultad respiratoria, falta de olfato, falta de
					gusto)?</label> <input type="checkbox" class="custom-control-input"
					id="customCheck" name="example2"><br>
				<br> <label class="custom-control-label" for="customCheck">3-¿Es
					una persona de 60 años o más o brinda asistencia a personas mayores
					o es personal de Fuerzas de seguridad y Fuerzas Armadas o reside en
					una institución cerrada, y tiene fiebre o síntomas (tos, dolor de
					garganta, dificultad respiratoria, falta de olfato, falta de
					gusto)? </label> Si <input type="checkbox" class="custom-control-input"
					id="customCheck" name="example1"><br> No <input
					type="checkbox" class="custom-control-input" id="customCheck"
					name="example1">

			</div>
			<br>
			<br>

			<button type="submit" class="btn btn-primary">Siguiente</button>
	</div>
	<br>

	</form>
	</div>





	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>