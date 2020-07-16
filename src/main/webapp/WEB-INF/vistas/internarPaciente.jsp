<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../../partial/headerInstitucionesParte1.jsp" />

<title>Internar Paciente Por Documento</title>
    
<jsp:include page="../../partial/headerInstitucionesParte2.jsp" />

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
   
           	
    <div class="container">
    
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h4 >Internar Paciente por Documento</h4>
       
      </div>
					
         <form action="detalleInternacion" method="GET" role="form" class="contactForm">
			                        
			               <div class="form-group">
                        
                    <label for="nombre" class="h6 my-3">Número de documento<span
                            class="text-primary font-weight-bold">*</span></label>
                 <input path="numeroDocumento" type="text" name="name" class="form-control br-radius-zero" id="numeroDocumento"
                                   placeholder="Ingrese número de documento" data-rule="minlen:1"
                                   data-msg="Ingrese número de documento valido"/>
                            <div class="validation"></div>
                </div>

                        
                       <div class="form-group">
                        
                    <label for="nombre" class="h6 my-3">Tipo de documento<span
                            class="text-primary font-weight-bold">*</span></label>
                    
		                     <select path="tipoDocumento" name="tipoDocumento" type="TipoDocumento"  class="form-control br-radius-zero" >
								<option path="tipoDocumento" id="tipoDocumento" type="TipoDocumento">DNI
								<option path="tipoDocumento" id="tipoDocumento" type="TipoDocumento">PASAPORTE
								<option path="tipoDocumento" id="tipoDocumento" type="TipoDocumento">LIBRETA CÍVICA
							</select>
                                   
                        <div class="validation"></div>
                        </div>
										
										<div class="form-group">
                        
                    <label for="nombre" class="h6 my-3">Seleccione una cama<span
                            class="text-primary font-weight-bold">*</span></label>
											<select name="cama" id="idCama" class="form-control br-radius-zero">
												<c:forEach var="cama" items="${camas}">
													<option value="${cama.getId()}">${cama.getDescripcion()}
												</c:forEach>
											</select>
						
										</div>
			                       
			                        <div class="validation"></div>
			                        
									<br>
			                        <div class="form-action">
			                            <button type="submit" class="btn btn-sm btn-outline-secondary">Internar</button>
			                        </div>
			                        
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
