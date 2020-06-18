package ar.edu.unlam.tallerweb1.controladores;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.MotivoEgreso;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;

@Controller
public class ControladorEgresarPaciente {

	@Autowired
	ServicioAsignacion servicioAsignacion;
	
	@Autowired
	ServicioPaciente servicioPaciente;

	@RequestMapping("/egresarPaciente")
	public ModelAndView egresarPaciente() {

		ModelMap modelo = new ModelMap();

		return new ModelAndView("egresarPaciente", modelo);
	}
	
	@RequestMapping(path = "/egresoValido")
	public ModelAndView egresoValido(
			
			@RequestParam(value = "numeroDocumento") String numeroDocumento,
			@RequestParam(value = "tipoDocumento", required = false) TipoDocumento tipoDocumento,
			@RequestParam(value = "motivoEgreso", required = false) MotivoEgreso motivoEgreso
			) {
		
		ModelMap model = new ModelMap();
		
		Asignacion asignacionBuscada = new Asignacion();
		
		Paciente pacienteBuscado =  servicioPaciente.consultarPacientePorDoc(numeroDocumento, tipoDocumento);
		
		if (pacienteBuscado != null) {
		
			asignacionBuscada = servicioAsignacion.consultarAsignacionPacienteInternado(pacienteBuscado);
		
			if (asignacionBuscada != null) {
				
				LocalDateTime horaEgreso = LocalDateTime.now();
				
				asignacionBuscada.setHoraEgreso(horaEgreso );
				asignacionBuscada.setMotivoEgreso(motivoEgreso);
				
				servicioAsignacion.actualizarAsignacion(asignacionBuscada);
				
				String mensaje = "Nombre del paciente: " + asignacionBuscada.getPaciente().getNombre() + " " 
														 + asignacionBuscada.getPaciente().getApellido();
				String mensaje2 = "Cama asignada: " + asignacionBuscada.getCama().getDescripcion();
				String mensaje3 = "Hora de internación: " + asignacionBuscada.getHoraIngreso();
				String mensaje4 = "Hora de egreso: " + asignacionBuscada.getHoraEgreso();
				String mensaje5 = "Motivo de egreso: " + asignacionBuscada.getMotivoEgreso();
				
				model.put("mensaje", mensaje);
				model.put("mensaje2", mensaje2);
				model.put("mensaje3", mensaje3);
				model.put("mensaje4", mensaje4);
				model.put("mensaje5", mensaje5);
				
				model.put("egresoValido", "El paciente fue egresado");

				return new ModelAndView("egresoValido", model);
			} 
			else {
				model.put("error", "El paciente no está asignado");
				
				return new ModelAndView("egresarPaciente", model);
			}
		}	
		
		else {
			model.put("error", "No existe el paciente");
			
			return new ModelAndView("egresarPaciente", model);
		}
	}

}