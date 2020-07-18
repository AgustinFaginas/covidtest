<% HttpSession sesion = request.getSession(); String rol = sesion.getAttribute("ROL").toString(); String admin = "ADMIN";%>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/dashboard/">

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

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
<nav class="navbar navbar-dark sticky-top bg-primary flex-md-nowrap p-0 shadow">
    <%--    <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">COVIDTEST</a>--%>
    <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="home">
        <img src="img/share2.png" width="35" height="35" class="d-inline-block align-top" alt="logo">
        AsignAR
    </a>
    <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse"
            data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <!--   <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search"> -->
    <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
        <c:if test="${rol == null}">
		<a href="login" class="btn btn-dark ml-5" role="button"
               aria-disabled="true">Iniciar Sesión</a>
		</c:if>	
		<c:if test="${rol != null}">
		<a href="logout" class="btn btn-dark ml-5" role="button"
               aria-disabled="true">Salir</a>
		</c:if>	
       </li>
  	</ul>
</nav>

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
                    <li class="nav-item mt-3 mb-3">
                        <a class="nav-link" href="posiblesinfectados">
                            <span data-feather="users"></span>
                            Lista de Espera
                        </a>
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