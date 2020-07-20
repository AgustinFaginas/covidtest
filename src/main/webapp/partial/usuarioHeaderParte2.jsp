<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

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
				<li class="nav-item ml-5 active">
						<a class="nav-link" href=
						
						<c:if test='${rol == "ADMIN"}'>
						"admin"
						</c:if>
						<c:if test='${rol == "INSTITUCION"}'>
						"bienvenido"
						</c:if>
						<c:if test='${rol == "PACIENTE"}'>
						"bienvenidoPaciente"
						</c:if>
						
						>Home
						<span class="sr-only">(current)</span>
				</a> 
				<li class="nav-item ml-5"><a class="nav-link" href="autoTest">Realizar
						test</a></li>
						<li class="nav-item ml-5"><a class="nav-link" href="generarPermiso">Generar Permiso
						</a></li>
				</li>
			</ul>
			
				<c:if test="${rol == null}">
				<a href="login" class="btn btn-dark ml-5" role="button"
					aria-disabled="true">Iniciar Sesión</a>
				</c:if>	
				<c:if test="${rol != null}">				
				<a href="logout" class="btn btn-dark ml-5" role="button"
					aria-disabled="true">Salir</a>
				</c:if>
			
		</div>
	</nav>