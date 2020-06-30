package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorInstitucion {

	private ServicioInstitucion servicioInstitucion;
	private ServicioCama servicioCama;
	private ServicioUsuario servicioUsuario;
	private ServicioPaciente servicioPaciente;
	private ServicioLogin servicioLogin;

	@Autowired
	public ControladorInstitucion(ServicioInstitucion servicioInstitucion, ServicioCama servicioCama,
			ServicioPaciente servicioPaciente, ServicioUsuario servicioUsuario) {
		this.servicioInstitucion = servicioInstitucion;
		this.servicioCama = servicioCama;
		this.servicioUsuario = servicioUsuario;
	}

	@RequestMapping("/registrarInstitucion")
	public ModelAndView registrarInstitucion() {

		ModelMap modelo = new ModelMap();

		return new ModelAndView("registrarInstitucion", modelo);
	}

	@RequestMapping("/detalleRegistroInstitucion")
	public ModelAndView validarRegistroInstitucion(

			@ModelAttribute("usuario") Institucion institucion, HttpServletRequest request

	) {

		institucion.setTipoDocumento(TipoDocumento.CUIT);

		ModelMap model = new ModelMap();

		if (servicioUsuario.consultarUsuarioPorEmail(institucion.getEmail()) == null
				&& servicioInstitucion.consultarInstitucionPorCuit(institucion.getNumeroDocumento()) == null) {

			institucion.setRol(Rol.INSTITUCION);

			servicioInstitucion.registrarInstitucion(institucion);

			request.getSession().setAttribute("ID", institucion.getId());
			request.getSession().setAttribute("ROL", institucion.getRol());

			for (int i = 0; i < institucion.getCantidadCamas().intValue(); i++) {

				Cama cama = new Cama();
				cama.setInstitucion(institucion);

				int numeroCama = i + 1;
				String descripcion = "" + numeroCama;
				cama.setDescripcion(descripcion);

				servicioCama.registrarCama(cama);
			}

			String mensaje = "Nombre: " + institucion.getNombre();
			String mensaje2 = "Documento: (" + institucion.getTipoDocumento() + ") " + institucion.getNumeroDocumento();
			String mensaje3 = "Email: " + institucion.getEmail();

			model.put("mensaje", mensaje);
			model.put("mensaje2", mensaje2);
			model.put("mensaje3", mensaje3);

			return new ModelAndView("detalleRegistroInstitucion", model);
		} else {

			model.put("error", "Ya existe un usuario registrado con su mail o cuit");

			return new ModelAndView("registrarInstitucion", model);
		}
	}

	@RequestMapping("/listaInstituciones")
	public ModelAndView listarInstituciones() {

		List<Institucion> listaInstituciones = servicioInstitucion.obtenerListaInstituciones();

		ModelMap model = new ModelMap();
		model.put("listaInstituciones", listaInstituciones);

		return new ModelAndView("listaInstituciones", model);
	}

	
	@RequestMapping("bienvenido")
	public ModelAndView irAbienvenido(HttpServletRequest request) {
		
		ModelMap model = new ModelMap();

		if (request.getSession().getAttribute("ID") == null || request.getSession().getAttribute("ROL")!=Rol.INSTITUCION) {
			return new ModelAndView("redirect:/home");
		} 
		
			Long id = (Long) request.getSession().getAttribute("ID");
			Institucion institucion = servicioInstitucion.obtenerInstitucionPorId(id);
			
			String nombre = institucion.getNombre();
			Integer camas = institucion.getCantidadCamas();
			
			model.put("nombre", nombre);
			model.put("camas", camas);

			return new ModelAndView("bienvenido", model);
		
	}


	
	@RequestMapping(path = "/Panel", method = RequestMethod.GET)
	public ModelAndView irApanel() {
		return new ModelAndView("panel");
	}

}
