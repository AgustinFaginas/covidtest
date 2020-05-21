package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorInstituciones {
	
	@RequestMapping(value = "/detalle", method = RequestMethod.GET)
	public ModelAndView helloWorld(@RequestParam(value = "nombreInstitucion", required = false) String nombre)
			 {
		String message = "Detalle de: " + nombre;
		
		ModelMap model = new ModelMap();
		model.put("nombre", nombre);
		
		return new ModelAndView("vistaDetalle", model);
	}

}
