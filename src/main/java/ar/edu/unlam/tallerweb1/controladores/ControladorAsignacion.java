package ar.edu.unlam.tallerweb1.controladores;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.MotivoEgreso;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioAtajo;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioInternacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;

@Controller
public class ControladorAsignacion {

	private ServicioAsignacion servicioAsignacion;
	private ServicioPaciente servicioPaciente;
	private ServicioCama servicioCama;
	private ServicioInternacion servicioInternacion;
	private ServicioInstitucion servicioInstitucion;
	private ServicioAtajo servicioAtajo;
	
	@Inject
	public ControladorAsignacion(ServicioAsignacion servicioAsignacion, ServicioPaciente servicioPaciente, 
			  ServicioCama servicioCama, ServicioInternacion servicioInternacion,
			  ServicioInstitucion servicioInstitucion, ServicioAtajo servicioAtajo) {
	this.servicioAsignacion = servicioAsignacion;
	this.servicioPaciente = servicioPaciente;
	this.servicioCama = servicioCama;
	this.servicioInternacion = servicioInternacion;
	this.servicioInstitucion = servicioInstitucion;
	this.servicioAtajo = servicioAtajo;
	}
	
	/*Consultar la asignación de un paciente por su nro y tipo de Documento*/
	@RequestMapping("/consultarAsignacion")
	public ModelAndView consultarAsignacion(HttpServletRequest request) {
		
    	ModelMap model = new ModelMap();
		
    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
		return new ModelAndView("consultarAsignacion", model);
	}
	
	/*Detalle de consultar la asignación de un paciente por su nro y tipo de Documento*/
	@RequestMapping(path = "/detalleAsignacion", method = RequestMethod.GET)
	public ModelAndView validarAsignacion( 
			
			HttpServletRequest request,
            @RequestParam(value = "numeroDocumento") String numeroDocumento,
			@RequestParam(value = "tipoDocumento", required = false) TipoDocumento tipoDocumento
            ){
		
    	ModelMap model = new ModelMap();
		
    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
		
		Asignacion asignacionBuscada = new Asignacion();
		
		Paciente pacienteBuscado =  servicioPaciente.consultarPacientePorDoc(numeroDocumento, tipoDocumento);
		
			if (pacienteBuscado != null) {
			
				asignacionBuscada =  servicioAsignacion.consultarAsignacionPacienteInternado(pacienteBuscado);
				
				if (asignacionBuscada != null) {
					
					String apellido = asignacionBuscada.getPaciente().getApellido();
					String nombre = asignacionBuscada.getPaciente().getNombre();
					String numeroDocumento2 = asignacionBuscada.getPaciente().getNumeroDocumento();
					String tipoDocumento2 = asignacionBuscada.getPaciente().getTipoDocumento().name();
					String horaIngreso = asignacionBuscada.getHoraIngreso().toString();
					String cama = asignacionBuscada.getCama().getDescripcion();
					
					model.put("apellido", apellido);
					model.put("nombre", nombre);
					model.put("numeroDocumento", numeroDocumento2);
					model.put("tipoDocumento", tipoDocumento2);
					model.put("horaIngreso", horaIngreso);
					model.put("cama", cama);
					
					return new ModelAndView("detalleAsignacion", model);
				}
				model.put("error", "El paciente no está asignado");
				
				return new ModelAndView("consultarAsignacion", model);
			}
			model.put("error", "No existe el paciente");
			
			return new ModelAndView("consultarAsignacion", model);
	}
	
