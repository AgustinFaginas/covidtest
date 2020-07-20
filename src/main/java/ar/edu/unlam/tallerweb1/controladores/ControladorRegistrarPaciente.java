package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorRegistrarPaciente {

    private ServicioInstitucion servicioInstitucion;
    private ServicioUsuario servicioUsuario;
    private ServicioPaciente servicioPaciente;
    private ServicioDomicilio servicioDomicilio;
    private ServicioLocalidad servicioLocalidad;
    private ServicioPartido servicioPartido;
    private ServicioAtajo servicioAtajo;

    private ServicioTest servicioTest;

    @Autowired
    public ControladorRegistrarPaciente(ServicioInstitucion servicioInstitucion, ServicioCama servicioCama,
                                        ServicioPaciente servicioPaciente, ServicioUsuario servicioUsuario, 
                                        ServicioTest servicioTest, ServicioDomicilio servicioDomicilio, 
                                        ServicioLocalidad servicioLocalidad, ServicioPartido servicioPartido,
                                        ServicioAtajo servicioAtajo) {
        this.servicioInstitucion = servicioInstitucion;
        this.servicioUsuario = servicioUsuario;
        this.servicioPaciente = servicioPaciente;
        this.servicioTest = servicioTest;
        this.servicioDomicilio = servicioDomicilio;
        this.servicioLocalidad = servicioLocalidad;
        this.servicioPartido = servicioPartido;
        this.servicioAtajo = servicioAtajo;
    }

    @RequestMapping("/registrarPaciente")
    public ModelAndView registrarPaciente(HttpServletRequest request) {

    	ModelMap model = new ModelMap();

		if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));

        return new ModelAndView("registrarPaciente", model);
    }

    @RequestMapping("/detalleRegistroPaciente")
    public ModelAndView validarRegistroPaciente(

            @ModelAttribute("paciente") Paciente paciente,
            HttpServletRequest request,
            @RequestParam(value = "calle") String calle,
            @RequestParam(value = "numero") Integer numero,
            @RequestParam(value = "nombreLocalidad") String nombreLocalidad,
            @RequestParam(value = "nombrePartido") String nombrePartido

    ) {

    	ModelMap model = new ModelMap();

		if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
        if (paciente == null) {
            return new ModelAndView("redirect:/denied");
        }

        if (servicioUsuario.consultarUsuarioPorEmail(paciente.getEmail()) == null &&
                servicioPaciente.consultarPacientePorDoc(paciente.getNumeroDocumento(), paciente.getTipoDocumento()) == null) {

            paciente.setPosibleInfectado(true);
            paciente.setRol(Rol.PACIENTE);

            servicioPaciente.registrarPaciente(paciente);

            request.getSession().setAttribute("ROL", paciente.getRol());

            String nombre = paciente.getNombre();
            String documento = paciente.getNumeroDocumento();
            String email = paciente.getEmail();
            TipoDocumento tipoDocumento = paciente.getTipoDocumento();

            Paciente pacienteBuscado = servicioPaciente.consultarPacientePorDoc(documento, tipoDocumento);
            request.getSession().setAttribute("ID_PACIENTE", pacienteBuscado.getId());

            model.put("nombre", nombre);
            model.put("documento", documento);
            model.put("tipoDocumento", tipoDocumento);
            model.put("email", email);

            servicioTest.enviarMail(paciente);

            Domicilio domicilio = new Domicilio();
            domicilio.setCalle(calle);
            domicilio.setNumero(numero);
            servicioDomicilio.registrarDomicilio(domicilio);
            paciente.setDomicilio(domicilio);
            Localidad localidad = servicioLocalidad.obtenerLocalidadPorNombre(nombreLocalidad);
            domicilio.setLocalidad(localidad);
            Partido partido = servicioPartido.obtenerPartidoPorNombre(nombrePartido);
            localidad.setPartido(partido);
            servicioPaciente.actualizarPaciente(paciente);
            servicioDomicilio.actualizarDomicilio(domicilio);
            servicioLocalidad.actualizarLocalidad(localidad);

            return new ModelAndView("enfermedades", model);
        } else {

            model.put("error", "Ya existe un usuario registrado con su mail o documento");

            return new ModelAndView("registrarPaciente", model);
        }
    }
}
