<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Traslado Interno</title>
<meta name="description"
	content="Free Bootstrap Theme by BootstrapMade.com">
<meta name="keywords"
	content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">

<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Open+Sans|Raleway|Candal">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>


	<div class="container">
		<div class="col-md-12">


			<form action="trasladoValido" method="GET" role="form"
				class="contactForm">

				<div class="form-group">

					<h4>Número de documento</h4>

					<input type="text" name="numeroDocumento"
						class="form-control br-radius-zero" id="numeroDocumento"
						placeholder="Ingrese número de documento" data-rule="minlen:1"
						data-msg="Ingrese número de documento valido" />
					<div class="validation"></div>
				</div>

				<div class="form-group">
					<h4>Tipo de documento</h4>

					<select name="tipoDocumento" type="TipoDocumento"
						class="form-control br-radius-zero">
						<option type="TipoDocumento">DNI
						<option type="TipoDocumento">PASAPORTE
						<option type="TipoDocumento">LIBRETA CÍVICA
					</select>
				</div>

				<div class="form-group">
					<h4>Motivo de Traslado</h4>
					<select name="motivoTraslado" type="MotivoTraslado"
						class="form-control br-radius-zero">
						<option type="MotivoTraslado">CURADO
						<option type="MotivoTraslado">FALLECIDO
						<option type="MotivoTraslado">OTRO
					</select>
				</div>


				<div class="form-group">
					<h4>Seleccione cama</h4>
					<select name="selectCama" id="selectCamas">
						<c:forEach var="cama" items="${camas}">
							<option value="${cama.getId()}">"${cama.id}"
						</c:forEach>
					</select>

				</div>



				<div class="validation"></div>

				<br>
				<div class="form-action">
					<button type="submit" class="btn btn-form">Trasladar</button>
				</div>
				<br>

				<div class="form-group">
					<c:if test="${not empty error}">
						<h4>
							<span>${error}</span>
						</h4>
						<br>
					</c:if>
				</div>

			</form>
		</div>
	</div>
</body>
</html>