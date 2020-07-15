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
    <style>
        #myInput {
            background-image: url('/css/searchicon.png'); /* Add a search icon to input */
            background-position: 10px 12px; /* Position the search icon */
            background-repeat: no-repeat; /* Do not repeat the icon image */
            width: 100%; /* Full-width */
            font-size: 16px; /* Increase font-size */
            padding: 12px 20px 12px 40px; /* Add some padding */
            border: 1px solid #ddd; /* Add a grey border */
            margin-bottom: 12px; /* Add some space below the input */
        }

        #myTable {
            border-collapse: collapse; /* Collapse borders */
            width: 100%; /* Full-width */
            border: 1px solid #ddd; /* Add a grey border */
            font-size: 18px; /* Increase font-size */
        }

        #myTable th, #myTable td {
            text-align: left; /* Left-align text */
            padding: 12px; /* Add padding */
        }

        #myTable tr {
            /* Add a bottom border to all table rows */
            border-bottom: 1px solid #ddd;
        }

        #myTable tr.header, #myTable tr:hover {
            /* Add a grey background color to the table header and on hover */
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
<%-- <c:forEach items="${pacientes}" var="paciente">
    <c:out value="${paciente.getNombre()}"/>
    <c:out value="${paciente.getApellido()}"/>
</c:forEach> --%>

<%--<form action="camas" method="get">--%>

<%--  <table class="table table-bordered table-dark">
     <tr>
         <th scope="col">#</th>
         <th scope="col">Nombre</th>
         <th scope="col">Apellido</th>
         <th scope="col">Internar</th>
     </tr>
     <c:forEach items="${pacientes}" var="paciente">
         <tr>
             <th scope="row"><c:out value="${paciente.getId()}"/></th>
             <td><c:out value="${paciente.getNombre()}"/></td>
             <td><c:out value="${paciente.getApellido()}"/></td>
             <td>
                 <div class="form-check">
                     <input class="form-check-input" type="radio" name="idPaciente" id="radio-paciente"
                            value="${paciente.getId()}"
                     >
                 </div>
             </td>
         </tr>
     </c:forEach>
 </table> --%>
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names..">
<table class="table table-bordered table-dark" id="myTable">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Nombre</th>
        <th scope="col">Apellido</th>
        <th scope="col">Infectado</th>


    </tr>
    <c:forEach items="${listaPacientes}" var="paciente">
        <tr>
            <th scope="row"><c:out value="${paciente.getId()}"/></th>
            <td><c:out value="${paciente.getNombre()}"/></td>
            <td><c:out value="${paciente.getApellido()}"/></td>
            <td><c:out value="${paciente.getInfectado() ? 'Infectado' : 'No infectado'}"/></td>
                <%--<td><a href="<c:url value='/Camas/${paciente.getId()}' />" >Asignar cama</a></td>

                <td>
                         <div class="form-check">
                             <input class="form-check-input" type="radio" name="idPaciente" id="radio-paciente"
                                    value="${paciente.getId()}"
                             >
                         </div>
                     </td>--%>
        </tr>
    </c:forEach>
</table>

<%--    <button class="btn btn-dark" type="submit">Guardar</button>--%>

<%--</form>--%>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script>
    function myFunction() {
        // Declare variables
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");

        // Loop through all table rows, and hide those who don't match the search query
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>
</body>
</html>
