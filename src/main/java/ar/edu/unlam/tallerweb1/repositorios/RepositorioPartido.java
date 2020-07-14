package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Partido;

public interface RepositorioPartido {
    Partido obtenerPartidoPorNombre(String nombrePartido);
}
