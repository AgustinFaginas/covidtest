package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.servicios.ServicioAtajo;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;

@Controller
public class ControladorMapa {

	@Autowired
	ServicioAtajo servicioAtajo;
	@Autowired
	ServicioPaciente servicioPaciente;

	@RequestMapping("/mapaPaciente")
	public ModelAndView mapaPaciente(HttpServletRequest request) {
		ModelMap model = new ModelMap();

		if (servicioAtajo.validarInicioDeSesion(request) != null) {
			return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
		}
		if (servicioAtajo.validarPermisoAPagina(request) != null) {
			return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
		}
		Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if (rol != null) {
			model.put("rol", rol.name());
		}
		model.put("armarHeader", servicioAtajo.armarHeader(request));

		return new ModelAndView("mapaPaciente", model);
	}

	@RequestMapping("/validarMapa")
	public ModelAndView validarMapa(HttpServletRequest request, @RequestParam(value = "latitud") Float latitud,
			@RequestParam(value = "longitud") Float longitud) {
		ModelMap model = new ModelMap();

		if (servicioAtajo.validarInicioDeSesion(request) != null) {
			return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
		}
		if (servicioAtajo.validarPermisoAPagina(request) != null) {
			return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
		}
		Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if (rol != null) {
			model.put("rol", rol.name());
		}
		model.put("armarHeader", servicioAtajo.armarHeader(request));

		Long id = (Long) request.getSession().getAttribute("ID");
		Paciente paciente = servicioPaciente.consultarPacientePorId(id);

		paciente.setLatitud(latitud);
		paciente.setLongitud(longitud);

		servicioPaciente.actualizarPaciente(paciente);

		model.put("latitud", latitud);
		model.put("longitud", longitud);

		return new ModelAndView("validarMapa", model);
	}

}
