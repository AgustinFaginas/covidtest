<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

	<c:if test="${alert != null}">
		<section class="breadcrumb breadcrumb_bg">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="breadcrumb_iner text-center">
							<div class="breadcrumb_iner_item">
								<div class="container" style="max-width: 600px">
									<h3 class="alert-login">${alert}</h3>
									<h3 onClick="logout()">Cerrar sesi�n</h3>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</c:if>
	<c:if test="${alert != null}">
		<a class="btn_1 d-none d-lg-block" href="logout">Salir</a>
	</c:if>
	<c:if test="${alert == null}">
		<div class="container">
			<div id="loginbox" style="margin-top: 50px;"
				class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
				<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
				<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>

				<form:form action="validar-login" method="POST"
					modelAttribute="usuario">
					<h3 class="form-signin-heading">Taller Web I</h3>
					<hr class="colorgraph">
					<br>

					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
					<form:input path="email" id="email" type="email"
						class="form-control" />
					<form:input path="password" type="password" id="password"
						class="form-control" />

					<button class="btn btn-lg btn-primary btn-block" Type="Submit" />Login</button>
				</form:form>

				<%--Bloque que es visible si el elemento error no está vacío	--%>
				<c:if test="${not empty error}">
					<h4>
						<span>${error}</span>
					</h4>
					<br>
				</c:if>
			</div>
		</div>
	</c:if>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
