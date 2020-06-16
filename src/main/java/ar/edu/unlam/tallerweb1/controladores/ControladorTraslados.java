package ar.edu.unlam.tallerweb1.controladores;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.MotivoTraslado;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;

@Controller
public class ControladorTraslados {

	@Autowired
	ServicioAsignacion servicioAsignacion;

	@Autowired
	ServicioPaciente servicioPaciente;

	@RequestMapping("/trasladoPacienteCama")
	public ModelAndView egresarPaciente() {

		ModelMap modelo = new ModelMap();

		return new ModelAndView("trasladoCamaPaciente", modelo);
	}

	@RequestMapping(path = "/trasladoValido")
	public ModelAndView egresoValido(

			@RequestParam(value = "numeroDocumento") String numeroDocumento,
			@RequestParam(value = "tipoDocumento", required = false) TipoDocumento tipoDocumento,
			@RequestParam(value = "motivoTraslado", required = false) MotivoTraslado motivoTraslado) {

		ModelMap model = new ModelMap();

		Asignacion asignacionBuscada = new Asignacion();


		return new ModelAndView("trasladoCamaPaciente", model);
	}

}
