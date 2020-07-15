package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalidad;
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
public class ControladorPaciente {

    @Autowired
    ServicioPaciente servicioPaciente;
    @Autowired
    ServicioCama servicioCama;
    @Autowired
    ServicioLocalidad servicioLocalidad;


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


    @RequestMapping("/listaPacientes")
    public ModelAndView pacientes() {

        List<Paciente> pacientes = servicioPaciente.pacientes();

        ModelMap model = new ModelMap();

        model.put("listaPacientes", pacientes);

        return new ModelAndView("listaPacientes", model);
    }

    /*@RequestMapping("/localidades")
    public ModelAndView localidades() {

        List<Localidad> localidades = servicioLocalidad.obtenerLocalidades();

        ModelMap model = new ModelMap();

        model.put("localidades", localidades);

        return new ModelAndView("localidades", model);
    }*/

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

    @RequestMapping("/listaPacientesInfectadosPasoDos")
    public ModelAndView listaPacientesInfectadosPasoDos(

            @RequestParam(value = "idCama") Long idCama,
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

        Cama cama = servicioCama.consultarCamaPorId(idCama);
        List<Paciente> listaPacientesInfectados = servicioPaciente.pacientesInfectados();

        model.put("cama", cama);
        model.put("listaPacientesInfectados", listaPacientesInfectados);

        return new ModelAndView("listaPacientesInfectadosPasoDos", model);
    }

    @RequestMapping("/listapacientes2")
    public ModelAndView listapacientes2() {

        List<Paciente> pacientes = servicioPaciente.pacientes();

        ModelMap model = new ModelMap();

        model.put("listaPacientes", pacientes);

        return new ModelAndView("listapacientes2", model);
    }
    
    @RequestMapping("bienvenidoPaciente")
	public ModelAndView irAbienvenido(HttpServletRequest request) {

		ModelMap model = new ModelMap();

		if (request.getSession().getAttribute("ID") == null) {
			return new ModelAndView("redirect:/home");
		}

		if (request.getSession().getAttribute("ROL") == Rol.PACIENTE) {

			Long id = (Long) request.getSession().getAttribute("ID");
			Paciente paciente = servicioPaciente.consultarPacientePorId(id);

			String nombre = paciente.getNombre();
			//Integer camas = (int) servicioCama.obtenerCamasPorInstitucion(institucion).size();

			model.put("nombre", nombre);
			

			return new ModelAndView("bienvenidoPaciente", model);

		}
		return new ModelAndView("redirect:/denied");
	}

}
