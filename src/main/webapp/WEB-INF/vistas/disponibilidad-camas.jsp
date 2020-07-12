<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/headerInstitucionesParte1.jsp" />

<title>Disponibilidad De Camas - Institucion</title>
    
<jsp:include page="../../partial/headerInstitucionesParte2.jsp" />

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
           
            <div class="container m-5">
            
                <h2 class="pb-2 mb-3 border-bottom">Disponibilidad De Camas</h2> 
                <br>
                <div>
        		
				<h6 class="">PASO 1: Elegir la cama en donde internar</h6>	
		
       			 </div>
       			 <br>
		 
		  <div class="table-responsive">
		    <table class="table table-bordered table-hover responsive nowrap text-center">
		        <tr>
		            <th class="bg-primary text-white">DESCRIPCION</th>
		            <th class="bg-primary text-white">TIPO</th>
		            <th class="bg-primary text-white">SELECCIONAR</th>
		        </tr>
		        
		        <c:forEach items="${camas}" var="cama">
		            <tr>
		                <td><c:out value="${cama.getDescripcion()}"/></td>
		                <td><c:out value="${cama.getTipoCama().name()}"/></td>
		                
		                <td class="align-middle">
		                
		                <a href="listaPacientesInfectadosPasoDos?idCama=${cama.getId()}" type="button" class="btn btn-secondary">Internar</a>
						
		               </td>
		            </tr>
		        </c:forEach>
		        
		    </table>
		</div>
        
            </div>

        </main>

    </div>
</div>

</main>

</div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
<script src="../assets/dist/js/bootstrap.bundle.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
<script src="js/dashboard.js"></script>
</body>
</html>
