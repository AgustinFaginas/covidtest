package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorPaciente {

    @Autowired
    ServicioPaciente servicioPaciente;

    @RequestMapping("/listaPacientes")
    public ModelAndView pacientes() {

        List<Paciente> pacientes = servicioPaciente.pacientes();

        ModelMap model = new ModelMap();

        model.put("listaPacientes", pacientes);

        return new ModelAndView("listaPacientes", model);
    }

    @RequestMapping("/grafico-pacientes")
    public ModelAndView graficoPacientes() {

        Integer cantidadPacientes = servicioPaciente.pacientes().size();
        Integer cantidadPacientesInfectados = servicioPaciente.pacientesInfectados().size();
        Integer cantidadPacientesNoInfectados = cantidadPacientes - cantidadPacientesInfectados;

        ModelMap model = new ModelMap();

        model.put("cantidadPacientes", cantidadPacientes);
        model.put("cantidadPacientesInfectados", cantidadPacientesInfectados);
        model.put("cantidadPacientesNoInfectados", cantidadPacientesNoInfectados);


        return new ModelAndView("grafico-pacientes", model);
    }

    @RequestMapping("/mapa-paciente")
    public ModelAndView mapaPaciente() {

        return new ModelAndView("detalleRegistroPaciente");
    }

    @RequestMapping("/posiblesinfectados")
    public ModelAndView posiblesinfectados() {

        List<Paciente> posiblesInfectados = servicioPaciente.posiblesInfectados();

        ModelMap model = new ModelMap();

        model.put("posiblesInfectados", posiblesInfectados);

        return new ModelAndView("posiblesinfectados", model);
    }
    
    @RequestMapping("/listaPacientesInfectados")
    public ModelAndView listaPacientesInfectados(
    	
		HttpServletRequest request
		
    	) {

		ModelMap model = new ModelMap();
		
		if (request.getSession().getAttribute("ID") == null) {
			model.put("error", "Debe iniciar sesión");
	        return new ModelAndView("login", model);
		}
	
		if (request.getSession().getAttribute("ROL") == Rol.PACIENTE) {
			return new ModelAndView("redirect:/denied");
		}
		
		List<Paciente> listaPacientesInfectados = servicioPaciente.pacientesInfectados(); 
		
		model.put("listaPacientesInfectados", listaPacientesInfectados);
    
        return new ModelAndView("listaPacientesInfectados", model);
    }

    @RequestMapping("/listapacientes2")
    public ModelAndView listapacientes2() {

        List<Paciente> pacientes = servicioPaciente.pacientes();

        ModelMap model = new ModelMap();

        model.put("listaPacientes", pacientes);

        return new ModelAndView("listapacientes2", model);
    }


}
