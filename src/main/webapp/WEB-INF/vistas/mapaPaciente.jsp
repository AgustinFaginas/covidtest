<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../partial/${armarHeader}1.jsp" />

<title>Mapa Paciente</title>

<!-- Load Leaflet from CDN-->
<link rel="stylesheet"
	href="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.css" />
<script src="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.js"></script>
<style>
#map {
	height: 50em;
	width: 100%;
}
</style>

<!-- Load Esri Leaflet from CDN -->
<script
	src="http://cdn-geoweb.s3.amazonaws.com/esri-leaflet/1.0.0-rc.2/esri-leaflet.js"></script>


<jsp:include page="../../partial/${armarHeader}2.jsp" />


<div class="form-group">
	<c:if test="${not empty error}">
		<h4>
			<span>${error}</span>
		</h4>
		<br>
	</c:if>
</div>

<script
	src="http://cdn-geoweb.s3.amazonaws.com/esri-leaflet-geocoder/0.0.1-beta.5/esri-leaflet-geocoder.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://cdn-geoweb.s3.amazonaws.com/esri-leaflet-geocoder/0.0.1-beta.5/esri-leaflet-geocoder.css">

<h1 class="text-center mb-3 mt-5">Ingrese su dirección y luego
	confirme la misma</h1>


<div class="container-fluid my-5">
	<div class="row">
		<div class="col-1"></div>
		<div id="map" class="col-10 border border-dark"></div>
		<div class="col-1"></div>
	</div>
</div>

<%-- <form>
	<div class="form-group">
		<input type="number" class="form-control" id="latitud" name="latitud">
	</div>
	<div class="form-group">
		<input type="text" class="form-control" id="longitud" name="longitud">
	</div>
	<button type="submit" class="btn btn-primary btn-lg">Confirmar
		dirección</button>
	<button type="reset" class="btn btn-primary btn-lg">Cancelar</button>
</form> --%>

