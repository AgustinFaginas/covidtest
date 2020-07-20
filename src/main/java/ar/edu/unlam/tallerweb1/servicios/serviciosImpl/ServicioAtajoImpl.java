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

		/*ACCESO PERMITIDO A TODOS*/
		if (
			  /*controladorNotificacion*/
			  request.getRequestURI().contains("/covidtest/crearMensaje")
			  || request.getRequestURI().contains("/covidtest/crearMensajeParaInstitucion")
			  || request.getRequestURI().contains("/covidtest/enviarMensaje")
			  || request.getRequestURI().contains("/covidtest/verMensajes")
			  
			  /*controladorLogin*/
			  || request.getRequestURI().contains("/covidtest/home")
			  
			  /*controladorLogin*/
			  || request.getRequestURI().contains("/covidtest/autoTest")
			  || request.getRequestURI().contains("/covidtest/validarTest")
			  || request.getRequestURI().contains("/covidtest/testPositivo")
			  || request.getRequestURI().contains("/covidtest/testNegativo")
			  || request.getRequestURI().contains("/covidtest/generarPermiso")
			  || request.getRequestURI().contains("/covidtest/validarPermiso")
			  || request.getRequestURI().contains("/covidtest/permisoPositivo")
			  || request.getRequestURI().contains("/covidtest/permisoDenegado")
			  || request.getRequestURI().contains("/covidtest/enfermedades")
			  || request.getRequestURI().contains("/covidtest/validarEnfermedades")
			  ) {
			
			return null;
		}
		
		/*ACCESO PERMITIDO SOLO A ADMIN E INSTITUCIONES*/
		if(
			 /*controladorAdmin*/
		     request.getRequestURI().contains("/covidtest/admin")
		  || request.getRequestURI().contains("/covidtest/homeAdmin")
		  || request.getRequestURI().contains("/covidtest/panel")
		  
			 /*controladorAsignacion*/
		  || request.getRequestURI().contains("/covidtest/consultarAsignacion")
		  || request.getRequestURI().contains("/covidtest/detalleAsignacion")
		  
		  /*controladorNotificacion*/
		  || request.getRequestURI().contains("/covidtest/crearMensaje")
		  || request.getRequestURI().contains("/covidtest/crearMensajeParaInstitucion")
		  || request.getRequestURI().contains("/covidtest/enviarMensaje")
		  || request.getRequestURI().contains("/covidtest/verMensajes")
			  
		  /*controladorCama*/
		  || request.getRequestURI().contains("/covidtest/disponibilidadCamas")
		  || request.getRequestURI().contains("/covidtest/listaCamas")
		  || request.getRequestURI().contains("/covidtest/cantidadDeCamasDisponibleslistaCamas")
		  || request.getRequestURI().contains("/covidtest/listaCamasDisponiblesTotal")
		  
		  /*controladorEgresarPaciente*/
		  || request.getRequestURI().contains("/covidtest/egresoValido")
		  || request.getRequestURI().contains("/covidtest/detalleEgresoPorTraslado")
		  || request.getRequestURI().contains("/covidtest/egresarPacienteMotivo")
		  || request.getRequestURI().contains("/covidtest/detalleEgreso")
		
		  /*controladorInstitucion*/
		  || request.getRequestURI().contains("/covidtest/registrarInstitucion")
		  || request.getRequestURI().contains("/covidtest/detalleRegistroInstitucion")
		  || request.getRequestURI().contains("/covidtest/listaInstituciones")
		  
		  /*controladorInternarPaciente*/
		  || request.getRequestURI().contains("/covidtest/internarPaciente")
		  || request.getRequestURI().contains("/covidtest/detalleInternacion")
		  || request.getRequestURI().contains("/covidtest/detalleInternacionPorPasos")
		  || request.getRequestURI().contains("/covidtest/detalleInternacionPorPasos2")
		  
		  /*controladorRegistrarPaciente*/
		  || request.getRequestURI().contains("/covidtest/registrarPaciente")
		  || request.getRequestURI().contains("/covidtest/detalleRegistroPaciente")
		  
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

		/*ACCESO PERMITIDO SOLO A INSTITUCIONES*/
		if(request.getRequestURI().contains("/covidtest/bienvenido")){
			if (rol == Rol.PACIENTE) {
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

		String header = "header";
		
		/*ACCESO PERMITIDO A TODOS*/
		if (request.getRequestURI().contains("/covidtest/home")
		  || request.getRequestURI().contains("/covidtest/homeAdmin")
		  || request.getRequestURI().contains("/covidtest/admin")
		  || request.getRequestURI().contains("/covidtest/enviarMensaje")
		  || request.getRequestURI().contains("/covidtest/verMensajes")
		  || request.getRequestURI().contains("/covidtest/autoTest")
		  || request.getRequestURI().contains("/covidtest/validarTest")
		  || request.getRequestURI().contains("/covidtest/testPositivo")
		  || request.getRequestURI().contains("/covidtest/testNegativo")
		  || request.getRequestURI().contains("/covidtest/generarPermiso")
		  || request.getRequestURI().contains("/covidtest/validarPermiso")
		  || request.getRequestURI().contains("/covidtest/permisoPositivo")
		  || request.getRequestURI().contains("/covidtest/permisoDenegado")
		  || request.getRequestURI().contains("/covidtest/enfermedades")
		  || request.getRequestURI().contains("/covidtest/validarEnfermedades")
		  || request.getRequestURI().contains("/covidtest/bienvenido")
		  || request.getRequestURI().contains("/covidtest/bienvenidoPaciente")
		  || request.getRequestURI().contains("/covidtest/denied")
		  || request.getRequestURI().contains("/covidtest/detalleRegistroPaciente")
			){
			return header = "usuarioHeaderParte";
		}
		
		Rol rol = (Rol) request.getSession().getAttribute("ROL");
		
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
			header = "usuarioHeaderParte";
			break;
		}
		return header;
	}

}
