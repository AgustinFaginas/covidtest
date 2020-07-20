package ar.edu.unlam.tallerweb1.controladores;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Notificacion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Rol;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAtajo;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioNotificacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorNotificacion {

	@Autowired
	private ServicioUsuario servicioUsuario;
	@Autowired
	private ServicioPaciente servicioPaciente;
	@Autowired
	private ServicioNotificacion servicioNotificacion;
	@Autowired
	private ServicioInstitucion servicioInstitucion;
	@Autowired
	private ServicioAtajo servicioAtajo;	

	@RequestMapping(value ="crearMensaje" , method=RequestMethod.POST)
	public ModelAndView crearMensaje( 
			
		@RequestParam(value = "id", required = false) Long id,
		HttpServletRequest request) {

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

		Paciente p = servicioPaciente.consultarPacientePorId(id);
		Long idEmisor = (Long) request.getSession().getAttribute("ID");
		
		model.put("id", idEmisor);
		model.put("p", p);
		
		return new ModelAndView("crearMensaje",model);
	}
	
	@RequestMapping(value ="crearMensajeParaInstitucion" , method=RequestMethod.POST)
	public ModelAndView crearMensajeParaInstitucion( 
			
		@RequestParam(value = "id", required = false) Long id,
		HttpServletRequest request) {
		
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
			
		Institucion p = servicioInstitucion.obtenerInstitucionPorId(id);
		Long idEmisor = (Long) request.getSession().getAttribute("ID");
		
		model.put("id", idEmisor);
		model.put("p", p);
		
		return new ModelAndView("crearMensaje",model);
	}
	
	@RequestMapping(value = "enviarMensaje", method = RequestMethod.POST)
	public ModelAndView enviarMensaje(
			
			@RequestParam(value = "idEmisor", required = false) Long idEmisor,
			@RequestParam(value = "idReceptor", required = false) Long idReceptor,
			@RequestParam(value = "mensaje", required = false) String mensaje, HttpServletRequest request) {

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

		Usuario destinatario = servicioUsuario.consultarUsuarioPorId(idReceptor);
		Usuario remitente = servicioUsuario.consultarUsuarioPorId(idEmisor);

		Notificacion notificacionNueva = new Notificacion();

		notificacionNueva.setDestinatario(destinatario);
		notificacionNueva.setRemitente(remitente);
		notificacionNueva.setMsg(mensaje);
		notificacionNueva.setFechaHora(LocalDateTime.now());

		servicioNotificacion.registrarNotificacion(notificacionNueva);
		
		if (request.getSession().getAttribute("ROL") == Rol.ADMIN) {
			return new ModelAndView("redirect:/panel");

		}
		
		return new ModelAndView("redirect:/bienvenido");
	}

	@RequestMapping(path = "/verMensajes", method = RequestMethod.GET)
	public ModelAndView verMensajes(
			
			HttpServletRequest request) {

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
		
		Usuario usuario = servicioUsuario.consultarUsuarioPorId(id);
		
		List<Notificacion> list = servicioNotificacion.buscarNotificacionPorId(usuario);
		
		model.put("list", list);
		
		return new ModelAndView("verMensajes", model);
	}
	
}
