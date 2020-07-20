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
public class ControladorLocalidad {

    private ServicioInstitucion servicioInstitucion;
    private ServicioUsuario servicioUsuario;
    private ServicioPaciente servicioPaciente;
    private ServicioDomicilio servicioDomicilio;
    private ServicioLocalidad servicioLocalidad;
    private ServicioPartido servicioPartido;
    private ServicioAtajo servicioAtajo;

    private ServicioTest servicioTest;

    @Autowired
    public ControladorLocalidad(ServicioInstitucion servicioInstitucion, ServicioCama servicioCama,
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
    @RequestMapping("/localidades")
    public ModelAndView localidades(HttpServletRequest request) {

    	ModelMap model = new ModelMap();

		if(servicioAtajo.validarInicioDeSesion(request) != null) {
    		return new ModelAndView(servicioAtajo.validarInicioDeSesion(request));
    	}
    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
        List<Localidad> localidades = servicioLocalidad.obtenerLocalidades();

        model.put("localidades", localidades);

        return new ModelAndView("localidades", model);
    }
}
