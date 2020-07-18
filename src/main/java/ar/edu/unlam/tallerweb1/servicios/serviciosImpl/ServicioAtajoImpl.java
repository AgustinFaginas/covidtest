package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.servicios.ServicioAtajo;

@Service("servicioAtajo")
@Transactional
public class ServicioAtajoImpl implements ServicioAtajo{

	
	@Override
	public String validarInicioDeSesion(HttpServletRequest request) {

		if (request.getSession().getAttribute("ID") == null) {
	        return "redirect:/login";
		}
		return null;
	
	}	

	@Override
	public String validarPermisoAPagina(HttpServletRequest request) {
		
		Rol rol = (Rol) request.getSession().getAttribute("ROL");
		
		if (request.getRequestURI() == null) {
	        return null;
		}
		
		if(request.getRequestURI().contains("/covidtest/disponibilidadCamas")) {
			if (rol == Rol.ADMIN || rol == Rol.INSTITUCION) {
		        return null;
			}
			else{
		        return "redirect:/denied";
		    }
		}

	    return null;
	}

	@Override
	public String armarHeader(HttpServletRequest request) {

		Rol rol = (Rol) request.getSession().getAttribute("ROL");
		
		String header = "header";
		switch (rol) {
		case ADMIN:
			header = "adminHeaderParte";
			break;
		case INSTITUCION:
			header = "institucionHeaderParte";
			break;
		case PACIENTE:
			header = "pacienteHeaderParte";
			break;
		default:
			break;
		}
		return header;
	}

}
