package ar.edu.unlam.tallerweb1.controladores;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorTest {

    public ServicioPaciente getServicioPaciente() {
        return servicioPaciente;
    }


    public void setServicioPaciente(ServicioPaciente servicioPaciente) {
        this.servicioPaciente = servicioPaciente;
    }


    public void setServicioTest(ServicioTest servicioTest) {
        this.servicioTest = servicioTest;
    }

    @Inject
    private ServicioTest servicioTest;

    @Autowired
    ServicioPaciente servicioPaciente;

    @Inject
    private ServicioLogin servicioLogin;

    @Autowired
    private ServicioLocalidad servicioLocalidad;

    public ServicioTest getServicioTest() {
        return servicioTest;
    }

    public void setServicioLocalidad(ServicioLocalidad servicioLocalidad) {
        this.servicioLocalidad = servicioLocalidad;
    }

    public ServicioLocalidad getServicioLocalidad() {
        return servicioLocalidad;
    }

    @RequestMapping("/autoTest")
    public ModelAndView aTest() {

        return new ModelAndView("autoTest");

    }

    @RequestMapping(value = "/validarTest", method = RequestMethod.GET)
    public ModelAndView validarTest(
            @RequestParam(value = "fiebre", required = false) Float fiebre,
            @RequestParam(value = "perdidaOlfato", required = false) Boolean olfato,
            @RequestParam(value = "perdidaGusto", required = false) Boolean gusto,
            @RequestParam(value = "tos", required = false) Boolean tos,
            @RequestParam(value = "perdidaRespiracion", required = false) Boolean respiracion
    ) {

        if (servicioTest.realizarTest(fiebre, olfato, gusto, tos, respiracion)) {


            return new ModelAndView("testPositivo");
        } else {
            return new ModelAndView("testNegativo");
        }

    }

    @RequestMapping("/testPositivo")
    public ModelAndView testPositivo() {

        return new ModelAndView("testPositivo");

    }

    /*@RequestMapping("/localidades")
    public ModelAndView localidades() {

        List<Localidad> localidades = servicioLocalidad.obtenerLocalidades();

        ModelMap model = new ModelMap();

        model.put("localidades", localidades);

        return new ModelAndView("localidades", model);
    }*/

    @RequestMapping("/testNegativo")
    public ModelAndView testNegativo() {

        return new ModelAndView("testNegativo");

    }

    @RequestMapping("/generarPermiso")
    public ModelAndView generarPermiso() {

        return new ModelAndView("generarPermiso");

    }

    @RequestMapping(value = "/validarPermiso", method = RequestMethod.POST)
    public ModelAndView validarPermiso(
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "apellido", required = false) String apellido,
            @RequestParam(value = "edad", required = false) Integer edad,
            @RequestParam(value = "tipoDocumento", required = false) String tipoDocumento,
            @RequestParam(value = "numeroDocumento", required = false) Integer numeroDocumento,
            @RequestParam(value = "numeroCalle", required = false) Integer numeroCalle,
            @RequestParam(value = "calle", required = false) String calle,
            @RequestParam(value = "nombreLocalidad") String nombreLocalidad,
            @RequestParam(value = "telefono", required = false) Integer telefono,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "motivo", required = false) String motivo
    ) {

        if (servicioTest.realizarPermiso(nombre, apellido, edad, tipoDocumento, numeroDocumento, motivo)) {
            ModelMap model = new ModelMap();

            Localidad localidad = servicioLocalidad.obtenerLocalidadPorNombre(nombreLocalidad);
            Partido partido = localidad.getPartido();
            String nombrePartido = partido.getNombrePartido();

            model.put("nombre", nombre);
            model.put("apellido", apellido);
            model.put("edad", edad);
            model.put("tipoDocumento", tipoDocumento);
            model.put("numeroDocumento", numeroDocumento);
            model.put("nombreLocalidad", nombreLocalidad);
            model.put("nombrePartido", nombrePartido);
            model.put("calle", calle);
            model.put("numeroCalle", numeroCalle);
            model.put("telefono", telefono);
            model.put("email", email);
            model.put("motivo", motivo);
            return new ModelAndView("permisoAceptado", model);
        } else {
            return new ModelAndView("permisoDenegado");
        }

    }

    @RequestMapping("/permisoPositivo")
    public ModelAndView permisoPositivo() {

        return new ModelAndView("permisoAceptado");

    }

    @RequestMapping("/permisoDenegado")
    public ModelAndView permisoDenegado() {

        return new ModelAndView("permisoDenegado");

    }

    @RequestMapping("/enfermedades")
    public ModelAndView enfermedades(
            @RequestParam(value = "ID_PACIENTE", required = false) Long ID_PACIENTE,
            HttpServletRequest request) {

        Long id_paciente = (Long) request.getSession().getAttribute("ID_PACIENTE");

        Paciente paciente = servicioPaciente.consultarPacientePorId(id_paciente);

        return new ModelAndView("enfermedades");
    }

    /*
    * @RequestMapping(path = "/validar-enfermedades", method = RequestMethod.POST)
    public ModelAndView validarLogin(@ModelAttribute("paciente") Usuario usuario, HttpServletRequest request) {*/
    @RequestMapping(path = "/validarEnfermedades", method = RequestMethod.POST)
    public ModelAndView validarEnfermedades(
            @ModelAttribute("paciente") Usuario usuario,
            HttpServletRequest request,
            @RequestParam(value = "tieneEmbarazo", required = false) Boolean tieneEmbarazo,
            @RequestParam(value = "esFumador", required = false) Boolean esFumador,
            @RequestParam(value = "tieneDiabetes", required = false) Boolean tieneDiabetes,
            @RequestParam(value = "tieneEnfHepatica", required = false) Boolean tieneEnfHepatica,
            @RequestParam(value = "tieneEnfRespiratoria", required = false) Boolean tieneEnfRespiratoria,
            @RequestParam(value = "tieneEnfRenal", required = false) Boolean tieneEnfRenal,
            @RequestParam(value = "tieneEnfCardiologica", required = false) Boolean tieneEnfCardiologica,
            @RequestParam(value = "estatura", required = false) Float estatura,
            @RequestParam(value = "peso", required = false) Float peso
    ) {

        Long id_paciente = (Long) request.getSession().getAttribute("ID_PACIENTE");

        Paciente paciente = servicioPaciente.consultarPacientePorId(id_paciente);

        if (tieneEmbarazo == null) {
            tieneEmbarazo = false;
        }
        if (esFumador == null) {
            esFumador = false;
        }
        if (tieneDiabetes == null) {
            tieneDiabetes = false;
        }
        if (tieneEnfHepatica == null) {
            tieneEnfHepatica = false;
        }
        if (tieneEnfRespiratoria == null) {
            tieneEnfRespiratoria = false;
        }
        if (tieneEnfRenal == null) {
            tieneEnfRenal = false;
        }
        if (tieneEnfCardiologica == null) {
            tieneEnfCardiologica = false;
        }

        Integer contador = 0;

        if (tieneEmbarazo) {
            paciente.setTieneEmbarazo(true);
        }
        if (esFumador) {
            contador++;
            paciente.setEsFumador(true);
        }
        if (tieneDiabetes) {
            contador++;
            paciente.setTieneDiabetes(true);
        }
        if (tieneEnfHepatica) {
            contador++;
            paciente.setTieneEnfHepatica(true);
        }
        if (tieneEnfRespiratoria) {
            contador++;
            paciente.setTieneEnfRespiratoria(true);
        }
        if (tieneEnfRenal) {
            contador++;
            paciente.setTieneEnfRenal(true);
        }
        if (tieneEnfCardiologica) {
            contador++;
            paciente.setTieneEnfCardiologica(true);
        }

        Float estaturaMetros = estatura / 100;

        IMC categoriaIMC = servicioTest.calcularCategoriaIMC(peso, estaturaMetros);

        Integer prioridad = servicioPaciente.establecerPrioridad(contador, tieneEmbarazo, categoriaIMC, paciente.getEdad());

        paciente.setPrioridad(prioridad);

        servicioPaciente.actualizarPaciente(paciente);

        /*ModelMap model = new ModelMap();
        model.put("contador", contador);
        model.put("estatura", estaturaMetros);
        model.put("peso", peso);
        model.put("categoriaIMC", categoriaIMC);
        model.put("prioridad", prioridad);

        return new ModelAndView("validarEnfermedades", model);*/
        return new ModelAndView("detalleRegistroPaciente");


    }

    @RequestMapping(value = "/validar-email", method = RequestMethod.POST)
    public @ResponseBody
    String validarEmail(@RequestBody String json) {
        Paciente usuario = new Paciente();
        usuario.setEmail(json);
        Usuario usuario2 = servicioLogin.consultarUsuarioporEmail(usuario);
        String mensaje = "OK";
        try {
            if (usuario2.getEmail() != null) {
                mensaje = "BAD";
                return mensaje;
            }
        } catch (NullPointerException e) {
            mensaje = "OK";
            return mensaje;
        }

        return mensaje;
    }


}
