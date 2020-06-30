package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Rol;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorAdmin {

	private ServicioUsuario servicioUsuario;

	@RequestMapping("admin")
	public ModelAndView irAadmin (HttpServletRequest request) {

		ModelMap model = new ModelMap();
		if (request.getSession().getAttribute("ID") == null) {
			return new ModelAndView("redirect:/home");
		}

		if (request.getSession().getAttribute("ROL") == Rol.ADMIN) {
			Long id = (Long) request.getSession().getAttribute("ID");
			Usuario admin = servicioUsuario.consultarUsuarioPorId(id);

			String rol = admin.getRol().toString();
			
			model.put("rol", rol);

			return new ModelAndView("admin", model);

		} 
			return new ModelAndView("redirect:/denied");

		

	}

	@RequestMapping(path = "/denied", method = RequestMethod.GET)
	public ModelAndView irApanel() {
		return new ModelAndView("denied");
	}

}
