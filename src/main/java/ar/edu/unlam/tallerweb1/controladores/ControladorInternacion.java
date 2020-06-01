package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;

@Controller
public class ControladorInternacion {

	@Autowired
	private ServicioPaciente servicioPaciente;
	@Autowired
	private ServicioInstitucion servicioInstitucion;
	

	@RequestMapping(value = "/internarPaciente", method = RequestMethod.GET)
	public ModelAndView irAinternacion(
			
			@RequestParam(value = "tipoDoc", required = false) TipoDocumento tipoDoc,
			@RequestParam(value = "ndoc", required = false) String ndoc,
			@RequestParam(value = "nCuit", required = false) String nCuit

	)

	{

		Paciente paciente = servicioPaciente.consultarPacientePorDoc(ndoc, tipoDoc);
		Institucion inst = servicioInstitucion.consultarInstitucionPorCuit(nCuit);
		Cama cama = new Cama();
		cama.setPacienteActual(paciente);
		cama.setInstitucion(inst);
		
		
	
		Asignacion internacion = new Asignacion();
		internacion.setCama(cama);
		internacion.setPaciente(paciente);
		
		//internacion.setHoraIngreso(horaIngreso);
		

		ModelMap model = new ModelMap();
		model.put("paciente", paciente);
		model.put("institucion", inst);

		return new ModelAndView("internacion", model);
	}

}
