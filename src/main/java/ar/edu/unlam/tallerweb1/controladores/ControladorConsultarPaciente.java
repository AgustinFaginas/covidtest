package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;

@Controller
public class ControladorConsultarPaciente {

	ServicioPaciente servicioPaciente;
	
	@Inject
	public ControladorConsultarPaciente(ServicioPaciente servicioPaciente){
		this.servicioPaciente = servicioPaciente;
	}
	
	@RequestMapping("/consultarPaciente")
	public ModelAndView consultarPaciente() {

		ModelMap modelo = new ModelMap();
		
		Paciente paciente = new Paciente();
		modelo.put("paciente", paciente);

		return new ModelAndView("consultarPaciente", modelo);
	}
	
	@RequestMapping(path = "/detallePaciente", method = RequestMethod.POST)
	public ModelAndView validarConsulta(@ModelAttribute("paciente") Paciente paciente, HttpServletRequest request) {
		
		ModelMap model = new ModelMap();
		
		paciente =  servicioPaciente.consultarPacientePorDoc(paciente.getNumeroDocumento(), paciente.getTipoDocumento());
		
			if (paciente != null) {
				
				String mensaje = "Nombre: " + paciente.getNombre();
				String mensaje2 = "Apellido: " + paciente.getApellido();
				String mensaje3 = "Documento: (" + paciente.getTipoDocumento()+ ") " + paciente.getNumeroDocumento();
				String mensaje4 = "Email: " + paciente.getEmail();
				
				model.put("mensaje", mensaje);
				model.put("mensaje2", mensaje2);
				model.put("mensaje3", mensaje3);
				model.put("mensaje4", mensaje4);
				
				return new ModelAndView("detallePaciente", model);
			}

			model.put("error", "No existe el paciente");
			
			return new ModelAndView("consultarPaciente", model);
	}

}