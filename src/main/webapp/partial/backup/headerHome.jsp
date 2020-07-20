<% HttpSession sesionActual = request.getSession();%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html lang="es">

<head>
<!-- Required meta tags -->

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
	
        <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

<title>Bienvenido</title>

<style>
#navbar-top:hover {
	text-decoration: none;
}
</style>

</head>

<body>

	<nav
		class="navbar sticky-top bg-dark text-white justify-content-center align-items-center">
		<a class="text-center text-white" href="#" id="navbar-top">
			<h5>
				Coronavirus COVID-19 conocé información y recomendaciones del
				Ministerio de Salud</strong>
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
				<li class="nav-item ml-5 active"><a class="nav-link" href="home">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item ml-5"><a class="nav-link" href="autoTest">Realizar
						test</a></li>
						<li class="nav-item ml-5"><a class="nav-link" href="generarPermiso">Generar Permiso
						</a></li>
			</ul>
			<% if (sesionActual == null) { %>	
				<a href="login" class="btn btn-dark ml-5" role="button"
					aria-disabled="true">Iniciar Sesión</a>
			<% } else{%>
			<a href="login" class="btn btn-dark ml-5" role="button"
					aria-disabled="true">Iniciar Sesión</a>			
			<% } %>

		</div>
	</nav>