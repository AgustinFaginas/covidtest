package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Notificacion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Rol;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioNotificacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorAdmin {


	@Autowired
	private ServicioUsuario servicioUsuario;
	@Autowired
	private ServicioPaciente servicioPaciente;
	@Autowired
	private ServicioNotificacion servicioNotificacion;
	
	
	@RequestMapping("admin")
	public ModelAndView irAadmin (HttpServletRequest request) {

		ModelMap model = new ModelMap();
		if (request.getSession().getAttribute("ID") == null) {
			return new ModelAndView("redirect:/home");
		}

		
		if (request.getSession().getAttribute("ROL") == Rol.INSTITUCION) {
			return new ModelAndView("redirect:/denied");
		}
			
			Long id = (Long) request.getSession().getAttribute("ID");
			Usuario admin = servicioUsuario.consultarUsuarioPorId(id);
			
			String nombre = admin.getNombre();
			
			
			model.put("nombre", nombre);
			

			return new ModelAndView("admin", model);
			
			
	}
	
	@RequestMapping("inicioAdmin")
	public ModelAndView irAhomeAdmin(HttpServletRequest request) {
		
		if (request.getSession().getAttribute("ID") == null) {
			return new ModelAndView("redirect:/home");
		}
		
		if (request.getSession().getAttribute("ROL") == Rol.INSTITUCION) {
			return new ModelAndView("redirect:/denied");
		}
		
		return new ModelAndView("homeAdmin");
		
	}
	
	

	@RequestMapping(value ="crearMensaje" , method=RequestMethod.POST)
	public ModelAndView crearMensaje( @RequestParam(value = "id", required = false) Long id
			,HttpServletRequest request) {

		Paciente p = servicioPaciente.consultarPacientePorId(id);
		Long idEmisor = (Long) request.getSession().getAttribute("ID");
		
		
		ModelMap model = new ModelMap();
		
		model.put("id", idEmisor);
		model.put("p", p);
		
		return new ModelAndView("crearMensaje",model);


	}
	
	@RequestMapping(value = "enviarMensaje", method = RequestMethod.POST)
	public ModelAndView enviarMensaje(@RequestParam(value = "idEmisor", required = false) Long idEmisor,
			@RequestParam(value = "idReceptor", required = false) Long idReceptor,
			@RequestParam(value = "mensaje", required = false) String mensaje) {

		Usuario destinatario = servicioUsuario.consultarUsuarioPorId(idReceptor);
		Usuario remitente = servicioUsuario.consultarUsuarioPorId(idEmisor);

		Notificacion notificacionNueva = new Notificacion();

		notificacionNueva.setDestinatario(destinatario);
		notificacionNueva.setRemitente(remitente);
		notificacionNueva.setMsg(mensaje);

		servicioNotificacion.registrarNotificacion(notificacionNueva);

		return new ModelAndView("home");

	}
	
	
	
	
	@RequestMapping("/panel")
	public ModelAndView irApanel(HttpServletRequest request) {

		ModelMap model = new ModelMap();
		if (request.getSession().getAttribute("ID") == null) {
			return new ModelAndView("redirect:/home");
		}

		if (request.getSession().getAttribute("ROL") == Rol.INSTITUCION) {
			return new ModelAndView("redirect:/denied");
		}

		List<Paciente> poInfectados = servicioPaciente.posiblesInfectados();

		model.put("poInfectados", poInfectados);

		return new ModelAndView("panel", model);

	}
	
	//PAGINA DE ACCESO DENEGADO POR DEFAULT
	@RequestMapping(path = "/denied", method = RequestMethod.GET)
	public ModelAndView denied() {
		return new ModelAndView("denied");
	}

}
