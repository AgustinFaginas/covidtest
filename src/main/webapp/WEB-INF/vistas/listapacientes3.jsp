<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/${armarHeader}1.jsp" />

<title>Inserte titulo aquí</title>
    
<jsp:include page="../../partial/${armarHeader}2.jsp" />

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
