package ar.edu.unlam.tallerweb1.controladores;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.MotivoTraslado;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;

@Controller
public class ControladorTraslados {

	@Autowired
	ServicioAsignacion servicioAsignacion;

	@Autowired
	ServicioPaciente servicioPaciente;
	
	@Autowired
	ServicioCama servicioCama;

	 @RequestMapping("/trasladarPacienteCama")
	    public ModelAndView trasladarPacienteCama() {

	        List<Cama> listaCamas = servicioCama.camas();
	        
	        ModelMap model = new ModelMap();
	        model.put("camas", listaCamas);

	        return new ModelAndView("trasladarPacienteCama", model);
	    }
	
	 @RequestMapping(path = "/detalleTraslado")
		public ModelAndView traslado(
				
				@RequestParam(value = "numeroDocumento") String numeroDocumento,
				@RequestParam(value = "tipoDocumento", required = false) TipoDocumento tipoDocumento,
				@RequestParam(value = "motivoTraslado", required = false) MotivoTraslado motivoTraslado,
				@RequestParam(value = "selectCama", required = false) Long idCama
				) {
			
			ModelMap model = new ModelMap();
			
			Asignacion asignacionBuscada = new Asignacion();
			
			Paciente pacienteBuscado =  servicioPaciente.consultarPacientePorDoc(numeroDocumento, tipoDocumento);
			Cama camaSeleccionada = servicioCama.consultarCamaPorId(idCama);
			if (pacienteBuscado != null) {
			
				asignacionBuscada = servicioAsignacion.consultarAsignacionPacienteInternado(pacienteBuscado);
			
				if (asignacionBuscada != null) {
					
					LocalDateTime horaTraslado = LocalDateTime.now();
					
					asignacionBuscada.setHoraTraslado(horaTraslado);
					asignacionBuscada.setMotivoTraslado(motivoTraslado);
					asignacionBuscada.setCama(camaSeleccionada);
					
					servicioAsignacion.actualizarAsignacion(asignacionBuscada);
					
					String mensaje = "Nombre del paciente: " + asignacionBuscada.getPaciente().getNombre() + " " 
															 + asignacionBuscada.getPaciente().getApellido();
					String mensaje2 = "Cama asignada: " + asignacionBuscada.getCama().getId();//asignacionBuscada.getCama().getDescripcion();
					
					String mensaje4 = "Hora de traslado: " + asignacionBuscada.getHoraTraslado();
					String mensaje5 = "Motivo de Traslado: " + asignacionBuscada.getMotivoTraslado();
					
					model.put("mensaje", mensaje);
					model.put("mensaje2", mensaje2);
				
					model.put("mensaje4", mensaje4);
					model.put("mensaje5", mensaje5);
					
					model.put("trasladoExitoso", "El paciente fue trasladado");

					return new ModelAndView("detalleTraslado", model);
				} 
				else {
					model.put("error", "El paciente no está asignado");
					
					return new ModelAndView("trasladarPacienteCama", model);
				}
			}	
			
			else {
				model.put("error", "No existe el paciente");
				
				return new ModelAndView("trasladarPacienteCama", model);
			}
		}
}
