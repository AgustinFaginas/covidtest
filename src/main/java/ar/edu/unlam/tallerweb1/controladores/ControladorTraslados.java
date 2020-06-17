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

	 @RequestMapping("/trasladoCama")
	    public ModelAndView selectCamas() {

	        List<Cama> camas = servicioCama.camas();
	        
	        ModelMap model = new ModelMap();

	        model.put("camas", camas);

	        return new ModelAndView("trasladoCamaPaciente", model);
	    }
	
	

	@RequestMapping(path = "/trasladoValido")
	public ModelAndView egresoValido(

			@RequestParam(value = "numeroDocumento") String numeroDocumento,
			@RequestParam(value = "tipoDocumento", required = false) TipoDocumento tipoDocumento,
			@RequestParam(value = "idcama", required = false) Long idcama,
			@RequestParam(value = "motivoTraslado", required = false) MotivoTraslado motivoTraslado) {

		ModelMap model = new ModelMap();

		Asignacion asignacionBuscada = new Asignacion();

			
		if (asignacionBuscada != null) {
			
			asignacionBuscada.getPaciente();
			asignacionBuscada.getCama().getId();
			
			String mensaje = "Nombre del paciente: " + asignacionBuscada.getPaciente().getNombre() + " " 
													 + asignacionBuscada.getPaciente().getApellido();
			String mensaje2 = "Cama asignada: " + asignacionBuscada.getCama().getDescripcion();
			String mensaje3 = "Hora de internación: " + asignacionBuscada.getHoraIngreso();
			String mensaje4 = "Hora de internación: " + asignacionBuscada.getHoraEgreso();
			String mensaje5 = "Hora de internación: " + asignacionBuscada.getMotivoEgreso();
			
			model.put("mensaje", mensaje);
			model.put("mensaje2", mensaje2);
			model.put("mensaje3", mensaje3);
			model.put("mensaje4", mensaje4);
			model.put("mensaje5", mensaje5);
			
			model.put("egresoValido", "El paciente fue egresado");

			return new ModelAndView("trasladoValido", model);
		} 
		return new ModelAndView("trasladoCamaPaciente", model);
	}

}
