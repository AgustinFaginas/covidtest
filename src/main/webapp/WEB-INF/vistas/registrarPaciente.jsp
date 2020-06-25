<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <title>Registrar Paciente</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/dashboard/">

    <!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
  </head>
  <body>
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">COVIDTEST</a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
<!--   <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search"> -->
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="#">Sign out</a>
    </li>
  </ul>
</nav>

<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="sidebar-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" href="#">
              <span data-feather="home"></span>
              Principal <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file"></span>
              Disponibilidad Camas
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="shopping-cart"></span>
              Consultar Otros Centros de Atenci�n
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="pacientes">
              <span data-feather="users"></span>
              Lista de Espera
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="bar-chart-2"></span>
              Reportes
            </a>
          </li>
          
        </ul>

        <!-- <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          <span>Saved reports</span>
          <a class="d-flex align-items-center text-muted" href="#" aria-label="Add a new report">
            <span data-feather="plus-circle"></span>
          </a>
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Current month
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Last quarter
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Social engagement
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Year-end sale
            </a>
          </li>
        </ul> -->
        
      </div>
    </nav>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
   
     
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Registrar Paciente</h1>
       
      </div>
      	
    <div class="container">
        <div>
					
         <form action="detalleRegistroPaciente" method="POST" modelAttribute="paciente" role="form" class="contactForm">
			                    
			              <div class="form-group">
			                        
			                  <h4>Nombre</h4>
			                        
			                  <input type="text" name="nombre" class="form-control br-radius-zero" id="nombre"
			                                   placeholder="Ingrese el nombre de la instituci�n" data-rule="minlen:3"
			                                   data-msg="Ingrese un nombre v�lido" required/>
			                  <div class="validation"></div>
			              </div>
			              
			              <div class="form-group">
			                        
			                  <h4>N�mero de Documento</h4>
			                        
			                  <input type="text" name="numeroDocumento" class="form-control br-radius-zero" id="numeroDocumento"
			                                   placeholder="Ingrese n�mero de documento" data-rule="minlen:1"
			                                   data-msg="Ingrese n�mero de CUIT valido" required/>
			                  <div class="validation"></div>
			              </div>
			              
			              <div class="form-group">
                          <h4>Tipo de documento</h4>
                    
		                     <select name="tipoDocumento" id="tipoDocumento"class="form-control br-radius-zero" required>
								<option id="tipoDocumento" >DNI
								<option id="tipoDocumento" >PASAPORTE
								<option id="tipoDocumento" >LIBRETA C�VICA
							</select>
							
                        </div>

			              <div class="form-group">
			                        
			                  <h4>Email</h4>
			                        
			                  <input type="text" name="email" class="form-control br-radius-zero" id="email"
			                                   placeholder="Ingrese un mail" data-rule="mail"
			                                   data-msg="Ingrese un mail valido" required/>
			                  <div class="validation"></div>
			              </div>
			              
			              <div class="form-group">
			                        
			                  <h4>Contrase�a de la cuenta</h4>
			                        
			                  <input type="text" name="password" class="form-control br-radius-zero" id="password"
			                                   placeholder="Ingrese una contrase�a" data-rule="minlen:1"
			                                   data-msg="Ingrese una contrase�a valida" required/>
			                  <div class="validation"></div>
			              </div>      
			                        
									<br>
			                        <div class="form-action">
			                            <button type="submit" class="btn btn-sm btn-outline-secondary">Registrar instituci�n</button>
			                        </div>
			                        <br>
			                        <div class="form-group">
			                        <c:if test="${not empty error}">
						        <h4><span>${error}</span></h4>
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