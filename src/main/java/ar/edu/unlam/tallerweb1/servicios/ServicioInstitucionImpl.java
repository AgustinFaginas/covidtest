package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.repositorios.InstitucionDao;

@Service
@Transactional
public class ServicioInstitucionImpl implements ServicioInstitucion {

	@Autowired
	private InstitucionDao institucionDao;

	@Override
	public Long guardarInstitucion(Institucion institucion) {

		return institucionDao.guardarInstitucion(institucion);
	}

	@Override
	public Institucion consultarInstitucionPorId(Long id) {

		return institucionDao.consultarInstitucionPorId(id);
	}

}
