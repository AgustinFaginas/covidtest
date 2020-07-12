<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/headerInstitucionesParte1.jsp" />

<title>Paso 1: Lista Pacientes Infectados</title>
    
<jsp:include page="../../partial/headerInstitucionesParte2.jsp" />

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">

         <div class="container m-5">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <div>
        <h2>Pacientes Infectados</h2> 
        </div>
       
      </div>
      	

        <div>
		
		<c:if test="${not empty listaPacientesInfectados}">
	
	
		 <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3">
        <div>
        		
		<h6 class="">PASO 2: Elegir el paciente a internar</h6>	
		
        </div>
        
        <div>
        <h5 class="">CAMA: ${cama.getDescripcion()}, ${cama.getTipoCama().name()}</h5>
        </div>
       
      </div>
		
		  <div class="table-responsive">
		    <table class="table table-bordered table-hover responsive nowrap text-center">
		        <tr>
		            <th class="bg-primary text-white">NOMBRE</th>
		            <th class="bg-primary text-white">APELLIDO</th>
		            <th class="bg-primary text-white">DNI</th>
		            <th class="bg-primary text-white">PRIORIDAD</th>
		            <th class="bg-primary text-white">ACCIÓN</th>
		        </tr>
		        <c:forEach items="${listaPacientesInfectados}" var="paciente">
		            <tr>
		                <td><c:out value="${paciente.getNombre()}"/></td>
		                <td><c:out value="${paciente.getApellido()}"/></td>
		                <td><c:out value="${paciente.getNumeroDocumento()} (${paciente.getTipoDocumento().name()})"/></td>
		                <td><c:out value="${paciente.getPrioridad()}"/></td>
		                
		                <td class="align-middle">
		               
		                <a href="detalleInternacionPorPasos2?idCama=${cama.getId()}&idPaciente=${paciente.getId()}" type="button" class="btn btn-secondary">Internar</a>
						
		               </td>
		            </tr>
		        </c:forEach>
		    </table>
		</div>


        </c:if>
        
        <c:if test="${empty listaPacientesInfectados}">
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
