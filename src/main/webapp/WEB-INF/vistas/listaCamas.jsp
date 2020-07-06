<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/headerInstitucionesParte1.jsp" />

<title>Paso 2: Lista Camas Disponibles</title>
    
<jsp:include page="../../partial/headerInstitucionesParte2.jsp" />

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
   
     
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <div>
        <h4>Pacientes Infectados</h4> 
        </div>
   
       
      </div>
      	
    <div class="">
        <div>

		 <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <div>
        		<h6 class="">PASO 2: Elegir la cama</h6>
        </div>
        
        <div>
        <p class="px-md-5"> ${pacienteAInternar.getApellido()}, ${pacienteAInternar.getNombre()}</p>
        </div>
       
      </div>
	
		        
		<form action="detalleInternacionPorPasos" method="get">
		
		  <div class="table-responsive">
		    <table class="table table-striped table-sm">
		        <tr>
		            <th >Id</th>
		            <th >Descripcion</th>
		            <th>Seleccionar Cama</th>
		        </tr>
		        <c:forEach items="${camas}" var="cama">
		            <tr>
		                <th ><c:out value="${cama.getId()}"/></th>
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
		
		    <button class="btn btn-sm btn-outline-secondary" type="submit">Internar</button>
		
		
		</form>

        
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
