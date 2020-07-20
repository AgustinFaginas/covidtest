<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/${armarHeader}1.jsp" />

<title>Inserte titulo aquí</title>
    
<jsp:include page="../../partial/${armarHeader}2.jsp" />

<% HttpSession sesion = request.getSession(); String rol = sesion.getAttribute("ROL").toString(); String admin = "ADMIN";%>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
   
     
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Detalle Internacion</h1>
       
      </div>
      	
     <div class="">
        <div>
			
               		<h6 >${mensaje}</h6>

                    <h6 >${mensaje2}</h6>

                    <h6>${mensaje3}</h6>

                    <h6 >${msg}</h6>
					
					<h6 class="">${mensaje5}</h6>
					
                    <br>
             
             <% if (rol.equals("ADMIN")) { %>		
			<a href="panel" class="btn btn-primary" role="button" aria-disabled="true">Inicio</a>
			<% } else{%>
			<a href="bienvenido" class="btn btn-primary" role="button" aria-disabled="true">Inicio</a>
			<% } %>
       
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