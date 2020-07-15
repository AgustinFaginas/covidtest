package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import ar.edu.unlam.tallerweb1.modelo.Zona;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioZona;
import ar.edu.unlam.tallerweb1.servicios.ServicioZona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServicioZonaImpl implements ServicioZona {

    @Autowired
    private RepositorioZona repositorioZona;

    @Override
    public Zona obtenerZonaPorNombre(String nombreZona) {
        return repositorioZona.obtenerZonaPorNombre(nombreZona);
    }

    @Override
    public List<Zona> listarInstitucionesPorZona(Zona zona) {
        return null;
    }

/*    @Override
    public List<Zona> listarInstitucionesPorZona(Zona zona) {
        return repositorioZona.listarInstitucionesPorZona(zona);
    }*/
}
