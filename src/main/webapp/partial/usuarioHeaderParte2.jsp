<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% HttpSession sesion = request.getSession(); String rol = sesion.getAttribute("ROL").toString(); String admin = "ADMIN";%>


   <style>
        #navbar-top:hover {
            text-decoration: none;
        }
    </style>

</head>

<body>

<nav class="navbar sticky-top bg-dark text-white justify-content-center align-items-center">
    <a class="text-center text-white" href="#" id="navbar-top">
        <h5>
            Coronavirus COVID-19 conocé información y recomendaciones del Ministerio de Salud</strong>
        </h5>
    </a>
</nav>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="#">
        <img src="img/share2.png" width="35" height="35" class="d-inline-block align-top" alt="logo">
        AsignAR
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
            aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item ml-5 active">
                               <% if (rol.equals("ADMIN")) { %>		
			    <a class="nav-link" href="admin">Home <span class="sr-only">(current)</span></a>
			<% } else if (rol.equals("ADMIN")){%>
                <a class="nav-link" href="bienvenido">Home <span class="sr-only">(current)</span></a>
			<% }else{%>
            <a class="nav-link" href="bienvenidoPaciente">Home <span class="sr-only">(current)</span></a>
		<% } %>

            </li>
            <li class="nav-item ml-5">
                                           <% if (rol.equals("ADMIN")) { %>		
			
			<%}else{%>
                    <a class="nav-link" href="generarPermiso">Generar permiso</a>
		<% } %>

            </li>
        </ul>
                   <% if (rol.isEmpty()) { %>		
			<a href="admin" class="btn btn-dark ml-5" role="button" aria-disabled="true">Iniciar Sesión</a>
			<% } else{%>
			<a href="logout" class="btn btn-dark ml-5" role="button" aria-disabled="true">Salir</a>
			<% } %>
    </div>
</nav>
