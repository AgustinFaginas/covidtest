package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorLocalidad {

    @Autowired
	ServicioLocalidad servicioLocalidad;
    @Autowired
    ServicioAtajo servicioAtajo;

    @RequestMapping("/localidades")
    public ModelAndView localidades(HttpServletRequest request) {

    	ModelMap model = new ModelMap();

		if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
        List<Localidad> localidades = servicioLocalidad.obtenerLocalidades();

        model.put("localidades", localidades);

        return new ModelAndView("localidades", model);
    }
}
