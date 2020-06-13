<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title> Pacientes</title>
</head>
<body>

<%-- <c:forEach items="${pacientes}" var="paciente">
    <c:out value="${paciente.getNombre()}"/>
    <c:out value="${paciente.getApellido()}"/>
</c:forEach> --%>


<table class="table table-bordered table-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Nombre</th>
        <th scope="col">Apellido</th>
        <th scope="col">Infectado</th>
        
    </tr>
    <c:forEach items="${pacientes}" var="paciente">
        <tr>
            <th scope="row"><c:out value="${paciente.getId()}"/></th>
            <td><c:out value="${paciente.getNombre()}"/></td>
            <td><c:out value="${paciente.getApellido()}"/></td>
            <td><c:out value="${paciente.getInfectado() ? 'Yes' : 'No'}"/></td>
            <td><c:out value="Ver Ficha Médica"/></td>
            <td><c:out value="Asignación de Cama"/></td>
        </tr>
    </c:forEach>
</table>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
