<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../partial/${armarHeader}1.jsp" />

<title>Inserte titulo aquí</title>
    
<jsp:include page="../../partial/${armarHeader}2.jsp" />

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
        
<div class="container-fluid my-5">
    <form:form action="enviarMensaje" method="POST">
        <div class="card text-center border-secondary">
            <div class="card-header">
                <ul class="nav nav-tabs card-header-tabs">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Mensaje</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="/covidtest/bienvenido">Atrás</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1"
                           aria-disabled="true">Destinatario: ${p.getNombre()}</a>
                    </li>
                </ul>
            </div>
            <div class="card-body">
                <h5 class="card-title mt-3 mb-4">Mensaje</h5>
                <textarea class="form-control" id="mensaje" name="mensaje" rows="3"></textarea>
                <input type="hidden" value="${p.getId()}" name="idReceptor">
                <input type="hidden" value="${id}" name="idEmisor">
                <button class="btn btn-primary btn-lg mt-3" type="submit">Enviar</button>
            </div>
        </div>
    </form:form>
</div>
<main/>
<%-- <form action="contact" method="post">
<p>Your email address: <input name="email"></p>
<p>Mail subject: <input name="subject"></p>
<p>Mail message: <textarea name="message"></textarea></p>
<p><input type="submit"><span class="message">${message}</span></p> --%>
<%--</form>--%>
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
</body>