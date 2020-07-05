package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;

@Controller
public class ControladorConsultarAsignacion {

	ServicioPaciente servicioPaciente;
	ServicioAsignacion servicioAsignacion;
	
	@Inject
	public ControladorConsultarAsignacion(ServicioPaciente servicioPaciente, ServicioAsignacion servicioAsignacion){
		this.servicioPaciente = servicioPaciente;
		this.servicioAsignacion = servicioAsignacion;
	}
	
	@RequestMapping("/consultarAsignacion")
	public ModelAndView consultarAsignacion() {

		ModelMap modelo = new ModelMap();

		return new ModelAndView("consultarAsignacion", modelo);
	}
	
	@RequestMapping(path = "/detalleAsignacion", method = RequestMethod.GET)
	public ModelAndView validarAsignacion( 
			
            @RequestParam(value = "numeroDocumento") String numeroDocumento,
			@RequestParam(value = "tipoDocumento", required = false) TipoDocumento tipoDocumento
            ){
		
		ModelMap model = new ModelMap();
		Asignacion asignacionBuscada = new Asignacion();
		
		Paciente pacienteBuscado =  servicioPaciente.consultarPacientePorDoc(numeroDocumento, tipoDocumento);
		
			if (pacienteBuscado != null) {
			
				asignacionBuscada =  servicioAsignacion.consultarAsignacionPacienteInternado(pacienteBuscado);
				
				if (asignacionBuscada != null) {
					
					String apellido = asignacionBuscada.getPaciente().getApellido();
					String nombre = asignacionBuscada.getPaciente().getNombre();
					String numeroDocumento2 = asignacionBuscada.getPaciente().getNumeroDocumento();
					String tipoDocumento2 = asignacionBuscada.getPaciente().getTipoDocumento().name();
					String horaIngreso = asignacionBuscada.getHoraIngreso().toString();
					String cama = asignacionBuscada.getCama().getDescripcion();
					
					model.put("apellido", apellido);
					model.put("nombre", nombre);
					model.put("numeroDocumento", numeroDocumento2);
					model.put("tipoDocumento", tipoDocumento2);
					model.put("horaIngreso", horaIngreso);
					model.put("cama", cama);
					
					return new ModelAndView("detalleAsignacion", model);
				}
				model.put("error", "El paciente no está asignado");
				
				return new ModelAndView("consultarAsignacion", model);
			}
			model.put("error", "No existe el paciente");
			
			return new ModelAndView("consultarAsignacion", model);
	}
	
}