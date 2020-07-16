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

    @Autowired
    public ControladorInstitucion(ServicioInstitucion servicioInstitucion, ServicioCama servicioCama,
                                  ServicioPaciente servicioPaciente, ServicioUsuario servicioUsuario, ServicioDomicilio servicioDomicilio, ServicioPartido servicioPartido, ServicioLocalidad servicioLocalidad, ServicioZona servicioZona) {
        this.servicioInstitucion = servicioInstitucion;
        this.servicioCama = servicioCama;
        this.servicioUsuario = servicioUsuario;
        this.servicioDomicilio = servicioDomicilio;
        this.servicioLocalidad = servicioLocalidad;
        this.servicioPartido = servicioPartido;
        this.servicioZona = servicioZona;
    }

    @RequestMapping("/registrarInstitucion")
    public ModelAndView registrarInstitucion() {

        ModelMap modelo = new ModelMap();

        return new ModelAndView("registrarInstitucion", modelo);
    }

    @RequestMapping("/detalleRegistroInstitucion")
    public ModelAndView validarRegistroInstitucion(

            @ModelAttribute("usuario") Institucion institucion, HttpServletRequest request,
            @RequestParam(value = "calle") String calle,
            @RequestParam(value = "numero") Integer numero,
            @RequestParam(value = "nombreLocalidad") String nombreLocalidad,
            @RequestParam(value = "nombrePartido") String nombrePartido

    ) {

        institucion.setTipoDocumento(TipoDocumento.CUIT);

        ModelMap model = new ModelMap();

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
    public ModelAndView listarInstituciones() {

        List<Institucion> listaInstituciones = servicioInstitucion.obtenerListaInstituciones();

        ModelMap model = new ModelMap();
        model.put("listaInstituciones", listaInstituciones);

        return new ModelAndView("listaInstituciones", model);
    }

    @RequestMapping("bienvenido")
    public ModelAndView irAbienvenido(HttpServletRequest request) {

        ModelMap model = new ModelMap();

        if (request.getSession().getAttribute("ID") == null) {
            return new ModelAndView("redirect:/home");
        }

        if (request.getSession().getAttribute("ROL") == Rol.INSTITUCION) {

            Long id = (Long) request.getSession().getAttribute("ID");
            Institucion institucion = servicioInstitucion.obtenerInstitucionPorId(id);

            String nombre = institucion.getNombre();
            Integer camas = (int) servicioCama.obtenerCamasPorInstitucion(institucion).size();

            model.put("nombre", nombre);
            model.put("camas", camas);

            return new ModelAndView("bienvenido", model);

        }
        return new ModelAndView("redirect:/denied");
    }

    /*@RequestMapping(value = "/instituciones-por-zona", method = RequestMethod.GET)
    public ModelAndView institucionesPorZona(
            @RequestParam(value = "nombreZona") String nombreZona
    ) {
        ModelMap model = new ModelMap();

        Zona zona = servicioZona.obtenerZonaPorNombre(nombreZona);

        String nombreDeZona = zona.getNombre();

		List<Institucion> instituciones = servicioInstitucion.listarInstitucionesPorLocalidad(id);


        model.put("nombreDeZona", nombreDeZona);

        return new ModelAndView("institucionesporzona", model);
    }*/



}
