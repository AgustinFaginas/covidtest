<%--
  Created by IntelliJ IDEA.
  User: juanp
  Date: 01/07/2020
  Time: 00:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Vista Camas</title>
</head>
<body>

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
