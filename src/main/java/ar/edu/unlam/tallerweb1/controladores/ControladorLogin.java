package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
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

	// La anotacion @Autowired indica a Spring que se debe utilizar el contructor
	// como mecanismo de inyección de dependencias,
	// es decir, qeue lo parametros del mismo deben ser un bean de spring y el
	// framewrok automaticamente pasa como parametro
	// el bean correspondiente, en este caso, un objeto de una clase que implemente
	// la interface ServicioLogin,
	// dicha clase debe estar anotada como @Service o @Repository y debe estar en un
	// paquete de los indicados en
	// applicationContext.xml
	private ServicioLogin servicioLogin;

	public ServicioLogin getServicioLogin() {
		return servicioLogin;
	}

	public void setServicioLogin(ServicioLogin servicioLogin) {
		this.servicioLogin = servicioLogin;
	}

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin) {
		this.servicioLogin = servicioLogin;
	}

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es
	// invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin(HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		if (request.getSession().getAttribute("ID") != null) {
//			modelo.put("alert", "Ya se encuentra logueado con una cuenta, primero cierre sesion.");
			return new ModelAndView("error_login", modelo);
		}
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);

		return new ModelAndView("login", modelo);
	}

	
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		
		if (usuarioBuscado == null) {
			model.put("error", "Usuario o clave incorrecta");
			return new ModelAndView("login", model);
		}
		
		if (usuarioBuscado != null && usuarioBuscado.getRol() == Rol.INSTITUCION) {
			request.getSession().setAttribute("ID", usuarioBuscado.getId());
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			return new ModelAndView("redirect:/bienvenido");

		} 
		
		if (usuarioBuscado !=null && usuarioBuscado.getRol() == Rol.ADMIN ) {
			request.getSession().setAttribute("ID", usuarioBuscado.getId());
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			return new ModelAndView("redirect:/admin");
		}
		else {

			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}

	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la
	// url /login directamente.
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
