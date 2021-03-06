package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.servicios.ServicioAtajo;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorPaciente {

    @Autowired
    ServicioPaciente servicioPaciente;
    @Autowired
    ServicioCama servicioCama;
    @Autowired
    ServicioLocalidad servicioLocalidad;
    @Autowired
	ServicioAtajo servicioAtajo;
	 
    /*Pantalla de bienvenido al paciente cuando inicia sesión*/
    @RequestMapping("bienvenidoPaciente")
	public ModelAndView irAbienvenido(HttpServletRequest request) {

		ModelMap model = new ModelMap();

    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));

		Long id = (Long) request.getSession().getAttribute("ID");
		Paciente paciente = servicioPaciente.consultarPacientePorId(id);

		String nombre = paciente.getNombre();

		model.put("nombre", nombre);
		

		return new ModelAndView("bienvenidoPaciente", model);
	}
    
    /*Consultar paciente por Nro y Tipo de Documento*/
    @RequestMapping("/consultarPaciente")
	public ModelAndView consultarPaciente() {

		ModelMap modelo = new ModelMap();

		Paciente paciente = new Paciente();
		modelo.put("paciente", paciente);

		return new ModelAndView("consultarPaciente", modelo);
	}
     
    /*Detalle por consultar paciente por Nro y Tipo de Documento*/
	@RequestMapping(path = "/detallePaciente", method = RequestMethod.POST)
	public ModelAndView validarConsulta(@ModelAttribute("paciente") Paciente paciente, HttpServletRequest request) {

		ModelMap model = new ModelMap();

    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
		
		paciente = servicioPaciente.consultarPacientePorDoc(paciente.getNumeroDocumento(), paciente.getTipoDocumento());

		if (paciente != null) {

			String mensaje = "Nombre: " + paciente.getNombre();
			String mensaje2 = "Apellido: " + paciente.getApellido();
			String mensaje3 = "Documento: (" + paciente.getTipoDocumento() + ") " + paciente.getNumeroDocumento();
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

    @RequestMapping("/listaPacientes")
    public ModelAndView pacientes(HttpServletRequest request) {

        ModelMap model = new ModelMap();
        
    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
        List<Paciente> pacientes = servicioPaciente.pacientes();

        model.put("listaPacientes", pacientes);

        return new ModelAndView("listaPacientes", model);
    }

    @RequestMapping("/grafico-pacientes")
    public ModelAndView graficoPacientes(HttpServletRequest request) {

        ModelMap model = new ModelMap();
        
    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
        Integer cantidadPacientes = servicioPaciente.pacientes().size();
        Integer cantidadPacientesInfectados = servicioPaciente.pacientesInfectados().size();
        Integer cantidadPacientesNoInfectados = cantidadPacientes - cantidadPacientesInfectados;

        List<Cama> camasOcupadas = servicioCama.obtenerTotalDeCamasOcupadas();
        Integer cantidadCamasOcupadas = camasOcupadas.size();

        List<Cama> camasDisponibles = servicioCama.obtenerTotalDeCamasDisponibles();
        Integer cantidadCamasDisponibles = camasDisponibles.size();

        model.put("cantidadPacientes", cantidadPacientes);
        model.put("cantidadPacientesInfectados", cantidadPacientesInfectados);
        model.put("cantidadPacientesNoInfectados", cantidadPacientesNoInfectados);
        model.put("cantidadCamasOcupadas", cantidadCamasOcupadas);
        model.put("cantidadCamasDisponibles", cantidadCamasDisponibles);

        return new ModelAndView("grafico-pacientes", model);
    }

    @RequestMapping("/mapa-paciente")
    public ModelAndView mapaPaciente(HttpServletRequest request) {

        ModelMap model = new ModelMap();
        
    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
        return new ModelAndView("detalleRegistroPaciente", model);
    }
    
    @RequestMapping("/posiblesinfectados")
    public ModelAndView posiblesinfectados(HttpServletRequest request) {

        ModelMap model = new ModelMap();
        
    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));

        List<Paciente> posiblesInfectados = servicioPaciente.posiblesInfectados();
        
        Boolean admin = false;
        if (request.getSession().getAttribute("ROL") == Rol.ADMIN) {
            admin = true;
        }
        
        model.put("posiblesInfectados", posiblesInfectados);
        model.put("admin", admin);

        return new ModelAndView("posiblesinfectados", model);
    }
 
    @RequestMapping("/listaPacientesInfectados")
    public ModelAndView listaPacientesInfectados(

            HttpServletRequest request

    ) {

        ModelMap model = new ModelMap();

    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));

        List<Paciente> listaPacientesInfectados = servicioPaciente.pacientesInfectados();

        model.put("listaPacientesInfectados", listaPacientesInfectados);

        return new ModelAndView("listaPacientesInfectados", model);
    }

    @RequestMapping("/listaPacientesInfectadosPasoDos")
    public ModelAndView listaPacientesInfectadosPasoDos(

            @RequestParam(value = "idCama") Long idCama,
            HttpServletRequest request

    ) {

        ModelMap model = new ModelMap();

        
    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));

        Cama cama = servicioCama.consultarCamaPorId(idCama);
        List<Paciente> listaPacientesInfectados = servicioPaciente.pacientesInfectados();

        model.put("cama", cama);
        model.put("listaPacientesInfectados", listaPacientesInfectados);

        return new ModelAndView("listaPacientesInfectadosPasoDos", model);
    }

	 @RequestMapping("/listaPacientesInternados")
	    public ModelAndView listaPacientesInternados(

	        HttpServletRequest request) {

	        ModelMap model = new ModelMap();

	        
	    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
	    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
	    	}
	    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
	    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
	    	}
	    	model.put("armarHeader", servicioAtajo.armarHeader(request));
	        
	        List<Paciente> listaPacientesInternados = new ArrayList<Paciente>();
	        
	        if (request.getSession().getAttribute("ROL") == Rol.ADMIN) {
	            listaPacientesInternados = servicioPaciente.pacientesInternados();
	        }
	        
	        if (request.getSession().getAttribute("ROL") == Rol.INSTITUCION) {
	        	Long id = (long) request.getSession().getAttribute("ID");
	            listaPacientesInternados = servicioPaciente.pacientesInternadosPorInstitucion(id);
	        }
	        
	        Boolean admin = false;
	        if (request.getSession().getAttribute("ROL") == Rol.ADMIN) {
	            admin = true;
	        }
	        
	        model.put("admin", admin);
	        model.put("listaPacientesInternados", listaPacientesInternados);
	    	
	        return new ModelAndView("listaPacientesInternados", model);
	    }

	 @RequestMapping("/listaPacientesInternadosDeInstitucion")
	    public ModelAndView listaPacientesInternadosDeInstitucion(

	        HttpServletRequest request,
	        @RequestParam(value = "idInstitucion") Long idInstitucion) {

	        ModelMap model = new ModelMap();  
	        
	    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
	    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
	    	}
	    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
	    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
	    	}
	    	model.put("armarHeader", servicioAtajo.armarHeader(request));

	        
	        List<Paciente> listaPacientesInternadosDeInstitucion = new ArrayList<Paciente>();

     	listaPacientesInternadosDeInstitucion = servicioPaciente.pacientesInternadosPorInstitucion(idInstitucion);
	        
	        model.put("listaPacientesInternados", listaPacientesInternadosDeInstitucion);
	    	
	        return new ModelAndView("listaPacientesInternadosDeInstitucion", model);
	    }
	 
	    @RequestMapping("/listapacientes2")
	    public ModelAndView listapacientes2(HttpServletRequest request) {

	        ModelMap model = new ModelMap();
	        
	    	if(servicioAtajo.validarInicioDeSesion(request) != null) {
	    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
	    	}
	    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
	    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
	    	}
	    	model.put("armarHeader", servicioAtajo.armarHeader(request));

	    	List<Paciente> pacientes = servicioPaciente.pacientes();
	
	        model.put("listaPacientes", pacientes);

	        return new ModelAndView("listapacientes2", model);
	    }

	 	/* ----- Getters and Setters ----- */
	    public ServicioPaciente getServicioPaciente() {
	        return servicioPaciente;
	    }

	    public void setServicioPaciente(ServicioPaciente servicioPaciente) {
	        this.servicioPaciente = servicioPaciente;
	    }

	    public ServicioCama getServicioCama() {
	        return servicioCama;
	    }

	    public void setServicioCama(ServicioCama servicioCama) {
	        this.servicioCama = servicioCama;
	    }

	    public ServicioLocalidad getServicioLocalidad() {
	        return servicioLocalidad;
	    }

	    public void setServicioLocalidad(ServicioLocalidad servicioLocalidad) {
	        this.servicioLocalidad = servicioLocalidad;
	    }
}
