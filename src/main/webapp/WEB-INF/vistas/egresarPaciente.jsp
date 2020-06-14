<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EGRESAR PACIENTE</title>
    <meta name="description" content="Free Bootstrap Theme by BootstrapMade.com">
    <meta name="keywords"
          content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">

    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Raleway|Candal">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
<!--banner-->
<section id="banner" class="banner">
    <div class="bg-color">
        <nav class="navbar navbar-default navbar-fixed-top">
           
            <div class="container">
                <div class="col-md-12">
                    
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                       
                        <a class="navbar-brand" href="#"><img src="img/logo.png" class="img-responsive"
                                                              style="width: 140px; margin-top: -16px;"></a>
                    </div>
                    <div class="collapse navbar-collapse navbar-right" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#banner">INICIO</a></li>
                            <li class=""><a href="#service">PANEL</a></li>
                            <li class=""><a href="#about">REGISTRAR</a></li>
                            <li class=""><a href="#testimonial">PACIENTES</a></li>
                            <li class=""><a href="#contact">ESTADÍSTICAS</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        
<!--         <div class="container"> -->
<!--             <div class="row"> -->
<!--                 <div class="banner-info"> -->
<!--                     <div class="banner-logo text-center"> -->
<!--                         <img src="img/logo.png" class="img-responsive"> -->
<!--                     </div> -->
<!--                     <div class="banner-text text-center"> -->
<!--                         <h1 class="white">Asignación de camas</h1> -->
<!--                         <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod <br>tempor -->
<!--                             incididunt ut labore et dolore magna aliqua.</p> -->
<!--                         <a href="#contact" class="btn btn-appoint">Make an Appointment.</a> -->
<!--                     </div> -->
<!--                     <div class="overlay-detail text-center"> -->
<!--                         <a href="#service"><i class="fa fa-angle-down"></i></a> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
    </div>
</section>
<!--/ banner-->

<!--service-->
<section id="service" class="section-padding">
		
			<div class="container">
		        <div class="row">
		        	<h3 class="form-signin-heading">EGRESAR PACIENTE</h3>
					<hr class="colorgraph">
					<br>
							
			        <form action="egresoValido" method="GET" role="form" class="contactForm">
			                        
			              <div class="form-group">
			                        
			                  <h4>Número de documento</h4>
			                        
			                  <input type="text" name="numeroDocumento" class="form-control br-radius-zero" id="numeroDocumento"
			                                   placeholder="Ingrese número de documento" data-rule="minlen:1"
			                                   data-msg="Ingrese número de documento valido"/>
			                  <div class="validation"></div>
			              </div>
			                        
			                        <div class="form-group">
			                        <h4>Tipo de documento</h4>
			                    
					                    <select name="tipoDocumento" type="TipoDocumento" class="form-control br-radius-zero" >
											<option type="TipoDocumento">DNI
											<option type="TipoDocumento">PASAPORTE
											<option type="TipoDocumento">LIBRETA CÍVICA
										</select>
									</div>
									
									<div class="form-group">
			                        <h4>Motivo de Egreso</h4>
										 <select name="motivoEgreso" type="MotivoEgreso" class="form-control br-radius-zero" >
											<option type="MotivoEgreso">CURADO
											<option type="MotivoEgreso">TRASLADADO
											<option type="MotivoEgreso">FALLECIDO
										</select>      
			                       </div>    
			                               
			                        <div class="validation"></div>
			                       
									<br>
			                        <div class="form-action">
			                            <button type="submit" class="btn btn-form">Egresar Paciente</button>
			                        </div>
			                        <br>
			                        
			                        <div class="form-group">
				                        <c:if test="${not empty error}">			                        
								       	 <h4><span>${error}</span></h4>
								       	 <br>
							      		 </c:if>    
						      	    </div>
					     	        
			        </form>
		        
		        </div>
		    </div>
		
</section>
<!--/ service-->


<!--contact-->
<section id="contact" class="section-padding">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h2 class="ser-title">Contact us</h2>
                <hr class="botm-line">
            </div>
            <div class="col-md-4 col-sm-4">
                <h3>Contact Info</h3>
                <div class="space"></div>
                <p><i class="fa fa-map-marker fa-fw pull-left fa-2x"></i>321 Awesome Street<br> New York, NY 17022</p>
                <div class="space"></div>
                <p><i class="fa fa-envelope-o fa-fw pull-left fa-2x"></i>info@companyname.com</p>
                <div class="space"></div>
                <p><i class="fa fa-phone fa-fw pull-left fa-2x"></i>+1 800 123 1234</p>
            </div>
            <div class="col-md-8 col-sm-8 marb20">
                <div class="contact-info">
                    <h3 class="cnt-ttl">Having Any Query! Or Book an appointment</h3>
                    <div class="space"></div>
                    <div id="sendmessage">Your message has been sent. Thank you!</div>
                    <div id="errormessage"></div>
                    <form action="" method="post" role="form" class="contactForm">
                        <div class="form-group">
                            <input type="text" name="name" class="form-control br-radius-zero" id="name"
                                   placeholder="Your Name" data-rule="minlen:4"
                                   data-msg="Please enter at least 4 chars"/>
                            <div class="validation"></div>
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-control br-radius-zero" name="email" id="email"
                                   placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email"/>
                            <div class="validation"></div>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control br-radius-zero" name="subject" id="subject"
                                   placeholder="Subject" data-rule="minlen:4"
                                   data-msg="Please enter at least 8 chars of subject"/>
                            <div class="validation"></div>
                        </div>
                        <div class="form-group">
                            <textarea class="form-control br-radius-zero" name="message" rows="5" data-rule="required"
                                      data-msg="Please write something for us" placeholder="Message"></textarea>
                            <div class="validation"></div>
                        </div>

                        <div class="form-action">
                            <button type="submit" class="btn btn-form">Send Message</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!--/ contact-->
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
                        <p>Praesent convallis tortor et enim laoreet, vel consectetur purus latoque penatibus et dis
                            parturient.</p>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>

</body>

</html>