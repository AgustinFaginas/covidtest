<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/${armarHeader}1.jsp" />

<title>Inserte Título Aquí</title>
    
<jsp:include page="../../partial/${armarHeader}2.jsp" />

<h2>ID: ${id}</h2>
<h2>Cantidad de camas de la institución: ${cantidadCamas}</h2>
<h2>Cantidad de camas disponibles: ${cantidadCamasDisponiblesPorInstitucion}</h2>

  <div class="table-responsive">
		    <table class="table table-striped table-sm">
		        <tr>
		            <th >#</th>
		            <th >Institucion</th>
		            <th >Descripcion</th>
		            <th></th>
		        </tr>
		        <c:forEach items="${camas}" var="cama">
		            <tr>
		                <th ><c:out value="${cama.getId()}"/></th>
		                <td><c:out value="${cama.getInstitucion().getNombre()}"/></td>
		                <td><c:out value="${cama.getDescripcion()}"/></td>
		                <td>
		                    <div class="form-check">
		                        <input class="form-check-input" type="radio" name="idCama" id="radio-cama"
		                               value="${cama.getId()}">
		                    </div>
		                </td>
		            </tr>
		        </c:forEach>
		    </table>
		</div>


</body>
</html>
