
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/headerInstitucionesParte1.jsp" />

<title>Consultar Asignacion</title>
    
<jsp:include page="../../partial/headerInstitucionesParte2.jsp" />

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
        
            <div class="container m-5">
            
				<h2>Lista de Espera</h2>
				<br>
				
                <table class="table table-bordered table-hover responsive nowrap text-center">
                    <tr>
                        <th scope="col">Nombre</th>
                        <th scope="col">Documento</th>
                        <th scope="col">Edad</th>
                        <th scope="col">Infectado</th>
                        <th scope="col">Prioridad</th>
                        <th scope="col">Acciones</th>

                    </tr>
                    <c:forEach items="${posiblesInfectados}" var="paciente">
                        <tr>
                            <td><c:out value="${paciente.getApellido()}, ${paciente.getNombre()}"/></td>
                            <td><c:out value="${paciente.getNumeroDocumento()} (${paciente.getTipoDocumento().name()})"/></td>
                            <td><c:out value="${paciente.getEdad()}"/></td>
                            
                            <c:if test="${paciente.getInfectado() == true}">
								<td><c:out value="Si"/></td>
							</c:if>
							<c:if test="${paciente.getInfectado() != true}">
								<td><c:out value="Posible"/></td>
							</c:if>
							
							<td><c:out value=""/></td>
							
								<td class="align-middle"><button type="button"
									class="btn btn-secondary">Derivar a Institución</button> <a
								class="btn btn-warning"
								href="<c:url value='/crearMensaje/${paciente.getId()}'/>"
								role="button"> Enviar Mensaje</a>
								<button type="button" class="btn btn-danger">Borrar</button></td>
							
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </main>

    </div>
</div>

</main>

</div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
<script src="../assets/dist/js/bootstrap.bundle.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
<script src="js/dashboard.js"></script>
</body>
</html>
