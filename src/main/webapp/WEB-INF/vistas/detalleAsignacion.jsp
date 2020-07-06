<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/headerInstitucionesParte1.jsp" />

<title>Detalle Asignacion</title>
    
<jsp:include page="../../partial/headerInstitucionesParte2.jsp" />


<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
	
	
	<div
		class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	
		<h4>Detalle Paciente</h4>
	
	</div>
	
	<div class="">
	
		<h6>Nombre del Paciente: ${apellido}, ${nombre}</h6>
	
		<h6 class="">Documento: ${numeroDocumento} (${tipoDocumento})</h6>
	
		<h6 class="">Hora de internación: ${horaIngreso}</h6>
	
		<h6 class="">Cama asignada: ${cama}</h6>
	
		<br>
	
		<div class="pt-3 pb-2 mb-3">
	
			<a
				href="egresoPacienteMotivo?numeroDocumento=${numeroDocumento}&tipoDocumento=${tipoDocumento}"
				class="btn btn-sm btn-outline-secondary">Egresar</a> <a
				href="trasladarPacienteCama" class="btn btn-sm btn-outline-secondary">Trasladar</a>
	
	
		</div>
	
	
		<div
			class="col-md-9 d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-top">
	
			<a href="consultarPaciente" class="btn btn-sm btn-outline-secondary">Volver</a>
	
			<a href="bienvenido" class="btn btn-sm btn-outline-secondary">Inicio</a>
	
		</div>
	
	</div>
	<div class="form-group">
	
		<c:if test="${not empty error}">
			<h4>
				<span>${error}</span>
			</h4>
			<br>
		</c:if>
	</div>
	</div>

</main>

<jsp:include page="../../partial/footer.jsp" />
