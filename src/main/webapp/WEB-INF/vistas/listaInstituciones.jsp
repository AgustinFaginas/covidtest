<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/headerInstitucionesParte1.jsp" />

<title>Consultar Asignacion</title>
    
<jsp:include page="../../partial/headerInstitucionesParte2.jsp" />

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
        
            <div class="container m-5">
            
				<h2>Lista de Espera</h2>
				<br>
				<br><a href="panel">Volver a panel</a><br>
				
                <table class="table table-bordered table-hover responsive nowrap text-center align-middle">
                    <tr class="text-center align-middle">
                        <th scope="col">Nombre</th>
                        <th scope="col">Cuit</th>
               
                        <th scope="col">Camas Totales</th>
                        <th scope="col">Acciones</th>

                    </tr>
                    <c:forEach items="${listaInstituciones}" var="instituciones">
                    
                        <tr>
                            <td class="align-middle"><c:out value="${instituciones.getNombre()}"/></td>
                            
                             <td class="align-middle"><c:out value="${instituciones.getNumeroDocumento()}"/></td>    
                             <td class="align-middle"><c:out value="${instituciones.getCantidadCamas()}"/></td>
							<td class="align-middle"><button type="button"
										class="btn btn-success" style="margin-top: 5px; margin-left: 5px ">Ver Pacientes</button> <%-- <a
									class="btn btn-warning"
									href="<c:url value='/crearMensaje/${paciente.getId()}'/>"
									role="button"> Enviar Mensaje</a> --%>

									<div class="float-right" style="margin-right: 25px; margin-top: 5px; margin-left: -30px">
										
										
										<form action="crearMensajeParaInstitucion" method=post>


											<input class="invisible" type="hidden" id="id" name="id"
												value="${instituciones.getId()}"> <input
												class="btn btn-primary" type="submit" value="Enviar Mensaje">

										</form>
									</div></td>
								
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
