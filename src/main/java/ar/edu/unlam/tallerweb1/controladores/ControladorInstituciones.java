package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistro;

@Controller
public class ControladorInstituciones {

	@Autowired
	private ServicioInstitucion servicioInstitucion;

	@RequestMapping(value = "/detalle", method = RequestMethod.GET)
	public ModelAndView detalle(@RequestParam(value = "nombre", required = false) String nombre) {
		String message = "Detalle de: " + nombre;

		ModelMap model = new ModelMap();

		model.put("msg", message);
		return new ModelAndView("vistaDetalle", model);
	}

	@RequestMapping(value = "/registroinstitucion", method = RequestMethod.GET)
	public ModelAndView registrarInstitucion(@RequestParam(value = "nombre", required = false) String nombre,

			@RequestParam(value = "email", required = false) String email,

			@RequestParam(value = "password", required = false) String password) throws Exception {

		Institucion institucion = new Institucion();

		institucion.setNombre(nombre);
		institucion.setEmail(email);
		institucion.setPassword(password);

		Long idInstitucion = servicioInstitucion.guardarInstitucion(institucion);

		ModelMap model = new ModelMap();

		model.put("id", idInstitucion);
		model.put("nombre", nombre);
		model.put("email", email);

		return new ModelAndView("registroinstitucion", model);

	}

	/*
	 * @RequestMapping("/registroinstitucion") public ModelAndView
	 * registrarInstitucion(
	 * 
	 * @RequestParam(value = "nombre", required = false) String nombre,
	 * 
	 * @RequestParam(value = "email", required = false) String email,
	 * 
	 * @RequestParam(value = "password", required = false) String password
	 * 
	 * ) {
	 * 
	 * Institucion institucion = new Institucion();
	 * 
	 * institucion.setNombre(nombre); institucion.setEmail(email);
	 * institucion.setPassword(password);
	 * 
	 * try { servicioRegistro.registrarPaciente(institucion); } catch (Exception e)
	 * {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * String message = "El nombre de la institucion es: " + nombre; String message2
	 * = "El email ingresado es: " + email;
	 * 
	 * ModelMap model = new ModelMap(); model.put("msg", message); model.put("msg3",
	 * message2);
	 * 
	 * return new ModelAndView("registrarinstitucion", model);
	 * 
	 * }
	 */

	@RequestMapping(value = "/consultarinstitucionporid", method = RequestMethod.GET)
	public ModelAndView consultarInstitucionPorId(@RequestParam(value = "id") Long id) {

		ModelMap model = new ModelMap();

		Institucion institucionEncontrada = servicioInstitucion.consultarInstitucionPorId(id);

		model.put("institucion", institucionEncontrada);

		if (institucionEncontrada == null) {
			return new ModelAndView("errorconsultarinstitucion");
		} else {
			return new ModelAndView("consultarinstitucion", model);
		}

	}

}