<!-- Button trigger modal -->
<div class="container-fluid my-3">
	<div class="row">
		<div class="col-4"></div>
		<div class="col-4 text-center">
			<button type="button" class="btn btn-warning btn-lg"
				data-toggle="modal" data-target="#modalMapa">Confirmar
				dirección</button>
		</div>
		<div class="col-4"></div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="modalMapa" tabindex="-1" role="dialog"
	aria-labelledby="modalMapaLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header text-center">
				<h5 class="modal-title text-center" id="modalMapaLabel">¿Desea
					confirmar la dirección ingresada?</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form action="validarMapa" method="POST" modelAttribute="paciente">
				<div class="modal-body">

					<p class="text-center">Recuerde que la información consignada
						precedentemente reviste carácter de Declaración Jurada. Su omisión
						o falsedad procederá al rechazo de la inscripción en este sitio
						web, sin perjuicio de las sanciones que le pudiera corresponder.</p>

					<div class="form-group">
						<input type="hidden" class="form-control" id="latitud"
							name="latitud">
					</div>
					<div class="form-group">
						<input type="hidden" class="form-control" id="longitud"
							name="longitud">
					</div>

				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Confirmar</button>
					<button type="reset" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				</div>
			</form>
		</div>
	</div>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<script>
	var hospitales = [
			{
				"nombre" : "HOSPITAL GENERAL DE AGUDOS D. VELEZ SARSFIELD",
				"lat" : -34.6253368,
				"lon" : -58.50761514
			},
			{
				"nombre" : "HOSP. DE PEDIATRIA DR. J. GARRAHAN",
				"lat" : -34.62994536,
				"lon" : -58.39187918
			},
			{
				"nombre" : "HOSPITAL GENERAL DE NIÑOS PEDRO DE ELIZALDE",
				"lat" : -34.62884736,
				"lon" : -58.37755085
			},
			{
				"nombre" : "HOSPITAL DE REHABILITACION RESPIRATORIA MARIA FERRER",
				"lat" : -34.630211204449473,
				"lon" : -58.3758433488021
			},
			{
				"nombre" : "HOSPITAL INFANTO JUVENIL C. TOBAR GARCIA",
				"lat" : -34.635702235155911,
				"lon" : -58.382328450948762
			},
			{
				"nombre" : "HOSPITAL GENERAL DE AGUDOS B. RIVADAVIA",
				"lat" : -34.58476595812138,
				"lon" : -58.400513457442273
			},
			{
				"nombre" : "HOSPITAL GENERAL DE AGUDOS DR C. ARGERICH",
				"lat" : -34.628344858167651,
				"lon" : -58.365985088719015
			},
			{
				"nombre" : "HOSPITAL GENERAL DE AGUDOS DR. J. A. FERNANDEZ",
				"lat" : -34.581141710888993,
				"lon" : -58.406893914278655
			},
			{
				"nombre" : "HOSPITAL CECILIA GRIERSON",
				"lat" : -34.67184801407717,
				"lon" : -58.456642849110352
			},
			{
				"nombre" : "HOSPITAL DE REHABILITACION M. ROCCA",
				"lat" : -34.617981754059123,
				"lon" : -58.502144922222243
			},
			{
				"nombre" : "HOSPITAL DE OFTALMOLOGIA SANTA LUCIA",
				"lat" : -34.622712507512453,
				"lon" : -58.394064160474649
			},
			{
				"nombre" : "HOSPITAL DE QUEMADOS DR. ARTURO UMBERTO ILLIA",
				"lat" : -34.625503195248271,
				"lon" : -58.432396695024352
			},
			{
				"nombre" : "HOSPITAL DE ODONTOLOGIA  JOSE DUEÑAS",
				"lat" : -34.614634834842903,
				"lon" : -58.427659754283688
			},
			{
				"nombre" : "HOSPITAL OFTALMOLOGICO DR. PEDRO LAGLEYZE",
				"lat" : -34.605434275020741,
				"lon" : -58.460185577552785
			},
			{
				"nombre" : "UNIVERSIDAD NACIONAL DE LA MATANZA",
				"lat" : -34.670520,
				"lon" : -58.562806
			},
			{
				"nombre" : "CLUB PORTUGUÉS DEL GRAN BUENOS AIRES",
				"lat" : -34.700021,
				"lon" : -58.589954
			},
			{
				"nombre" : "PREDIO DEPORTIVO JUAN DOMINGO PERÓN",
				"lat" : -34.784184,
				"lon" : -58.625167
			},
			{
				"nombre" : "HOSPITAL DE AGUDOS PAROISSIEN",
				"lat" : -34.695668,
				"lon" : -58.579381
			},
			{
				"nombre" : "SKYLAB",
				"lat" : -34.693365,
				"lon" : -58.572578
			},
			{
				"nombre" : "COMPLEJO DEPORTIVO PEDRO MENDOZA",
				"lat" : -34.696371,
				"lon" : -58.585985
			},
			{
				"nombre" : "CLUB SOCIAL Y DEPORTIVO LAFERRERE",
				"lat" : -34.752396,
				"lon" : -58.593529
			},
			{
				"nombre" : "HOSPITAL DR. ALBERTO BALESTRINI",
				"lat" : -34.707360,
				"lon" : -58.532926
			},
			{
				"nombre" : "HOSPITAL DE MORÓN",
				"lat" : -34.658637,
				"lon" : -58.609762
			},
			{
				"nombre" : "POLICLÍNICO PROFESOR ALEJANDRO POSADAS",
				"lat" : -34.628968,
				"lon" : -58.574673
			},
			{
				"nombre" : "HOSPITAL INTERZONAL GENERAL DE AGUDOS PROFESOR DR. LUIS GÜEMES",
				"lat" : -34.641730,
				"lon" : -58.579906
			}, {
				"nombre" : "HOSPITAL MATERNO INFANTIL R. SARDA",
				"lat" : -34.634856308414967,
				"lon" : -58.402750627537664
			}

	];

	var map = L.map('map').setView([ -35.05789999999996, -59.04061999999993 ],
			9);

	L
			.tileLayer(
					'http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
					{
						attribution : '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
					}).addTo(map);

	let iconMarker = L.icon({
		iconUrl : 'img/red-cross.png',

	});

	for (var i = 0; i < hospitales.length; i++) {
		marker = new L.marker([ hospitales[i].lat, hospitales[i].lon ], {
			icon : iconMarker
		}).bindPopup(hospitales[i].nombre).addTo(map);
	};

	var searchControl = new L.esri.Controls.Geosearch().addTo(map);

	var results = new L.LayerGroup().addTo(map);

	let posicion;

	searchControl.on('results', function(data) {
		results.clearLayers();
		for (var i = data.results.length - 1; i >= 0; i--) {
			results.addLayer(L.marker(data.results[i].latlng));

			posicion = data.results[i].latlng;
			console.log(posicion.lat);
			console.log(posicion.lng);
			document.getElementById("latitud").value = posicion.lat;
			document.getElementById("longitud").value = posicion.lng;
		}
	});
