<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>

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

<title>Mensaje</title>

<style>
#navbar-top:hover {
	text-decoration: none;
}
</style>

</head>

<body>


	</nav>
	<div class="container">

		<br>
		<br>
		<br>
		<h1>Redactar Mensaje</h1>

		<form:form action="enviarMensaje" method="POST">

			<div class="form-group">

				<h1>Destinatario ${p.getEmail()}</h1>
			</div>

			<div class="form-group">
				<label for="exampleFormControlTextarea1">Mensaje: </label>
				<textarea class="form-control" id="mensaje" name="mensaje" rows="3"></textarea>
			</div>
			<input type="hidden" value="${p.getId()}" name="idReceptor">
			<input type="hidden" value="${id}" name="idEmisor">
			
			<h1>"${p.getId()}"</h1>
			<h1>"${id}"</h1>

			<button class="btn btn-primary" type="submit">Enviar</button>
		</form:form>


		<br>
		<a href="/covidtest/panel">Atrás</a>
	</div>

	<%-- <form action="contact" method="post">
    <p>Your email address: <input name="email"></p>
    <p>Mail subject: <input name="subject"></p>
    <p>Mail message: <textarea name="message"></textarea></p>
    <p><input type="submit"><span class="message">${message}</span></p> --%>
	</form>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>