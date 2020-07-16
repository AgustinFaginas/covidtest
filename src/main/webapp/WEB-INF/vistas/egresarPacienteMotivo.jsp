
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
      	
     <div >
           	<h6>Nombre del Paciente: ${paciente.getApellido()}, ${paciente.getNombre()}</h6> 
			
			<h6 class="">Documento: ${paciente.getNumeroDocumento()} (${paciente.getTipoDocumento().name()})</h6>
			
			<h6 class="">Hora de internación: ${horaIngreso}</h6>
			
			<h6 class="">Cama asignada: ${asignacion.getCama().getDescripcion()}</h6>
     
     <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h4>Elegir motivo del egreso</h4>
       
      </div>
      	
        <div>
                    
                    <form action="detalleEgreso" method="get">
                   	
	                   	<div class="form-group">
	                       
	                        <h6>Motivo de Egreso</h6>
							 <select name="motivoEgreso" type="MotivoEgreso" class="form-control br-radius-zero" >
								<option type="MotivoEgreso">CURADO
								<option type="MotivoEgreso">FALLECIDO
							</select>      
	                    </div>  
	                    
	                    <input type="hidden" value="${paciente.getId()}" name="idPaciente">
	
						<button type="submit" class="btn btn-sm btn-outline-secondary">Egresar</button>
					
					</form>
					
					 <div>
				       
				       <a href="consultarPaciente" class="btn btn-sm btn-outline-secondary">Volver</a>
                  
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