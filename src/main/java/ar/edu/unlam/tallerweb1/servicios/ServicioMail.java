package ar.edu.unlam.tallerweb1.servicios;

public interface ServicioMail {
	
	public void SendEmail(String to, String subject, String path);
}