package ar.edu.unlam.tallerweb1.controladores;

import java.awt.Checkbox;

import javax.inject.Inject;

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

	@RequestMapping("/autoTest")
	public ModelAndView aTest() {

		return new ModelAndView("autoTest");

	}

	@RequestMapping(value = "/validarTest", method = RequestMethod.GET)
	public ModelAndView validarTest(@RequestParam(value = "tos", required = false) String tos,
			@RequestParam(value = "fiebre", required = false) String fiebre,
			@RequestParam(value = "perdidaOlfato", required = false) String olfato) {

		ModelMap model = new ModelMap();

		try {
			String mensaje=servicioTest.realizarTest(tos, fiebre, olfato); 
				
				model.put("mensaje", mensaje);
			
		} catch (Exception e) {
			
		

			String mensaje=e.getMessage();
			model.put("mensaje", mensaje);
			e.printStackTrace();
		}

		return new ModelAndView("validarTest", model);
	}

}
