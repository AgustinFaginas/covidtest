
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<jsp:include page="../../partial/headerInstitucionesParte1.jsp" />

<title>Egresar Paciente - Motivo</title>
    
<jsp:include page="../../partial/headerInstitucionesParte2.jsp" />


    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
   
     
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Egresar Paciente</h1>
       
      </div>
      	
     <div class="">
     
     <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Elegir motivo del egreso</h1>
       
      </div>
      	
        <div>
			
                  	<h6>Nombre del Paciente: ${apellido}, ${nombre}</h6> 
					
					<h6 class="">Documento: ${numeroDocumento} (${tipoDocumento})</h6>
					
					<h6 class="">Hora de internación: ${horaIngreso}</h6>
					
					<h6 class="">Cama asignada: ${cama}</h6>
					
					
                    <br>
                    
                    <a href="egresoPacienteMotivo?numeroDocumento=${numeroDocumento}&tipoDocumento=${tipoDocumento}" 
                    class="btn btn-sm btn-outline-secondary">Egresar</a>
					
					<a href="trasladarPacienteCama" class="btn btn-sm btn-outline-secondary">Trasladar</a>
					<br><br>
					
					 <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
				       
				       <a href="consultarPaciente" class="btn btn-sm btn-outline-secondary">Volver</a>
                    <br>
                    <a href="bienvenido" class="btn btn-sm btn-outline-secondary">Inicio</a>
					
				      </div>
      	
					
       
        </div>
            
                        
                        <div class="form-group">
                        
                        <c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
			         </div>
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