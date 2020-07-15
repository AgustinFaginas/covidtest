package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Institucion;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Zona;

import java.util.List;

public interface ServicioInstitucion {

    public void registrarInstitucion(Usuario usuario);

    public Institucion consultarInstitucionPorCuit(String numeroCuit);

    public List<Institucion> obtenerListaInstituciones();
    //Para panel
    public Institucion obtenerInstitucionPorId(Long idInstitucion);

    void actualizarInstitucion(Institucion institucion);

    //List<Institucion> listarInstitucionesPorZona(Zona zona);
}
