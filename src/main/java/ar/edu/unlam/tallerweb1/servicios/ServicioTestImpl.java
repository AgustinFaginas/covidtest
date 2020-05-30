package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioTestImpl implements ServicioTest {

	@Override
	public String realizarTest(String tos,String fiebre,String perdidaOlfato) throws Exception{
		
		if(tos==null || fiebre==null || perdidaOlfato==null) {
			throw new  Exception ("No estas infectado");
		}
		
		
		String mensaje="";
		if(tos.length()==2 && fiebre.length()==2 && perdidaOlfato.length()==2) {
			mensaje= "Estas infectado";
			return mensaje;
		
		}
		
		
		
		
		return mensaje;
	}

}
