package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAtajo;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorLogin {

	
	private ServicioLogin servicioLogin;
	private ServicioAtajo servicioAtajo;

	public ServicioLogin getServicioLogin() {
		return servicioLogin;
	}

	public void setServicioLogin(ServicioLogin servicioLogin, ServicioAtajo servicioAtajo) {
		this.servicioLogin = servicioLogin;
		this.servicioAtajo = servicioAtajo;
	}

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin, ServicioAtajo servicioAtajo) {
		this.servicioLogin = servicioLogin;
		this.servicioAtajo = servicioAtajo;
	}

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es
	// invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin(HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		if (request.getSession().getAttribute("ID") != null) {
			return new ModelAndView("redirect:/error_login");
		}
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);

		return new ModelAndView("login", modelo);
	}
	
	@RequestMapping("/error_login")
	public ModelAndView errorLogin(HttpServletRequest request) {

		ModelMap model = new ModelMap();
		
    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
		
    	return new ModelAndView("error_login", model);
	}
	
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		
		ModelMap model = new ModelMap();

		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		
		if (usuarioBuscado == null) {
			model.put("error", "Usuario o clave incorrecta");
			return new ModelAndView("login", model);
		}
		
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
		
		if (usuarioBuscado.getRol() == Rol.INSTITUCION) {
			request.getSession().setAttribute("ID", usuarioBuscado.getId());
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			return new ModelAndView("redirect:/bienvenido");
		} 
		
		if (usuarioBuscado.getRol() == Rol.ADMIN ) {
			request.getSession().setAttribute("ID", usuarioBuscado.getId());
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			return new ModelAndView("redirect:/admin");
		}
		
		if (usuarioBuscado.getRol() == Rol.PACIENTE ) {
			request.getSession().setAttribute("ID", usuarioBuscado.getId());
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			return new ModelAndView("redirect:/bienvenidoPaciente");
		}

		return new ModelAndView("login", model);
	}

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome(HttpServletRequest request ) {
		
    	ModelMap model = new ModelMap();

    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
   
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
		return new ModelAndView("home", model);
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("login");
	}

	@RequestMapping(path = "/logout")
	public ModelAndView logout(@RequestParam(value = "redirect", defaultValue = "") String redirect,
			HttpServletRequest request) {
		request.getSession().removeAttribute("ID");
		request.getSession().removeAttribute("ROL");
		
		return new ModelAndView("redirect:/home");
	}
}
