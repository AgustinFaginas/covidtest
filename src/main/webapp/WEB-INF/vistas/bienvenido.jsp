<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/${armarHeader}1.jsp" />

<title>Inserte titulo aquí</title>
    
<jsp:include page="../../partial/${armarHeader}2.jsp" />

<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block sidebar collapse">
            <div class="sidebar-sticky pt-3">
                <ul class="nav flex-column">
                    <li class="nav-item mt-3 mb-3">
                        <a class="nav-link" href="bienvenido">
                            <span data-feather="home"></span>
                            Home Institución
                        </a>
                    </li>
                    <li class="nav-item mt-3 mb-3">
                        <a class="nav-link" href="disponibilidadCamas">
                            <span data-feather="inbox"></span>
                            Disponibilidad Camas
                        </a>
                    </li>     
                     <li class="nav-item mt-3 mb-3">
                        <a class="nav-link" href="listaPacientesInternados">
                            <span data-feather="users"></span>
                            Pacientes Internados
                        </a>
                    </li>
                   
                   <!--  <li class="nav-item mt-3 mb-3">
                        <a class="nav-link" href="posiblesinfectados">
                            <span data-feather="users"></span>
                            Posibles Infectados
                        </a> -->
                        
                    </li>
                    <li class="nav-item mt-3 mb-3">
                        <a class="nav-link" href="consultarPaciente">
                            <span data-feather="search"></span>
                            Consultar paciente
                        </a>
                    </li>
                    <li class="nav-item mt-3 mb-3">
                        <a class="nav-link" href="internarPaciente">
                            <span data-feather="user-plus"></span>
                            Internar paciente
                        </a>
                    </li>
                    <li class="nav-item mt-3 mb-3">
                        <a class="nav-link" href="egresarPaciente">
                            <span data-feather="user-minus"></span>
                            Egresar paciente
                        </a>
                    </li>
                    <li class="nav-item mt-3 mb-3">
                        <a class="nav-link" href="listaPacientesInfectados">
                            <span data-feather="users"></span>
                            Pacientes Infectados
                        </a>
                    </li>
                    <li class="nav-item mt-3 mb-3">
                        <a class="nav-link" href="consultarAsignacion">
                            <span data-feather="search"></span>
                            Consultar Asignación
                        </a>
                    </li>
                    <li class="nav-item mt-3 mb-3">
                        <a class="nav-link" href="grafico-pacientes">
                            <span data-feather="bar-chart-2"></span>
                            Reportes
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">

            <div class="container">
                <div class="jumbotron">
                    <h1 class="display-4">Bienvenido/a</h1>
                    <p class="lead">Desde aquí acceda a las opciones principales de:
                        ${nombre}</p>
                    <p class="lead">La institución ${nombre} posee ${camas} camas en total.</p>
                    <a class="btn btn-outline-primary" href="verMensajes" role="button">Ver Mensajes Recibidos</a>
                    <a class="btn btn-outline-primary" href="crearMensaje" role="button">Enviar Mensaje</a>
                    <hr class="my-4">
                    <p>
                        
                    </p>
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
