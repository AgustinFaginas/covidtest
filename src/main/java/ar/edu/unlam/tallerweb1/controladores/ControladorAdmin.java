package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAtajo;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorAdmin {

	@Autowired
	private ServicioUsuario servicioUsuario;
	@Autowired
	private ServicioPaciente servicioPaciente;
	@Autowired
	private ServicioAtajo servicioAtajo;	
	
	@RequestMapping("admin")
	public ModelAndView irAadmin (HttpServletRequest request) {

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

    	Long id = (long) request.getSession().getAttribute("ID"); 
		Usuario admin = servicioUsuario.consultarUsuarioPorId(id);
		
		String nombre = admin.getNombre();
		
		model.put("nombre", nombre);

		return new ModelAndView("admin", model);
	}
	
	@RequestMapping("homeAdmin")
	public ModelAndView irAhomeAdmin(HttpServletRequest request) {
		
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
			
		return new ModelAndView("homeAdmin", model);
		
	}

	@RequestMapping("/panel")
	public ModelAndView irApanel(HttpServletRequest request) {

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

		List<Paciente> poInfectados = servicioPaciente.posiblesInfectados();

		model.put("poInfectados", poInfectados);

		return new ModelAndView("panel", model);

	}

	//PAGINA DE ACCESO DENEGADO POR DEFAULT
	@RequestMapping(path = "/denied", method = RequestMethod.GET)
	public ModelAndView denied(
			
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

		return new ModelAndView("denied", model);
	}
	
	//PAGINA DE ACCESO DENEGADO POR DEFAULT
	@RequestMapping("/acordeon")
	public ModelAndView acordeon(
			
			HttpServletRequest request) {
		
		ModelMap model = new ModelMap();

    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));

		return new ModelAndView("acordeon", model);
	}

}
