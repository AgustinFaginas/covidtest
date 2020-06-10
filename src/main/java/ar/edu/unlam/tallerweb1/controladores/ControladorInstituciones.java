package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;


@Controller
public class ControladorInstituciones {

    @Autowired
    private ServicioInstitucion servicioInstitucion;

    @Autowired
    private ServicioCama servicioCama;

    @RequestMapping(value = "/detalle", method = RequestMethod.GET)
    public ModelAndView detalle(@RequestParam(value = "nombre", required = false) String nombre) {
        String message = "Detalle de: " + nombre;

        ModelMap model = new ModelMap();

        model.put("msg", message);
        return new ModelAndView("panelInstitucion", model);
    }

    @RequestMapping("/registroinstitucion")
    public ModelAndView registrarPaciente(

            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "cuit", required = false) String cuit,
            @RequestParam(value = "cantidadCamas", required = false) Integer camasTotales

    ) {
        Institucion institucion = new Institucion();

        institucion.setNombre(nombre);
        institucion.setEmail(email);
        institucion.setPassword(password);
        institucion.setCantidadCamas(camasTotales);
        institucion.setNumeroDocumento(cuit);
        List<Cama> camas = new ArrayList<Cama>();
        camasTotales = camas.size();

        try {
            servicioInstitucion.registrarInstitucion(institucion);
        } catch (Exception e) {

            e.printStackTrace();
        }

        String message = "Nombre: " + nombre;
        String message2 = "Email: " + email;

        ModelMap model = new ModelMap();
        model.put("msg", message);
        model.put("msg2", message2);

        return new ModelAndView("registroinstitucion", model);
    }

    @RequestMapping("/instituciones")
    public ModelAndView instituciones() {

        List<Institucion> instituciones = servicioInstitucion.institucion();

        ModelMap model = new ModelMap();

        model.put("instituciones", instituciones);

        return new ModelAndView("instituciones", model);
    }


}
