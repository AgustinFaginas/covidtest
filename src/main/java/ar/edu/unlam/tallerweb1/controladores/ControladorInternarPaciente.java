package ar.edu.unlam.tallerweb1.controladores;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioAtajo;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioInternacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorInternarPaciente {

	@Autowired
	ServicioAsignacion servicioAsignacion;
	@Autowired
	ServicioInternacion servicioInternacion;
	@Autowired
	ServicioPaciente servicioPaciente;
	@Autowired
	ServicioCama servicioCama;	
	@Autowired
	ServicioUsuario servicioUsuario;
	@Autowired
	ServicioInstitucion servicioInstitucion;
	@Autowired
	ServicioAtajo servicioAtajo;
	
	@RequestMapping("/internarPaciente")
	public ModelAndView internarPaciente(HttpServletRequest request) {

		ModelMap model = new ModelMap();
		
    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
		Long id = (long) request.getSession().getAttribute("ID");
    	Institucion institucion = servicioInstitucion.obtenerInstitucionPorId(id);

        List<Cama> camasDisponiblesInstitucion = servicioCama.obtenerCamas();

	    model.put("camas", camasDisponiblesInstitucion);
	        
		return new ModelAndView("internarPaciente", model);
	}
	
	@RequestMapping(path = "/detalleInternacion")
	public ModelAndView detalleInternacion(
			
			HttpServletRequest request,
			@RequestParam(value = "numeroDocumento") String numeroDocumento,
			@RequestParam(value = "tipoDocumento", required = false) TipoDocumento tipoDocumento,
			@RequestParam(value = "cama", required = false) Long idCama
			) {
		
		ModelMap model = new ModelMap();
		
    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
		
		Paciente pacienteBuscado =  servicioPaciente.consultarPacientePorDoc(numeroDocumento, tipoDocumento);
		Cama camaBuscada = servicioCama.consultarCamaPorId(idCama);
		
		if (pacienteBuscado != null) {
		
			if (servicioAsignacion.consultarAsignacionPacienteInternado(pacienteBuscado) == null) {
				
				Asignacion asignacionAGuardar = new Asignacion();
				LocalDateTime horaIngreso = LocalDateTime.now();
				
				asignacionAGuardar.setPaciente(pacienteBuscado);
				asignacionAGuardar.setCama(camaBuscada);
				asignacionAGuardar.setHoraIngreso(horaIngreso );
				
				servicioInternacion.registrarInternacion(asignacionAGuardar);
				
				pacienteBuscado.setPosibleInfectado(false);
				pacienteBuscado.setInfectado(false);
				servicioPaciente.actualizarPaciente(pacienteBuscado);
				
				String mensaje = "Nombre del paciente: " + asignacionAGuardar.getPaciente().getNombre() + " " 
														 + asignacionAGuardar.getPaciente().getApellido();
				String mensaje2 = "Cama asignada: " + asignacionAGuardar.getCama().getDescripcion();
				String mensaje3 = "Hora de internación: " + asignacionAGuardar.getHoraIngreso();
				
				model.put("mensaje", mensaje);
				model.put("mensaje2", mensaje2);
				model.put("mensaje3", mensaje3);
				
				model.put("detalleInternacion", "El paciente fue egresado");

				return new ModelAndView("detalleInternacion", model);
			} 
			else {
				model.put("error", "El paciente ya está asignado");

				return new ModelAndView("redirect:/internarPaciente");
			}
		}	
		
		else {
			model.put("error", "No existe el paciente");
			
			return new ModelAndView("redirect:/internarPaciente", model);
		}
	}
	
	@RequestMapping(path = "/detalleInternacionPorPasos")
	public ModelAndView detalleInternacionPorPasos(
				
			@RequestParam(value = "idCama", required = false) Long idCama,
			HttpServletRequest request
			) {
		
		ModelMap model = new ModelMap();
		
    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
		
		Long idPaciente = (long) request.getSession().getAttribute("ID_PACIENTE");
		
		Paciente pacienteBuscado =  servicioPaciente.consultarPacientePorId(idPaciente);
		Cama camaBuscada = servicioCama.consultarCamaPorId(idCama);
		
		if (pacienteBuscado == null && camaBuscada == null) {
				model.put("error", "El paciente no existe");
				return new ModelAndView("redirect:/internarPaciente", model);
		}
		if (pacienteBuscado == null && camaBuscada == null) {
			model.put("error", "La cama no existe");
			return new ModelAndView("redirect:/internarPaciente", model);
		}		
		if (servicioAsignacion.consultarAsignacionPacienteInternado(pacienteBuscado) != null) {
			model.put("error", "El paciente ya está asignado");
			return new ModelAndView("redirect:/listaCamas", model);
		}
		
		Asignacion asignacionAGuardar = new Asignacion();
		LocalDateTime horaIngreso = LocalDateTime.now();
		
		asignacionAGuardar.setPaciente(pacienteBuscado);
		asignacionAGuardar.setCama(camaBuscada);
		asignacionAGuardar.setHoraIngreso(horaIngreso );
		
		servicioInternacion.registrarInternacion(asignacionAGuardar);
		
		pacienteBuscado.setInfectado(false);
		servicioPaciente.modificarPaciente(pacienteBuscado);
		
		String mensaje = "Nombre del paciente: " + asignacionAGuardar.getPaciente().getNombre() + " " 
												 + asignacionAGuardar.getPaciente().getApellido();
		String mensaje2 = "Cama asignada: " + asignacionAGuardar.getCama().getDescripcion();
		String mensaje3 = "Hora de internación: " + asignacionAGuardar.getHoraIngreso();
		
		model.put("mensaje", mensaje);
		model.put("mensaje2", mensaje2);
		model.put("mensaje3", mensaje3);
		
		model.put("detalleInternacionPorPasos", "El paciente fue egresado");

		return new ModelAndView("detalleInternacionPorPasos", model);		
		
	}	
	
	@RequestMapping(path = "/detalleInternacionPorPasos2")
	public ModelAndView detalleInternacionPorPasos2(
				
			@RequestParam(value = "idCama", required = false) Long idCama,
			@RequestParam(value = "idPaciente", required = false) Long idPaciente,
			HttpServletRequest request
			) {
		
		ModelMap model = new ModelMap();
		
    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
		
		Paciente pacienteBuscado =  servicioPaciente.consultarPacientePorId(idPaciente);
		Cama camaBuscada = servicioCama.consultarCamaPorId(idCama);
		
		if (pacienteBuscado == null && camaBuscada == null) {
				model.put("error", "El paciente no existe");
				return new ModelAndView("redirect:/internarPaciente", model);
		}
		if (pacienteBuscado == null && camaBuscada == null) {
			model.put("error", "La cama no existe");
			return new ModelAndView("redirect:/internarPaciente", model);
		}		
		if (servicioAsignacion.consultarAsignacionPacienteInternado(pacienteBuscado) != null) {
			model.put("error", "El paciente ya está asignado");
			return new ModelAndView("redirect:/listaCamas", model);
		}
				
		Asignacion asignacionAGuardar = new Asignacion();
		LocalDateTime horaIngreso = LocalDateTime.now();
		
		asignacionAGuardar.setPaciente(pacienteBuscado);
		asignacionAGuardar.setCama(camaBuscada);
		asignacionAGuardar.setHoraIngreso(horaIngreso );
		
		servicioInternacion.registrarInternacion(asignacionAGuardar);
		
		pacienteBuscado.setInfectado(false);
		servicioPaciente.modificarPaciente(pacienteBuscado);
		
		String mensaje = "Nombre del paciente: " + asignacionAGuardar.getPaciente().getNombre() + " " 
												 + asignacionAGuardar.getPaciente().getApellido();
		String mensaje2 = "Cama asignada: " + asignacionAGuardar.getCama().getDescripcion();
		String mensaje3 = "Hora de internación: " + asignacionAGuardar.getHoraIngreso();
		
		model.put("mensaje", mensaje);
		model.put("mensaje2", mensaje2);
		model.put("mensaje3", mensaje3);
		
		model.put("detalleInternacionPorPasos", "El paciente fue egresado");

		return new ModelAndView("detalleInternacionPorPasos2", model);		
		
	}	

	/* ----- Getters and setters ----- */
	public ServicioAsignacion getServicioAsignacion() {
		return servicioAsignacion;
	}

	public void setServicioAsignacion(ServicioAsignacion servicioAsignacion) {
		this.servicioAsignacion = servicioAsignacion;
	}

	public ServicioInternacion getServicioInternacion() {
		return servicioInternacion;
	}

	public void setServicioInternacion(ServicioInternacion servicioInternacion) {
		this.servicioInternacion = servicioInternacion;
	}

	public ServicioPaciente getServicioPaciente() {
		return servicioPaciente;
	}

	public void setServicioPaciente(ServicioPaciente servicioPaciente) {
		this.servicioPaciente = servicioPaciente;
	}

	public ServicioCama getServicioCama() {
		return servicioCama;
	}

	public void setServicioCama(ServicioCama servicioCama) {
		this.servicioCama = servicioCama;
	}

	public ServicioUsuario getServicioUsuario() {
		return servicioUsuario;
	}

	public void setServicioUsuario(ServicioUsuario servicioUsuario) {
		this.servicioUsuario = servicioUsuario;
	}

	public ServicioInstitucion getServicioInstitucion() {
		return servicioInstitucion;
	}

	public void setServicioInstitucion(ServicioInstitucion servicioInstitucion) {
		this.servicioInstitucion = servicioInstitucion;
	}
}