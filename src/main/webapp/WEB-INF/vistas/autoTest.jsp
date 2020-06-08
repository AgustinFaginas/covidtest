<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="validarTest" method="get">

		Ingrese su temperatura actual <br>
		<input type="number"  name="fiebre"
       min="35" max="41" required>
       
       <br>
		
		<p>¿Sentis un perdida parcial de olfato ? </p>
		
		Si<input type=checkbox name="perdidaOlfato" > <br>
		
		<p>¿Sentis una perdida parcial del gusto (Sabor en las comidas)? </p>
		
		Si<input type=checkbox name="perdidaGusto" > <br>
		
		<p>¿Tenes tos o dolor de garganta? </p>
		
		Si<input type=checkbox name="tos" > <br>
		
		
		<p> ¿Tenes dificultad respiratoria o falta de aire?</p>
		
		Si<input type=checkbox name="perdidaRespiracion" > <br>
		
		
		<input type=submit>


	</form>

</body>
</html>