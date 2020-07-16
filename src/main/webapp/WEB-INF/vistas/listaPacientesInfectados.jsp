<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/headerInstitucionesParte1.jsp" />

<title>Paso 1: Lista Pacientes Infectados</title>
    
<jsp:include page="../../partial/headerInstitucionesParte2.jsp" />

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
   
     
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <div>
        <h4 >Pacientes Infectados</h4> 
        </div>
       
      </div>
      	
    <div class="">
        <div>
        
		  <div class="table-responsive">
		  
		   
		           
		          
		          </br>

		            </td>
		        </tr>
		    </table>
		</div>
		
		<c:if test="${listaPacientesInfectados != null}">
	
		<h6 class="">PASO 1: Elegir el paciente a internar</h6>	
		
		</br>		
		
		  <div class="table-responsive">
		    <table class="table table-bordered table-hover responsive nowrap text-center">
		        <tr>
		            <th class="bg-light">NOMBRE</th>
		            <th class="bg-light">DNI</th>
		            <th class="bg-light">PRIORIDAD</th>
		            <th class="bg-light">ACCIÓN</th>
		        </tr>
		        <c:forEach items="${listaPacientesInfectados}" var="paciente">
		            <tr>
		                <td><c:out value="${paciente.getApellido()}, ${paciente.getNombre()}"/></td>
		                <td><c:out value="${paciente.getNumeroDocumento()} (${paciente.getTipoDocumento().name()})"/></td>
		                
               		  <style>
					  span {
					    display: inline-block;
					    width: 15px;
					    height: 15px;
					    margin-left: 6px;
					    background-color: #555;
					  }
					  </style>
		                
							<%-- <c:if test="${paciente.getInfectado() == true}">
								<td class="align-middle"><c:out value="Si" /></td>
							</c:if>
							<c:if test="${paciente.getInfectado() != true}">
								<td class="align-middle"><c:out value="Posible" /></td>
							</c:if> --%>

							<c:if test="${paciente.getPrioridad() == 5}">
					        	<td class="align-middle"><c:out value="Baja "/>
					        	 <span class="rounded-circle bg-success"></span>
					        	</td>
		        			</c:if>
		        			<c:if test="${paciente.getPrioridad() == 4}">
					        	<td class="align-middle"><c:out value="Baja"/>
					        	<span class="rounded-circle bg-success"></span>
					        	</td >
		        			</c:if>
		        			<c:if test="${paciente.getPrioridad() == 3}">
					        	<td class="align-middle"><c:out value="Media"/>
					        	<span class="rounded-circle bg-warning"></span>
					        	</td>
		        			</c:if>
		        			<c:if test="${paciente.getPrioridad() == 2}">
					        	<td class="align-middle"><c:out value="Alta "/>
					        	<span class="rounded-circle bg-danger"></span>
					        	</td>
		        			</c:if>
		        			<c:if test="${paciente.getPrioridad() == 1}">
					        	<td class="align-middle"><c:out value="Alta"/>
					        	<span class="rounded-circle bg-danger"></span>
					        	</td>
		        			</c:if>
		        			
		                <%-- <td class="align-middle">
		                
		                <a href="listaCamasDisponiblesTotal?idPaciente=${paciente.getId()}" type="button" class="btn btn-secondary">Internar</a>
		                 <div class="float-right" style="margin-right: 20px; margin-top: 5px; /* margin-left: -30px" */>
										
										<form action="crearMensaje" method=post>


											<input class="invisible" type="hidden" id="id" name="id"
												value="${paciente.getId()}"> <input
												class="btn btn-primary" type="submit" value="Enviar Mensaje">

										</form>
									</div>
						<!-- <button type="button" class="btn btn-danger">Borrar</button> -->
						
		               </td> --%>
		               
		               <td class="align-middle"><a
						href="listaCamas?idPaciente=${paciente.getId()}"
						class="btn btn-success" style="margin-top: 5px; margin-left: 5px">Internar</a> 
						<div class="float-right"
							style="margin-right: 25px; margin-top: 5px; margin-left: -30px">


							<form action="crearMensajeParaInstitucion" method=post>


								<input class="invisible" type="hidden" id="id" name="id"
									value="${instituciones.getId()}"> <input
									class="btn btn-primary" type="submit" value="Enviar Mensaje">

							</form>
						</div></td>
		            </tr>
		        </c:forEach>
		    </table>
		</div>


        </c:if>
        
        <c:if test="${listaPacientesInfectados == null}">
        <h5 class="">No hay pacientes Infectados</h5>	
         </c:if>
         
        </div>
    </div>

    
      
    </main>
    
    
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="../assets/dist/js/bootstrap.bundle.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
        <script src="js/dashboard.js"></script></body>
</html>
