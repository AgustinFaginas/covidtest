package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorCama {

    @Autowired
    ServicioCama servicioCama;
    @Autowired
    ServicioPaciente servicioPaciente;
    @Autowired
    ServicioInstitucion servicioInstitucion;
    @Autowired
    ServicioAsignacion servicioAsignacion;

    @RequestMapping("/disponibilidadCamas")
    public ModelAndView disponibildadCamas(
    		
    		HttpServletRequest request
    		) {

    	ModelMap model = new ModelMap();
    	
    	if (request.getSession().getAttribute("ID") == null) {
			model.put("error", "Debe iniciar sesi�n");
	        return new ModelAndView("redirect:/login");
		}

		if (request.getSession().getAttribute("ROL") == Rol.PACIENTE) {
			return new ModelAndView("redirect:/denied");
		}
		
    	Long id = (long) request.getSession().getAttribute("ID");
    	Institucion institucion = servicioInstitucion.obtenerInstitucionPorId(id);
    	
    	if (request.getSession().getAttribute("ROL") == Rol.INSTITUCION) {
        	List<Cama> camasDisponiblesInstitucion = servicioCama.obtenerCamasDisponiblesPorInstitucion(institucion);
        	model.put("camas", camasDisponiblesInstitucion);
    	}
    	
    	if (request.getSession().getAttribute("ROL") == Rol.ADMIN) {
        	List<Cama> camasDisponiblesInstitucion = servicioCama.obtenerTotalDeCamasDisponibles();
        	model.put("camas", camasDisponiblesInstitucion);
    	}
        
        return new ModelAndView("disponibilidad-camas", model);
    }
    
    @RequestMapping("/listaCamas")
    public ModelAndView listarCamas(
    		
    		@RequestParam(value = "idPaciente") Long idPaciente,
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
		
		request.getSession().setAttribute("ID_PACIENTE", idPaciente);
		
    	Long id = (long) request.getSession().getAttribute("ID");
    	Institucion institucion = servicioInstitucion.obtenerInstitucionPorId(id);
        
    	List<Cama> camasDisponiblesInstitucion = servicioCama.obtenerCamasDisponiblesPorInstitucion(institucion);
    	
        model.put("camas", camasDisponiblesInstitucion);
        
        Paciente pacienteAInternar = servicioPaciente.consultarPacientePorId(idPaciente);

        model.put("camas", camasDisponiblesInstitucion);
        model.put("idPaciente", idPaciente);
        model.put("pacienteAInternar", pacienteAInternar);

        return new ModelAndView("listaCamas", model);
    }

}
