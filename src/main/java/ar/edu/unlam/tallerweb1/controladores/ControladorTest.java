package ar.edu.unlam.tallerweb1.controladores;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioTest;

@Controller
public class ControladorTest {

    @Inject
    private ServicioTest servicioTest;

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


        Boolean resultado = servicioTest.realizarTest(fiebre, olfato, gusto, tos, respiracion);

        if (resultado == true) {
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

        return new ModelAndView("home3");

    }
}
