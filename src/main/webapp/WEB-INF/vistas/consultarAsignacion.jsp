<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/${armarHeader}1.jsp" />

<title>Inserte titulo aquí</title>
    
<jsp:include page="../../partial/${armarHeader}2.jsp" />

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
   
     
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h4>Consultar Asignacion</h4>
       
      </div>
      	
    <div class="">
        <div>
					
         <form action="detalleAsignacion" method="GET" role="form" class="contactForm">
			                        
			              <div class="form-group">
			                        
			                  <h6>Número de documento</h6>
			                        
			                  <input type="text" name="numeroDocumento" class="form-control br-radius-zero" id="numeroDocumento"
			                                   placeholder="Ingrese número de documento" data-rule="minlen:1"
			                                   data-msg="Ingrese número de documento valido"/>
			                  <div class="validation"></div>
			              </div>
			                        
			                        <div class="form-group">
			                        <h6>Tipo de documento</h6>
			                    
					                    <select name="tipoDocumento" type="TipoDocumento" class="form-control br-radius-zero" >
											<option type="TipoDocumento">DNI
											<option type="TipoDocumento">PASAPORTE
											<option type="TipoDocumento">LIBRETA CÍVICA
										</select>
			                                   
			                        <div class="validation"></div>
			                        </div>
									<br>
			                        <div class="form-action">
			                            <button type="submit" class="btn btn-sm btn-outline-secondary">Consultar Asignacion</button>
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