	@RequestMapping("/internarPaciente")
	public ModelAndView internarPaciente(HttpServletRequest request) {

		ModelMap model = new ModelMap();
		
    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
    	Long id = (Long) request.getSession().getAttribute("ID");
        Institucion institucion = servicioInstitucion.obtenerInstitucionPorId(id);

        List<Cama> camasDisponiblesInstitucion = servicioCama.obtenerCamasPorInstitucion(institucion);
        
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
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
		
		Paciente pacienteBuscado =  servicioPaciente.consultarPacientePorDoc(numeroDocumento, tipoDocumento);
		Cama camaBuscada = servicioCama.consultarCamaPorId(idCama);

		
		if (pacienteBuscado != null) {
		
			if (servicioAsignacion.consultarAsignacionPacienteInternado(pacienteBuscado) == null) {
				
				if (camaBuscada == null) {
					model.put("error", "Seleccione una cama");

					return new ModelAndView("redirect:/internarPaciente");
				}
				
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
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
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
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
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
	
	@RequestMapping("/egresarPaciente")
	public ModelAndView egresarPaciente(HttpServletRequest request) {

    	ModelMap model = new ModelMap();

    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));

		return new ModelAndView("egresarPaciente", model);
	}
	
	@RequestMapping(path = "/egresoValido")
	public ModelAndView egresoValido(
			
			@RequestParam(value = "numeroDocumento") String numeroDocumento,
			@RequestParam(value = "tipoDocumento", required = false) TipoDocumento tipoDocumento,
			@RequestParam(value = "motivoEgreso", required = false) MotivoEgreso motivoEgreso,
			HttpServletRequest request
			) {
		
		ModelMap model = new ModelMap();
		
    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
		
		Asignacion asignacionBuscada = new Asignacion();
		
		Paciente pacienteBuscado =  servicioPaciente.consultarPacientePorDoc(numeroDocumento, tipoDocumento);
		
		if (pacienteBuscado != null) {
		
			asignacionBuscada = servicioAsignacion.consultarAsignacionPacienteInternado(pacienteBuscado);
		
			if (asignacionBuscada != null) {
				
				LocalDateTime horaEgreso = LocalDateTime.now();
				
				asignacionBuscada.setHoraEgreso(horaEgreso);
				asignacionBuscada.setMotivoEgreso(motivoEgreso);
				
				servicioAsignacion.actualizarAsignacion(asignacionBuscada);
				
				String mensaje = "Nombre del paciente: " + asignacionBuscada.getPaciente().getNombre() + " " 
														 + asignacionBuscada.getPaciente().getApellido();
				String mensaje2 = "Cama asignada: " + asignacionBuscada.getCama().getDescripcion();
				String mensaje3 = "Hora de internación: " + asignacionBuscada.getHoraIngreso();
				String mensaje4 = "Hora de egreso: " + asignacionBuscada.getHoraEgreso();
				String mensaje5 = "Motivo de egreso: " + asignacionBuscada.getMotivoEgreso();
				
				model.put("mensaje", mensaje);
				model.put("mensaje2", mensaje2);
				model.put("mensaje3", mensaje3);
				model.put("mensaje4", mensaje4);
				model.put("mensaje5", mensaje5);
				
				model.put("egresoValido", "El paciente fue egresado");

				return new ModelAndView("egresoValido", model);
			} 
			else {
				model.put("error", "El paciente no está asignado");
				
				return new ModelAndView("egresarPaciente", model);
			}
		}	
		
		else {
			model.put("error", "No existe el paciente");
			
			return new ModelAndView("egresarPaciente", model);
		}
	}
	 
	@RequestMapping("/detalleEgresoPorTraslado")
    public ModelAndView validarEgresoPorTraslado(

            HttpServletRequest request,
            @RequestParam(value = "idPaciente") Long idPaciente,
            @RequestParam(value = "idCama") Long idCama,
            @RequestParam(value = "motivoEgreso") MotivoEgreso motivoEgreso

    ) {

        ModelMap model = new ModelMap();

        if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
		
    	Paciente pacienteBuscado =  servicioPaciente.consultarPacientePorId(idPaciente);
		
		if (pacienteBuscado == null) {
			model.put("error", "No existe el paciente");
			return new ModelAndView("egresarPaciente", model);
		}
		
		Asignacion asignacionBuscada = servicioAsignacion.consultarAsignacionPacienteInternado(pacienteBuscado);	
		
		if (asignacionBuscada == null) {
			model.put("error", "El paciente no está asignado");
			return new ModelAndView("egresarPaciente", model);
		}	
		
		LocalDateTime dateTimeNow = LocalDateTime.now();
		
		asignacionBuscada.setHoraEgreso(dateTimeNow);
		asignacionBuscada.setMotivoEgreso(motivoEgreso);
		
		servicioAsignacion.actualizarAsignacion(asignacionBuscada);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = asignacionBuscada.getHoraIngreso();
		String horaIngreso = dateTime.format(formatter);
		String horaEgreso = dateTimeNow.format(formatter);
		

		Asignacion asignacionAGuardar = new Asignacion();
		Cama camaBuscada = servicioCama.consultarCamaPorId(idCama);
		
		asignacionAGuardar.setPaciente(pacienteBuscado);
		asignacionAGuardar.setCama(camaBuscada);
		asignacionAGuardar.setHoraIngreso(dateTimeNow);
		
		servicioInternacion.registrarInternacion(asignacionAGuardar);
		
		model.put("paciente", pacienteBuscado);
		model.put("horaIngreso", horaIngreso);
		model.put("horaEgreso", horaEgreso);
		model.put("asignacion", asignacionBuscada);
		model.put("asignacion2", asignacionAGuardar);
        
        return new ModelAndView("detalleEgreso", model);
    }

	@RequestMapping("/egresarPacienteMotivo")
    public ModelAndView egresarPacienteMotivo(
    		
        HttpServletRequest request,
        @RequestParam(value = "idPaciente") Long idPaciente) {

        ModelMap model = new ModelMap();
        
        if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
		
        
    	Paciente pacienteBuscado =  servicioPaciente.consultarPacientePorId(idPaciente);
		
		if (pacienteBuscado == null) {
			model.put("error", "No existe el paciente");
			return new ModelAndView("egresarPaciente", model);
		}
		
		Asignacion asignacionBuscada = servicioAsignacion.consultarAsignacionPacienteInternado(pacienteBuscado);	
		
		if (asignacionBuscada == null) {
			model.put("error", "El paciente no está asignado");
			return new ModelAndView("egresarPaciente", model);
		}		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = asignacionBuscada.getHoraIngreso();
		String horaIngreso = dateTime.format(formatter);
		
		model.put("paciente", pacienteBuscado);
		model.put("horaIngreso", horaIngreso);
		model.put("asignacion", asignacionBuscada);
		
        return new ModelAndView("egresarPacienteMotivo", model);
    }
	
	@RequestMapping("/detalleEgreso")
    public ModelAndView validarEgreso(

            HttpServletRequest request,
            @RequestParam(value = "idPaciente") Long idPaciente,
            @RequestParam(value = "motivoEgreso") MotivoEgreso motivoEgreso
    ) {

        ModelMap model = new ModelMap();

        if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
        
    	Paciente pacienteBuscado =  servicioPaciente.consultarPacientePorId(idPaciente);
		
		if (pacienteBuscado == null) {
			model.put("error", "No existe el paciente");
			return new ModelAndView("egresarPaciente", model);
		}
		
		Asignacion asignacionBuscada = servicioAsignacion.consultarAsignacionPacienteInternado(pacienteBuscado);	
		
		if (asignacionBuscada == null) {
			model.put("error", "El paciente no está asignado");
			return new ModelAndView("egresarPaciente", model);
		}	
		
		LocalDateTime dateTimeNow = LocalDateTime.now();
		
		asignacionBuscada.setHoraEgreso(dateTimeNow);
		asignacionBuscada.setMotivoEgreso(motivoEgreso);
		
		servicioAsignacion.actualizarAsignacion(asignacionBuscada);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = asignacionBuscada.getHoraIngreso();
		String horaIngreso = dateTime.format(formatter);
		String horaEgreso = dateTimeNow.format(formatter);
		
		model.put("paciente", pacienteBuscado);
		model.put("horaIngreso", horaIngreso);
		model.put("horaEgreso", horaEgreso);
		model.put("asignacion", asignacionBuscada);
        
        return new ModelAndView("detalleEgreso", model);
    }
	
}