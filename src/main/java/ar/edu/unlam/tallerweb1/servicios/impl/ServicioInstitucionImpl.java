package ar.edu.unlam.tallerweb1.servicios.impl;

import javax.transaction.Transactional;

import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioInstitucion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service
@Transactional

public class ServicioInstitucionImpl implements ServicioInstitucion {

	@Autowired
	private RepositorioInstitucion repositorioInstitucion;
	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Override
	public void registrarInstitucion(Usuario usuario) throws Exception {
		if (repositorioUsuario.consultarUsuario(usuario) != null) {
			throw new Exception("El mail ya se encuentra en uso");

		}

		repositorioUsuario.registrarInstitucion(usuario);

	}



	@Override
	public Institucion consultarInstitucionPorCuit(String numeroCuit)  {
		
		return repositorioInstitucion.consultarInstitucionPorCuit(numeroCuit);
	}



}
