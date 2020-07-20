package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorInstitucion {

    private ServicioInstitucion servicioInstitucion;
    private ServicioCama servicioCama;
    private ServicioUsuario servicioUsuario;
    private ServicioDomicilio servicioDomicilio;
    private ServicioLocalidad servicioLocalidad;
    private ServicioPartido servicioPartido;
    private ServicioZona servicioZona;
    private ServicioAtajo servicioAtajo;
    
    @Autowired
    public ControladorInstitucion(ServicioInstitucion servicioInstitucion, ServicioCama servicioCama,
                                  ServicioPaciente servicioPaciente, ServicioUsuario servicioUsuario, 
                                  ServicioDomicilio servicioDomicilio, ServicioPartido servicioPartido, 
                                  ServicioLocalidad servicioLocalidad, ServicioZona servicioZona, 
                                  ServicioAtajo servicioAtajo) {
        
    	this.servicioInstitucion = servicioInstitucion;
        this.servicioCama = servicioCama;
        this.servicioUsuario = servicioUsuario;
        this.servicioDomicilio = servicioDomicilio;
        this.servicioLocalidad = servicioLocalidad;
        this.servicioPartido = servicioPartido;
        this.servicioZona = servicioZona;
        this.servicioAtajo = servicioAtajo;
    }

    @RequestMapping("/registrarInstitucion")
    public ModelAndView registrarInstitucion(HttpServletRequest request) {

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

        return new ModelAndView("registrarInstitucion", model);
    }

    @RequestMapping("/detalleRegistroInstitucion")
    public ModelAndView validarRegistroInstitucion(
    		
    		HttpServletRequest request,
            @ModelAttribute("usuario") Institucion institucion, 
            @RequestParam(value = "calle") String calle,
            @RequestParam(value = "numero") Integer numero,
            @RequestParam(value = "nombreLocalidad") String nombreLocalidad,
            @RequestParam(value = "nombrePartido") String nombrePartido

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

        institucion.setTipoDocumento(TipoDocumento.CUIT);
        
        if (servicioUsuario.consultarUsuarioPorEmail(institucion.getEmail()) == null
                && servicioInstitucion.consultarInstitucionPorCuit(institucion.getNumeroDocumento()) == null) {

            institucion.setRol(Rol.INSTITUCION);

            servicioInstitucion.registrarInstitucion(institucion);

            request.getSession().setAttribute("ID", institucion.getId());
            request.getSession().setAttribute("ROL", institucion.getRol());

            for (int i = 0; i < institucion.getCantidadCamas().intValue(); i++) {

                Cama cama = new Cama();
                cama.setInstitucion(institucion);

                int numeroCama = i + 1;
                String descripcion = "" + numeroCama;
                cama.setDescripcion(descripcion);

                servicioCama.registrarCama(cama);
            }

            Domicilio domicilio = new Domicilio();

            domicilio.setCalle(calle);
            domicilio.setNumero(numero);
            servicioDomicilio.registrarDomicilio(domicilio);
            institucion.setDomicilio(domicilio);
            Localidad localidad = servicioLocalidad.obtenerLocalidadPorNombre(nombreLocalidad);
            domicilio.setLocalidad(localidad);
            Partido partido = servicioPartido.obtenerPartidoPorNombre(nombrePartido);
            localidad.setPartido(partido);
            servicioInstitucion.actualizarInstitucion(institucion);
            servicioDomicilio.actualizarDomicilio(domicilio);
            servicioLocalidad.actualizarLocalidad(localidad);

            String mensaje = "Nombre: " + institucion.getNombre();
            String mensaje2 = "Documento: (" + institucion.getTipoDocumento() + ") " + institucion.getNumeroDocumento();
            String mensaje3 = "Email: " + institucion.getEmail();

            model.put("mensaje", mensaje);
            model.put("mensaje2", mensaje2);
            model.put("mensaje3", mensaje3);

            return new ModelAndView("detalleRegistroInstitucion", model);
        } else {

            model.put("error", "Ya existe un usuario registrado con su mail o cuit");

            return new ModelAndView("registrarInstitucion", model);
        }
    }

    @RequestMapping("/listaInstituciones")
    public ModelAndView listarInstituciones(HttpServletRequest request) {

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
    	
        List<Institucion> listaInstituciones = servicioInstitucion.obtenerListaInstituciones();

        model.put("listaInstituciones", listaInstituciones);

        return new ModelAndView("listaInstituciones", model);
    }

    @RequestMapping("bienvenido")
    public ModelAndView irAbienvenido(HttpServletRequest request) {

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
    	
        Long id = (Long) request.getSession().getAttribute("ID");
        Institucion institucion = servicioInstitucion.obtenerInstitucionPorId(id);

        String nombre = institucion.getNombre();
        Integer camas = (int) servicioCama.obtenerCamasPorInstitucion(institucion).size();

        model.put("nombre", nombre);
        model.put("camas", camas);

        return new ModelAndView("bienvenido", model);
    }
  
}
