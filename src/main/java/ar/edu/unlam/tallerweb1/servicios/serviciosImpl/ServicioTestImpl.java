package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import ar.edu.unlam.tallerweb1.controladores.EmailUtil;
import ar.edu.unlam.tallerweb1.modelo.IMC;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioTest;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioTestImpl implements ServicioTest {

	@Override
	public Boolean realizarTest(Float fiebre, Boolean olfato, Boolean gusto, Boolean tos, Boolean respiracion) {

		if (olfato == null) {
			olfato = false;
		}
		if (gusto == null) {
			gusto = false;
		}
		if (tos == null) {
			tos = false;
		}
		if (respiracion == null) {
			respiracion = false;
		}

		Integer contador = 0;

		if (fiebre != null) {
			if (fiebre > 37) {
				contador++;
			}
		}

		if (olfato == true) {
			contador++;
		}

		if (gusto == true) {
			contador++;
		}
		if (tos == true) {
			contador++;
		}
		if (respiracion == true) {
			contador++;
		}

		if (contador >= 3) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public IMC calcularCategoriaIMC(Float peso, Float estaturaMetros) {

		Float imc = peso / (estaturaMetros * estaturaMetros);

		IMC categoriaIMC = null;

		if (imc < 18.5) {
			return IMC.INFERIOR;
		}
		if (imc >= 18.5 && imc < 25.0) {
			return IMC.NORMAL;
		}
		if (imc >= 25.0 && imc < 30.0) {
			return IMC.SUPERIOR;
		}
		if (imc >= 30.0) {
			return IMC.OBESIDAD;
		}

		return categoriaIMC;
	}

	@Override
	public Boolean realizarPermiso(String nombre, String apellido, Integer edad, String tipoDocumento,
			Integer numeroDocumento, String motivo) {

		if (edad >= 18) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void enviarMail(Paciente paciente) {
		// Voy a usar un servicio SMTP con autenticacion TLS,
		// por lo que tiene que ser un email valido con password correctamente escrito
		final String fromEmail = "unlam032@gmail.com";
		final String password = "qqQ#6Hh%4g1";

		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		// SMTP Host
		props.put("mail.smtp.host", "smtp.gmail.com");
		// TLS Puerto
		props.put("mail.smtp.port", "587");
		// activo autenticacion
		props.put("mail.smtp.auth", "true");
		// activo STARTTLS
		//rops.put("mail.smtp.starttls.enable", "true");
		
		
		// Creo un objeto autenticador para pasar como argumento a Session.getInstance

		Authenticator auth = new Authenticator() {

			// Desabilito el getPasswordAuthentication de nuestra cuenta
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);

		// preparo el mensaje
		String cuerpoMensaje = "Gracias " + paciente.getNombre() + " por registrarte en AsignAR!";

		EmailUtil.sendEmail(session, paciente.getEmail(), "Registro en AsignAR", cuerpoMensaje);

	}

}
