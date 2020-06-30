package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Rol;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorAdmin {


	@Autowired
	private ServicioUsuario servicioUsuario;
	
	
	@RequestMapping("admin")
	public ModelAndView irAadmin (HttpServletRequest request) {

		ModelMap model = new ModelMap();
		if (request.getSession().getAttribute("ID") == null) {
			return new ModelAndView("redirect:/home");
		}

		
			
			
			Long id = (Long) request.getSession().getAttribute("ID");
			Usuario admin = servicioUsuario.consultarUsuarioPorId(id);
			
			String nombre = admin.getNombre();
			
			
			model.put("nombre", nombre);
			

			return new ModelAndView("admin", model);
			
			
	}

	@RequestMapping(path = "/denied", method = RequestMethod.GET)
	public ModelAndView irApanel() {
		return new ModelAndView("denied");
	}

}
