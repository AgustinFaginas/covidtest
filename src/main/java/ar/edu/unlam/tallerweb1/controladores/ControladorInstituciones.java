package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistro;

@Controller
public class ControladorInstituciones {

	@Autowired
	private ServicioRegistro servicioRegistro;
	
	//private ServicioInstitucion servicioInstitucion;

	@RequestMapping(value = "/detalle", method = RequestMethod.GET)
	public ModelAndView detalle(@RequestParam(value = "nombre", required = false) String nombre) {
		String message = "Detalle de: " + nombre;

		ModelMap model = new ModelMap();

		model.put("msg", message);
		return new ModelAndView("vistaDetalle", model);
	}

	@RequestMapping("/registroinstitucion")
	public ModelAndView registrarPaciente(

			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "password", required = false) String password

	) {
		Institucion institucion = new Institucion();

		institucion.setNombre(nombre);
		institucion.setEmail(email);
		institucion.setPassword(password);

		try {
			servicioRegistro.registrarInstitucion(institucion);
		} catch (Exception e) {

			e.printStackTrace();
		}

		String message = "Nombre: " + nombre;
		String message2 = "Email: " + email;

		ModelMap model = new ModelMap();
		model.put("msg", message);
		model.put("msg2", message2);

		return new ModelAndView("registroinstitucion", model);
	}

}
