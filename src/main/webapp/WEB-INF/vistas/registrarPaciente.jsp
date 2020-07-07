<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/headerInstitucionesParte1.jsp" />

<title>Registrar Paciente</title>
    
<jsp:include page="../../partial/headerInstitucionesParte2.jsp" />

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
   
     
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h4>Registrar Paciente</h4>
       
      </div>
      	
    <div class="">
        <div>
					
         <form action="detalleRegistroPaciente" method="POST" modelAttribute="paciente" role="form" class="contactForm">
			                    
			              <div class="form-group">
			                        
			                  <h6>Nombre</h6>
			                        
			                  <input type="text" name="nombre" class="form-control br-radius-zero" id="nombre"
			                                   placeholder="Ingrese el nombre del paciente" data-rule="minlen:3"
			                                   data-msg="Ingrese un nombre válido" required/>
			                  <div class="validation"></div>
			              </div>
			              
			              <div class="form-group">
			                        
			                  <h6>Número de Documento</h6>
			                        
			                  <input type="text" name="numeroDocumento" class="form-control br-radius-zero" id="numeroDocumento"
			                                   placeholder="Ingrese número de documento" data-rule="minlen:1"
			                                   data-msg="Ingrese número de CUIT valido" required/>
			                  <div class="validation"></div>
			              </div>
			              
			              <div class="form-group">
                          <h6>Tipo de documento</h6>
                    
		                     <select name="tipoDocumento" id="tipoDocumento"class="form-control br-radius-zero" required>
								<option id="tipoDocumento" >DNI
								<option id="tipoDocumento" >PASAPORTE
								<option id="tipoDocumento" >LIBRETA CÍVICA
							</select>
							
                        </div>

			              <div class="form-group">
			                        
			                  <h6>Email</h6>
			                        
			                  <input type="text" name="email" class="form-control br-radius-zero" id="email"
			                                   placeholder="Ingrese un mail" data-rule="mail"
			                                   data-msg="Ingrese un mail valido" required/>
			                  <div class="validation"></div>
			              </div>
			              
			              <div class="form-group">
			                        
			                  <h6>Contraseña de la cuenta</h6>
			                        
			                  <input type="text" name="password" class="form-control br-radius-zero" id="password"
			                                   placeholder="Ingrese una contraseña" data-rule="minlen:1"
			                                   data-msg="Ingrese una contraseña valida" required/>
			                  <div class="validation"></div>
			              </div>      
			                        
									<br>
			                        <div class="form-action">
			                            <button type="submit" class="btn btn-sm btn-outline-secondary">Registrar paciente</button>
			                        </div>
			                        <br>
			                        <div class="form-group">
			                        <c:if test="${not empty error}">
						        <h6><span>${error}</span></h6>
						        <br>
						         </div>
					        </c:if>	
			                       
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