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
import ar.edu.unlam.tallerweb1.servicios.ServicioMapa;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;

@Controller
public class ControladorMapa {

	@Autowired
	ServicioAtajo servicioAtajo;
	@Autowired
	ServicioPaciente servicioPaciente;
	@Autowired
	ServicioMapa servicioMapa;

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
	public ModelAndView validarMapa(HttpServletRequest request, @RequestParam(value = "latitud") Double latitud,
			@RequestParam(value = "longitud") Double longitud) {
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

	@RequestMapping("/calcularDistanciaEntreDosPuntos")
	public ModelAndView calcularDistanciaEntreDosPuntos(HttpServletRequest request) {
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

		Double latitud1 = -34.70211051937402;
		Double longitud1 = -58.573554607284514;
		Double latitud2 = -34.72840647959868;
		Double longitud2 = -58.61369019379556;

		Double distancia = servicioMapa.calcularDistanticiaEntreDosPuntos(latitud1, longitud1, latitud2, longitud2);

		model.put("distancia", distancia);

		return new ModelAndView("calcularDistanciaEntreDosPuntos", model);
	}

}
