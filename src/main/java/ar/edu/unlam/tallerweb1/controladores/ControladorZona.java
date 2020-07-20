package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Zona;
import ar.edu.unlam.tallerweb1.servicios.ServicioAtajo;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioZona;

@Controller
public class ControladorZona {

	@Autowired
	private ServicioAtajo servicioAtajo;	
	@Autowired
	private ServicioInstitucion servicioInstitucion;
	@Autowired
	private ServicioZona servicioZona;
	
    @RequestMapping(value = "/institucionesporzona", method = RequestMethod.GET)
    public ModelAndView institucionesPorZona(
            
    		HttpServletRequest request,
    		@RequestParam(value = "nombreZona") String nombreZona
    ) {
            
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
    	
    	Long id = (long) request.getSession().getAttribute("ID");
        Zona zona = servicioZona.obtenerZonaPorNombre(nombreZona);
        String nombreDeZona = zona.getNombre();
        model.put("nombreDeZona", nombreDeZona);

		List<Institucion> instituciones = servicioInstitucion.listarInstitucionesPorLocalidad(id);
        model.put("instituciones", instituciones);

        return new ModelAndView("institucionesporzona", model);
    }
}
