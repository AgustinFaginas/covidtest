package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLocalidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServicioLocalidadImpl implements ServicioLocalidad {

    @Autowired
    private RepositorioLocalidad repositorioLocalidad;

    @Override
    public List<Localidad> obtenerLocalidades() {
        return repositorioLocalidad.obtenerLocalidades();
    }

    @Override
    public Localidad obtenerLocalidadPorNombre(String nombreLocalidad) {
        return repositorioLocalidad.obtenerLocalidadPorNombre(nombreLocalidad);
    }
}