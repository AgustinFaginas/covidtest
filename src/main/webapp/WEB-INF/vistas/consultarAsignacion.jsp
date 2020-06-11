<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
	
	
	
	
		<div class = "container">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				
				<form:form action="detalleAsignacion" method="POST" modelAttribute="paciente">
			    	<h3 class="form-signin-heading">CONSULTAR ASIGNACION</h3>
					<hr class="colorgraph"><br>
					
					<h4>Número de documento</h4>
					<form:input path="numeroDocumento" id="numeroDocumento" type="numeroDocumento" class="form-control" />  
					<h4>Tipo de documento</h4>
				<form:select path="tipoDocumento" id="tipoDocumento" type="TipoDocumento" class="form-control">
						<option path="tipoDocumento" id="tipoDocumento" type="TipoDocumento" class="form-control" >DNI
						<option path="tipoDocumento" id="tipoDocumento" type="TipoDocumento" class="form-control">PASAPORTE
						<option path="tipoDocumento" id="tipoDocumento" type="TipoDocumento" class="form-control">LIBRETA CÍVICA
					</form:select>
					
					<button class="btn btn-lg btn-primary btn-block" Type="Submit">Consultar Asignacion</button>
					
				</form:form>

				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
			</div>
		</div>
		
		
		
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>