</script>

<!-- Footer -->
<footer
	class="page-footer font-small mdb-color pt-4 bg-whiteborder border-top">

	<!-- Footer Links -->
	<div class="container text-center text-md-left">

		<!-- Footer links -->
		<div class="row text-center text-md-left mt-3 pb-3">

			<!-- Grid column -->
			<div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3 text-left">
				<h6 class="text-uppercase mb-4 font-weight-bold">asignAR</h6>
				<img src="img/share2.png" width="50" height="50"
					class="d-inline-block align-top" alt="logo">
			</div>
			<!-- Grid column -->

			<hr class="w-100 clearfix d-md-none">

			<!-- Grid column -->
			<div class="col-md-3 col-lg-2 col-xl-2 mx-auto mt-3">
				<h6 class="text-uppercase mb-4 font-weight-bold">ENLACES ÚTILES</h6>
				<p>
					<a href="https://www.argentina.gob.ar/salud/coronavirus-COVID-19">Ministerio
						de Salud</a>
				</p>
				<p>
					<a href="#!">Hospitales y establecimientos de salud</a>
				</p>
			</div>

			<!-- Grid column -->
			<hr class="w-100 clearfix d-md-none">

			<!-- Grid column -->
			<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
				<h6 class="text-uppercase mb-4 font-weight-bold">Teléfono</h6>
				<p>
					<i class="fas fa-home"></i> Llamá al <strong>120</strong>, es
					gratuito desde cualquier lugar del país y te atienden las 24 horas.
				</p>
				<hr>
				<h6 class="text-uppercase mb-4 font-weight-bold">Whatsapp</h6>
				<i class="fas fa-home"></i> Escribí "Hola" al <strong>+54 9
					11 2256-0566</strong> para que encuentres respuestas a las preguntas más
				frecuentes y recibas consejos de prevención.
				</p>


			</div>
			<!-- Grid column -->

		</div>
		<!-- Footer links -->

		<hr>

		<!-- Grid row -->
		<div class="row d-flex align-items-center">

			<!-- Grid column -->
			<div class="col-md-7 col-lg-8">

				<!--Copyright-->
				<p class="text-center text-md-left">
					© 2020 Copyright: <strong>ASIGNAR</strong>

				</p>

			</div>
			<!-- Grid column -->

			<!-- Grid column -->
			<div class="col-md-5 col-lg-4 ml-lg-0">

				<!-- Social buttons -->
				<div class="text-center text-md-right">
					<ul class="list-unstyled list-inline">
						<li class="list-inline-item"><a
							class="btn-floating btn-sm rgba-white-slight mx-1"> <i
								class="fab fa-facebook-f"></i>
						</a></li>
						<li class="list-inline-item"><a
							class="btn-floating btn-sm rgba-white-slight mx-1"> <i
								class="fab fa-twitter"></i>
						</a></li>
						<li class="list-inline-item"><a
							class="btn-floating btn-sm rgba-white-slight mx-1"> <i
								class="fab fa-google-plus-g"></i>
						</a></li>
						<li class="list-inline-item"><a
							class="btn-floating btn-sm rgba-white-slight mx-1"> <i
								class="fab fa-linkedin-in"></i>
						</a></li>
					</ul>
				</div>

			</div>
			<!-- Grid column -->

		</div>
		<!-- Grid row -->

	</div>
	<!-- Footer Links -->

</footer>
<!-- Footer -->

</body>

</html>