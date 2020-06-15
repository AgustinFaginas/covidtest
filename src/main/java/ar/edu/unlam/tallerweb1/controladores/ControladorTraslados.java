package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;

@Controller
public class ControladorTraslados {
	
	@Autowired
	ServicioAsignacion servicioAsignacion;
	
	@Autowired
	ServicioPaciente servicioPaciente;

}
