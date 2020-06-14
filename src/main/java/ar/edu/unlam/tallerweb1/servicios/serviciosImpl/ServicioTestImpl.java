package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import ar.edu.unlam.tallerweb1.servicios.ServicioTest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioTestImpl implements ServicioTest {

	@Override
	public Boolean realizarTest(Float fiebre, Boolean olfato, Boolean gusto, Boolean tos, Boolean respiracion) {
		
		if(olfato==null) {
			olfato=false;
		}
		if(gusto==null) {
			gusto=false;
		}
		if(tos==null) {
			tos=false;
		}
		if(respiracion==null) {
			respiracion=false;
		}
		
		
		
		
		
		Integer contador=0;
		
		if(fiebre>37) {
			contador++;
		}
		
		if(olfato==true) {
			contador++;
		}
		
		if(gusto==true) {
			contador++;
		}
		if(tos==true) {
			contador++;
		}
		if(respiracion==true) {
			contador++;
		}
		
		if(contador>=3){
			return true;
		}else {
			return false;
		}
	}

	

}
