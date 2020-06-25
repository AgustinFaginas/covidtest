package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorInstitucion {

    private ServicioInstitucion servicioInstitucion;
    private ServicioCama servicioCama;
	private ServicioUsuario servicioUsuario;
    
    @Autowired
    public ControladorInstitucion(ServicioInstitucion servicioInstitucion, ServicioCama servicioCama,
			ServicioPaciente servicioPaciente, ServicioUsuario servicioUsuario) {
		this.servicioInstitucion = servicioInstitucion;
		this.servicioCama = servicioCama;
		this.servicioUsuario = servicioUsuario;
	}
    
    @RequestMapping("/registrarInstitucion")
	public ModelAndView registrarInstitucion() {

		ModelMap modelo = new ModelMap();

		return new ModelAndView("registrarInstitucion", modelo);
	}

	@RequestMapping("/detalleRegistroInstitucion")
    public ModelAndView validarRegistroInstitucion(

            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "numeroCuit", required = false) String numeroCuit,
            @RequestParam(value = "cantidadCamas", required = false) Integer camasTotales

    ) {
        Institucion institucion = new Institucion();

        institucion.setNombre(nombre);
        institucion.setEmail(email);
        institucion.setPassword(password);
        institucion.setCantidadCamas(camasTotales);
        institucion.setNumeroDocumento(numeroCuit);
        institucion.setTipoDocumento(TipoDocumento.CUIT);
        camasTotales = (int) camasTotales;

       if(servicioUsuario.consultarDisponibilidadEmail(email) == null ||
    	  servicioInstitucion.consultarInstitucionPorCuit(numeroCuit) == null) {
    	   
        servicioInstitucion.registrarInstitucion(institucion);
  
        for (Integer i = 0; i < camasTotales; i++) {
        	
            Cama cama = new Cama();
            cama.setInstitucion(institucion);
            servicioCama.registrarCama(cama);
        }

        String mensajeNombre = "Nombre: " + nombre;
        String mensajeApellido = "Email: " + email;

        ModelMap model = new ModelMap();
        model.put("mensajeNombre", mensajeNombre);
        model.put("mensajeApellido", mensajeApellido);

        return new ModelAndView("detalleRegistroInstitucion", model);
       }
       else {
    	   ModelMap model = new ModelMap();
    	   
           model.put("error", "Ya existe un usuario registrado con su mail o cuit");
           
    	   return new ModelAndView("registrarInstitucion", model);
       }
    }

    @RequestMapping("/listaInstituciones")
    public ModelAndView listarInstituciones() {

        List<Institucion> listaInstituciones = servicioInstitucion.obtenerListaInstituciones();

        ModelMap model = new ModelMap();
        model.put("listaInstituciones", listaInstituciones);

        return new ModelAndView("listaInstituciones", model);
    }

}
