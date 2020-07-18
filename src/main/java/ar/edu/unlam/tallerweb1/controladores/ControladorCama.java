package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.listas.CamaInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioAtajo;
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

    
    ServicioCama servicioCama;
    ServicioPaciente servicioPaciente;
    ServicioInstitucion servicioInstitucion;
    ServicioAsignacion servicioAsignacion;
    ServicioAtajo servicioAtajo;
    
    @Autowired
    public ControladorCama(ServicioCama servicioCama, ServicioPaciente servicioPaciente,
			ServicioInstitucion servicioInstitucion, ServicioAsignacion servicioAsignacion,
			ServicioAtajo servicioAtajo) {
		this.servicioCama = servicioCama;
		this.servicioPaciente = servicioPaciente;
		this.servicioInstitucion = servicioInstitucion;
		this.servicioAsignacion = servicioAsignacion;
		this.servicioAtajo = servicioAtajo;
	}

	@RequestMapping("/disponibilidadCamas")
    public ModelAndView disponibildadCamas(HttpServletRequest request) {
    	
    	ModelMap model = new ModelMap();
		
    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	
    	System.out.println(servicioAtajo.armarHeader(request));
    	model.put("header2", servicioAtajo.armarHeader(request));
		
    	Long id = (long) request.getSession().getAttribute("ID");
    	Institucion institucion = servicioInstitucion.obtenerInstitucionPorId(id);
    	
    	if (request.getSession().getAttribute("ROL") == Rol.INSTITUCION) {
        	List<CamaInstitucion> camasDisponiblesPorInstitucion = servicioCama.obtenerCamasPorInstitucionConSuInstitucion(institucion);
        	model.put("camas", camasDisponiblesPorInstitucion);
    	}
    	
    	if (request.getSession().getAttribute("ROL") == Rol.ADMIN) {
        	List<CamaInstitucion> CamasTotalesDisponiblesConSuInstitucion = servicioCama.obtenerCamasTotalesDisponiblesConSuInstitucion();
        	model.put("camas", CamasTotalesDisponiblesConSuInstitucion);
    	}
        
        return new ModelAndView("disponibilidadCamas", model);
    }
    
    @RequestMapping("/listaCamas")
    public ModelAndView listarCamas(
    		
    		@RequestParam(value = "idPaciente") Long idPaciente,
    		HttpServletRequest request) {

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

    @RequestMapping("/cantidadDeCamasDisponibles")
    public ModelAndView obtenerCantidadDeCamasDisponibles(HttpServletRequest request) {

    	ModelMap model = new ModelMap();
    	
    	if (request.getSession().getAttribute("ID") == null) {
	        return new ModelAndView("redirect:/login");
		}

		if (request.getSession().getAttribute("ROL") == Rol.PACIENTE) {
			return new ModelAndView("redirect:/denied");
		}
		
    	Long id = (long) request.getSession().getAttribute("ID");
    	Institucion institucion = servicioInstitucion.obtenerInstitucionPorId(id);
    	
    	if (request.getSession().getAttribute("ROL") == Rol.INSTITUCION) {
        	List<CamaInstitucion> camasDisponiblesPorInstitucion = servicioCama.obtenerCantidadDeCamasOcupadasPorInstitucion(institucion);
        	model.put("camas", camasDisponiblesPorInstitucion);
    	}
    	
    	if (request.getSession().getAttribute("ROL") == Rol.ADMIN) {
        	List<CamaInstitucion> CamasTotalesDisponiblesConSuInstitucion = servicioCama.obtenerCantidadDeCamasOcupadasDeCadaInstitucion();
        	model.put("camas", CamasTotalesDisponiblesConSuInstitucion);
    	}
        
        return new ModelAndView("cantidadDeCamasDisponibles", model);
    }
}
