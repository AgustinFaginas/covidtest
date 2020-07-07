<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/headerInstitucionesParte1.jsp" />

<title>Registrar Institucion</title>
    
<jsp:include page="../../partial/headerInstitucionesParte2.jsp" />

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
   
     
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h4>Registrar Institución</h4>
       
      </div>
      	
    <div class="">
        <div>
					
         <form action="detalleRegistroInstitucion" method="POST" modelAttribute="institcuion" role="form" class="contactForm">
			                    
			              <div class="form-group">
			                        
			                  <h6>Nombre de la Institución</h6>
			                        
			                  <input type="text" name="nombre" class="form-control br-radius-zero" id="nombre"
			                                   placeholder="Ingrese el nombre de la institución" data-rule="minlen:3"
			                                   data-msg="Ingrese un nombre válido"/>
			                  <div class="validation"></div>
			              </div>
			              
			              <div class="form-group">
			                        
			                  <h6>Número de CUIT</h6>
			                        
			                  <input type="text" name="numeroDocumento" class="form-control br-radius-zero" id="numeroDocumento"
			                                   placeholder="Ingrese número de CUIT" data-rule="minlen:1"
			                                   data-msg="Ingrese número de CUIT valido"/>
			                  <div class="validation"></div>
			              </div>
					                             			            
					        <div class="form-group">
			                    <h6>Cantidad de camas</h6>
			                    <input type="number" class="form-control input-sm" id="cantidadCamas" name="cantidadCamas" min="1" max="2000" 
			                    placeholder="Ingrese la cantidad de camas de la institución">		                  
		               		</div>      
               		
			              <div class="form-group">
			                        
			                  <h6>Email</h6>
			                        
			                  <input type="text" name="email" class="form-control br-radius-zero" id="email"
			                                   placeholder="Ingrese un mail" data-rule="mail"
			                                   data-msg="Ingrese un mail valido"/>
			                  <div class="validation"></div>
			              </div>
			              
			              <div class="form-group">
			                        
			                  <h6>Contraseña de la cuenta</h6>
			                        
			                  <input type="text" name="password" class="form-control br-radius-zero" id="password"
			                                   placeholder="Ingrese una contraseña" data-rule="minlen:1"
			                                   data-msg="Ingrese una contraseña valida"/>
			                  <div class="validation"></div>
			              </div>      
			                        
									<br>
			                        <div class="form-action">
			                            <button type="submit" class="btn btn-sm btn-outline-secondary">Registrar institución</button>
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