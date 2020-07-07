package ar.edu.unlam.tallerweb1.controladores;


import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.modelo.IMC;
import com.google.protobuf.Enum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioTest;

@Controller
public class ControladorTest {

    @Inject
    private ServicioTest servicioTest;

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


    @RequestMapping("/home3")
    public ModelAndView home3() {

        return new ModelAndView("home1");

    }

    @RequestMapping("/enfermedades")
    public ModelAndView enfermedades() {

        return new ModelAndView("enfermedades");
    }

    @RequestMapping(value = "/validarEnfermedades", method = RequestMethod.GET)
    public ModelAndView validarEnfermedades(
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
        }
        if (esFumador) {
            contador++;
        }
        if (tieneDiabetes) {
            contador++;
        }
        if (tieneEnfHepatica) {
            contador++;
        }
        if (tieneEnfRespiratoria) {
            contador++;
        }
        if (tieneEnfRenal) {
            contador++;
        }
        if (tieneEnfCardiologica) {
            contador++;
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
