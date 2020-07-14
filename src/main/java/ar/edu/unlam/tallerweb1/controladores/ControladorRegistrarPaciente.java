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

    private ServicioTest servicioTest;

    @Autowired
    public ControladorRegistrarPaciente(ServicioInstitucion servicioInstitucion, ServicioCama servicioCama,
                                        ServicioPaciente servicioPaciente, ServicioUsuario servicioUsuario, ServicioTest servicioTest, ServicioDomicilio servicioDomicilio, ServicioLocalidad servicioLocalidad, ServicioPartido servicioPartido) {
        this.servicioInstitucion = servicioInstitucion;
        this.servicioUsuario = servicioUsuario;
        this.servicioPaciente = servicioPaciente;
        this.servicioTest = servicioTest;
        this.servicioDomicilio = servicioDomicilio;
        this.servicioLocalidad = servicioLocalidad;
        this.servicioPartido = servicioPartido;
    }

    @RequestMapping("/registrarPaciente")
    public ModelAndView registrarPaciente() {

        ModelMap modelo = new ModelMap();

        return new ModelAndView("registrarPaciente", modelo);
    }

    @RequestMapping("/localidades")
    public ModelAndView localidades() {

        List<Localidad> localidades = servicioLocalidad.obtenerLocalidades();

        ModelMap model = new ModelMap();

        model.put("localidades", localidades);

        return new ModelAndView("localidades", model);
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

        if (paciente == null) {
            return new ModelAndView("redirect:/denied");
        }

        ModelMap model = new ModelMap();

        if (servicioUsuario.consultarUsuarioPorEmail(paciente.getEmail()) == null &&
                servicioPaciente.consultarPacientePorDoc(paciente.getNumeroDocumento(), paciente.getTipoDocumento()) == null) {

            paciente.setPosibleInfectado(true);

            servicioPaciente.registrarPaciente(paciente);

            String rol = Rol.PACIENTE.name();
            request.getSession().setAttribute("rol", paciente.getRol());

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
