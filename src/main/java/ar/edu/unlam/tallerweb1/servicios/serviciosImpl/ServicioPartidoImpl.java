package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPartido;
import ar.edu.unlam.tallerweb1.servicios.ServicioPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioPartidoImpl implements ServicioPartido {

    @Autowired
    private RepositorioPartido repositorioPartido;

    @Override
    public Partido obtenerPartidoPorNombre(String nombrePartido) {
        return repositorioPartido.obtenerPartidoPorNombre(nombrePartido);
    }
}