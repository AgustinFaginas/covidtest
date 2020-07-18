package ar.edu.unlam.tallerweb1.controladores;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import ar.edu.unlam.tallerweb1.modelo.MotivoEgreso;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioAtajo;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import ar.edu.unlam.tallerweb1.servicios.ServicioInternacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;

@Controller
public class ControladorEgresarPaciente {

	private ServicioAsignacion servicioAsignacion;
	private ServicioPaciente servicioPaciente;
	private ServicioCama servicioCama;
	private ServicioInternacion servicioInternacion;
	private ServicioAtajo servicioAtajo;

	@Autowired
	public ControladorEgresarPaciente(ServicioAsignacion servicioAsignacion, ServicioPaciente servicioPaciente, 
									  ServicioCama servicioCama, ServicioInternacion servicioInternacion, ServicioAtajo servicioAtajo) {
		this.servicioAsignacion = servicioAsignacion;
		this.servicioPaciente = servicioPaciente;
		this.servicioCama = servicioCama;
		this.servicioInternacion = servicioInternacion;
		this.servicioAtajo = servicioAtajo;
	}
	
	public ServicioAsignacion getServicioAsignacion() {
		return servicioAsignacion;
	}

	public void setServicioAsignacion(ServicioAsignacion servicioAsignacion) {
		this.servicioAsignacion = servicioAsignacion;
	}

	public ServicioPaciente getServicioPaciente() {
		return servicioPaciente;
	}

	public void setServicioPaciente(ServicioPaciente servicioPaciente) {
		this.servicioPaciente = servicioPaciente;
	}

	@RequestMapping("/egresarPaciente")
	public ModelAndView egresarPaciente() {
		return new ModelAndView("egresarPaciente");
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