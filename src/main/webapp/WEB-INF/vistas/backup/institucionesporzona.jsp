<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/${armarHeader}1.jsp" />

<title>Inserte titulo aquí</title>
    
<jsp:include page="../../partial/${armarHeader}2.jsp" />

<table class="table table-bordered table-dark">
    <tr>
        <th scope="col">ID</th>



    </tr>
    <c:forEach items="${instituciones}" var="institucion">
        <tr>
            <th scope="row"><c:out value="${institucion.getId()}"/></th>
<%--            <td><c:out value="${institucion.get}"/></td>--%>
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
</body>
</html>
