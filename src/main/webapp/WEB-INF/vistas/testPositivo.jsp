<%--
  Created by IntelliJ IDEA.
  User: juanp
  Date: 07/06/2020
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Medilab Free Bootstrap HTML5 Template</title>
<meta name="description"
	content="Free Bootstrap Theme by BootstrapMade.com">
<meta name="keywords"
	content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">

<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Open+Sans|Raleway|Candal">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>

<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="60">
	<!--banner-->
	<section id="banner" class="banner">
		<div class="bg-color">
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<div class="col-md-12">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target="#myNavbar">
								<span class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#"><img src="img/logo.png"
								class="img-responsive" style="width: 140px; margin-top: -16px;"></a>
						</div>
						<div class="collapse navbar-collapse navbar-right" id="myNavbar">
							<ul class="nav navbar-nav">
								<li class="active"><a href="#banner">Home</a></li>
								<li class=""><a href="#service">asdasdasddad</a></li>
								<li class=""><a href="#about">About</a></li>
								<li class=""><a href="#testimonial">Testimonial</a></li>
								<li class=""><a href="#contact">Contact</a></li>
							</ul>
						</div>
					</div>
				</div>
			</nav>
			<div class="container">
				<div class="row">
					<div class="banner-info">
						<div class="banner-logo text-center">
							<img src="img/logo.png" class="img-responsive">
						</div>
						<div class="banner-text text-center">
							<h1 class="white">Healthcare at your desk!!</h1>
							<p>
								Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
								eiusmod <br>tempor incididunt ut labore et dolore magna
								aliqua.
							</p>
							<a href="#contact" class="btn btn-appoint">Make an
								Appointment.</a>
						</div>
						<div class="overlay-detail text-center">
							<a href="#service"><i class="fa fa-angle-down"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/ banner-->


<h1>Bienvenido , el test realizado al paciente es positivo :</h1>

<h3>Si el paciente  esta registrado  <a href="internarPaciente">ingrese aqui</a></h3>

<h3>Si el paciente no esta registrado , complete los siguientes datos </h3>

<div class="autotest ">
<form action="registroPaciente" method=get>

<label for="nombre">Nombre</label>
<input type="text" name="nombre" id="nombre">

<label for="nombre">Apellido</label>
<input type="text" name="apellido" id="apellido">

<label for="email">Email</label>
<input type="email" name="email" id="email">

<label for="password">Contraseña</label>
<input type="password" name="password" id="password">

<label for="tipoDni">Tipo Documento</label>
<select name="tipoDoc" id="tipoDni">
<option value="DNI">DNI</option>
<option value="LIBRETA_CIVICA">Libreta Civica</option>
<option value="PASAPORTE">Pasaporte</option>
</select>

<label for="numeroDni">Numero Dni</label>
<input type="number" name="nDoc" id="numeroDni">

<input type="submit"> 

</form>

</div>

	<!--footer-->
	<footer id="footer">
		<div class="top-footer">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-sm-4 marb20">
						<div class="ftr-tle">
							<h4 class="white no-padding">About Us</h4>
						</div>
						<div class="info-sec">
							<p>Praesent convallis tortor et enim laoreet, vel consectetur
								purus latoque penatibus et dis parturient.</p>
						</div>
					</div>
					<div class="col-md-4 col-sm-4 marb20">
						<div class="ftr-tle">
							<h4 class="white no-padding">Quick Links</h4>
						</div>
						<div class="info-sec">
							<ul class="quick-info">
								<li><a href="index.html"><i class="fa fa-circle"></i>Home</a></li>
								<li><a href="#service"><i class="fa fa-circle"></i>Service</a></li>
								<li><a href="#contact"><i class="fa fa-circle"></i>Appointment</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-4 col-sm-4 marb20">
						<div class="ftr-tle">
							<h4 class="white no-padding">Follow us</h4>
						</div>
						<div class="info-sec">
							<ul class="social-icon">
								<li class="bglight-blue"><i class="fa fa-facebook"></i></li>
								<li class="bgred"><i class="fa fa-google-plus"></i></li>
								<li class="bgdark-blue"><i class="fa fa-linkedin"></i></li>
								<li class="bglight-blue"><i class="fa fa-twitter"></i></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-line">
			<div class="container">
				<div class="row">
					<div class="col-md-12 text-center">
						© Copyright Medilab Theme. All Rights Reserved
						<div class="credits">
							<!--
                          All the links in the footer should remain intact.
                          You can delete the links only if you purchased the pro version.
                          Licensing information: https://bootstrapmade.com/license/
                          Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Medilab
                        -->
							Designed by <a href="https://bootstrapmade.com/">BootstrapMade.com</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!--/ footer-->

	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.easing.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/custom.js"></script>
	<script src="contactform/contactform.js"></script>

</body>

</html>










