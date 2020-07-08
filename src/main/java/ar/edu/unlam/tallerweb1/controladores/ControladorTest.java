package ar.edu.unlam.tallerweb1.controladores;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.modelo.IMC;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import com.google.protobuf.Enum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioTest;

@Controller
public class ControladorTest {

    @Inject
    private ServicioTest servicioTest;

    @Inject
    private ServicioPaciente servicioPaciente;

    public ServicioTest getServicioTest() {
        return servicioTest;
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
            @RequestParam(value = "motivo", required = false) String motivo
    ) {

        if (servicioTest.realizarPermiso(nombre, apellido, edad, tipoDocumento, numeroDocumento, motivo)) {
            ModelMap model = new ModelMap();
            model.put("nombre", nombre);
            model.put("apellido", apellido);
            model.put("edad", edad);
            model.put("numeroDocumento", tipoDocumento);
            model.put("motivo", motivo);
            return new ModelAndView("permisoPositivo", model);
        } else {
            return new ModelAndView("permisoNegativo");
        }

    }

    @RequestMapping("/permisoPositivo")
    public ModelAndView permisoPositivo() {

        return new ModelAndView("permisoPositivo");

    }

    @RequestMapping("/enfermedades")
    public ModelAndView enfermedades(
            //@RequestParam(value = "ID_PACIENTE", required = false) Long ID_PACIENTE,
            HttpServletRequest request) {

        /*Long id_paciente = (Long) request.getSession().getAttribute("ID_PACIENTE");

        Paciente paciente = servicioPaciente.consultarPacientePorId(id_paciente);*/

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
            contador++;
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

        ModelMap model = new ModelMap();
        model.put("contador", contador);
        model.put("estatura", estaturaMetros);
        model.put("peso", peso);
        model.put("categoriaIMC", categoriaIMC);

        return new ModelAndView("validarEnfermedades", model);

    }


}
