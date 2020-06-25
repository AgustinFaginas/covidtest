package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import javax.transaction.Transactional;

import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioInstitucion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

import java.util.List;

@Service
@Transactional
public class ServicioInstitucionImpl implements ServicioInstitucion {

    @Autowired
    private RepositorioInstitucion repositorioInstitucion;
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Override
    public void registrarInstitucion(Usuario usuario){

        repositorioUsuario.registrarInstitucion(usuario);
    }

    @Override
    public Institucion consultarInstitucionPorCuit(String numeroCuit) {

        return repositorioInstitucion.consultarInstitucionPorCuit(numeroCuit);
    }

    @Override
    public List<Institucion> obtenerListaInstituciones() {
        return repositorioInstitucion.obtenerListaInstituciones();
    }

	@Override
	public Institucion obtenerInstitucionPorId(Long idInstitucion) {
		
		return repositorioInstitucion.obtenerInstitucionPorId(idInstitucion);
	}


}
