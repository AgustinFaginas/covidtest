<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>