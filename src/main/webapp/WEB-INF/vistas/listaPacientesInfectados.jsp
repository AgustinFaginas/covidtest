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
		        
		<form action="listaCamas" method="get">
		
		  <div class="table-responsive">
		    <table class="table table-striped table-sm">
		        <tr>
		            <th >Id</th>
		            <th >Nombre</th>
		            <th >Apellido</th>
		            <th></th>
		        </tr>
		        <c:forEach items="${listaPacientesInfectados}" var="paciente">
		            <tr>
		                <th ><c:out value="${paciente.getId()}"/></th>
		                <td><c:out value="${paciente.getNombre()}"/></td>
		                <td><c:out value="${paciente.getApellido()}"/></td>
		                <td>
		                    <div class="form-check">
		                        <input class="form-check-input" type="radio" name="idPaciente" id="radio-cama"
		                               value="${paciente.getId()}">
		                    </div> 
		               </td>
		            </tr>
		        </c:forEach>
		    </table>
		</div>
		
		    <button class="btn btn-sm btn-outline-secondary" type="submit">Siguiente</button>
		
		
		</form>

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
