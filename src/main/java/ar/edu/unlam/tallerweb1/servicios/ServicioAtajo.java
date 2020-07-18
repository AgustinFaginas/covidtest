package ar.edu.unlam.tallerweb1.servicios;

import javax.servlet.http.HttpServletRequest;

public interface ServicioAtajo{

	String validarInicioDeSesion(HttpServletRequest request);

	String validarPermisoAPagina(HttpServletRequest request);

	String armarHeader(HttpServletRequest request);
	
	
}
