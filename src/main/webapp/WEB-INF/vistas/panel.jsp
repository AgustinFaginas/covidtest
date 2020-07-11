<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v4.0.1">
<title>Admin</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/dashboard/">

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

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="css/dashboard.css" rel="stylesheet">
</head>
<body>
	<nav
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">AsignAR</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-toggle="collapse" data-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<input class="form-control form-control-dark w-100" type="text"
			placeholder="Search" aria-label="Search">
		<ul class="navbar-nav px-3">
			<li class="nav-item text-nowrap"><a class="nav-link"
				href="logout">Salir</a></li>
		</ul>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="sidebar-sticky pt-3">
					<ul class="nav flex-column">
						<li class="nav-item mt-3 mb-3"><a class="nav-link"
							href="bienvenido"> <span data-feather="home"></span> Home
						</a></li>
						<li class="nav-item mt-3 mb-3"><a class="nav-link"
							href="disponibilidadCamas"> <span data-feather="inbox"></span>
								Disponibilidad Camas
						</a></li>
						<li class="nav-item mt-3 mb-3"><a class="nav-link"
							href="posiblesinfectados"> <span data-feather="users"></span>
								Lista de Espera
						</a></li>
						<li class="nav-item mt-3 mb-3"><a class="nav-link"
							href="consultarPaciente"> <span data-feather="search"></span>
								Consultar paciente
						</a></li>
						<li class="nav-item mt-3 mb-3"><a class="nav-link"
							href="internarPaciente"> <span data-feather="user-plus"></span>
								Internar paciente
						</a></li>
						<li class="nav-item mt-3 mb-3"><a class="nav-link"
							href="egresarPaciente"> <span data-feather="user-minus"></span>
								Egresar paciente
						</a></li>
						<li class="nav-item mt-3 mb-3"><a class="nav-link"
							href="listaPacientesInfectados"> <span data-feather="users"></span>
								Pacientes Infectados
						</a></li>
						<li class="nav-item mt-3 mb-3"><a class="nav-link"
							href="grafico-pacientes"> <span data-feather="bar-chart-2"></span>
								Reportes
						</a></li>
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
				<!-- <div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Panel de Control</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group mr-2">
							<button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
							<button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
						</div>
						<button type="button"
							class="btn btn-sm btn-outline-secondary dropdown-toggle">
							<span data-feather="calendar"></span> This week
						</button>
					</div>
				</div> -->

				<%--  <canvas class="my-4 w-100" id="myChart" width="860" height="380"></canvas> --%>

				<br>
				<h2>Gestión de Pacientes</h2>
				<br>
				<div class="container">


					<button type="button" class="btn btn-outline-primary">Notificaciones</button>
					<button type="button" class="btn btn-outline-secondary">Ordenar</button>

					<table id="myTable"
						class="table table-bordered table-hover responsive nowrap text-center">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">NOMBRE</th>
								<th scope="col">ESTADO</th>
								<th scope="col">ACCIONES</th>
								<th scope="col">PRIORIDAD</th>
							</tr>
							<c:forEach items="${poInfectados}" var="paciente">
								<tr>
						</thead>
						<tbody>
							<th scope="row"><c:out value="${paciente.getId()}" /></th>
							<td class="align-middle"><c:out
									value="${paciente.getNombre()}" /></td>
							<td class="align-middle font-weight-bold"><c:out
									value="${paciente.getInfectado() ? 'Infectado' : 'No infectado'}" /></td>
							<td class="align-middle"><button type="button"
									class="btn btn-secondary">Derivar a Institución</button> <a
								class="btn btn-warning"
								href="<c:url value='/crearMensaje/${paciente.getId()}'/>"
								role="button"> Enviar Mensaje</a>
								<button type="button" class="btn btn-danger">Borrar</button></td>

							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</main>
		</div>
	</div>
	<script>
function sortTable() {
  var table, rows, switching, i, x, y, shouldSwitch;
  table = document.getElementById("myTable");
  switching = true;
  /*Make a loop that will continue until
  no switching has been done:*/
  while (switching) {
    //start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /*Loop through all table rows (except the
    first, which contains table headers):*/
    for (i = 1; i < (rows.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /*Get the two elements you want to compare,
      one from current row and one from the next:*/
      x = rows[i].getElementsByTagName("TD")[0];
      y = rows[i + 1].getElementsByTagName("TD")[0];
      //check if the two rows should switch place:
      if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
        //if so, mark as a switch and break the loop:
        shouldSwitch = true;
        break;
      }
    }
    if (shouldSwitch) {
      /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}
</script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')
	</script>
	<script src="../assets/dist/js/bootstrap.bundle.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
	<script src="js/dashboard.js"></script>
</body>
</html>