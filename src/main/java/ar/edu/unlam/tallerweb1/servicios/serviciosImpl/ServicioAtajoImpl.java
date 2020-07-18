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
		
		/*ACCESO PERMITIDO SOLO A ADMIN E INSTITUCIONES*/
		if(
		  /*controladorCama*/
		     request.getRequestURI().contains("/covidtest/disponibilidadCamas")
		  || request.getRequestURI().contains("/covidtest/listaCamas")
		  || request.getRequestURI().contains("/covidtest/cantidadDeCamasDisponibleslistaCamas")
		  || request.getRequestURI().contains("/covidtest/listaCamasDisponiblesTotal")
		  
		  /*controladorEgresarPaciente*/
		  || request.getRequestURI().contains("/covidtest/egresoValido")
		  || request.getRequestURI().contains("/covidtest/detalleEgresoPorTraslado")
		  || request.getRequestURI().contains("/covidtest/egresarPacienteMotivo")
		  || request.getRequestURI().contains("/covidtest/detalleEgreso")
		
		  /*controladorPaciente*/
		  || request.getRequestURI().contains("/covidtest/consultarPaciente")
		  || request.getRequestURI().contains("/covidtest/detallePaciente")
		  || request.getRequestURI().contains("/covidtest/listaPacientes")
		  || request.getRequestURI().contains("/covidtest/grafico-pacientes")
		  || request.getRequestURI().contains("/covidtest/mapa-paciente")
		  || request.getRequestURI().contains("/covidtest/posiblesinfectados")
		  || request.getRequestURI().contains("/covidtest/listaPacientesInfectados")
		  || request.getRequestURI().contains("/covidtest/listaPacientesInfectadosPasoDos")
		  || request.getRequestURI().contains("/covidtest/listapacientes2")
		  || request.getRequestURI().contains("/covidtest/listaPacientesInternadosDeInstitucion")
		  || request.getRequestURI().contains("/covidtest/listaPacientesInternados")
		  
		 ){
			if (rol == Rol.ADMIN || rol == Rol.INSTITUCION) {
		        return null;
			}
			else{
		        return "redirect:/denied";
		    }
		}

		/*ACCESO PERMITIDO SOLO A PACIENTES*/
		if(request.getRequestURI().contains("/covidtest/bienvenidoPaciente")){
			if (rol == Rol.PACIENTE) {
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
