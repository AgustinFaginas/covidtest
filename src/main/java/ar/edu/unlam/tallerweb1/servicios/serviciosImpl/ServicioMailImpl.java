package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import java.io.StringWriter;
import java.util.Date;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioMail;

@Service("ServicioMail")
public class ServicioMailImpl implements ServicioMail {

	@Autowired
	private ServletContext context;
	
	@Autowired
	private JavaMailSender mailSender;
	 
	@Autowired
	private VelocityEngine velocityEngine;
	
	@Override
	public void SendEmail(String to, String subject, String path) {
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		try{
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(subject);
	        mimeMessageHelper.setTo(to);
	        mimeMessageHelper.setSentDate(new Date());
	        
	        path=path + context.getContextPath()+"/login";
	        
	        Template template = this.velocityEngine.getTemplate("/templates/email-template.html");
	        VelocityContext velocityContext = new VelocityContext();
	        velocityContext.put("path",path);
	        
	       
	       
	        StringWriter stringWriter = new StringWriter();
	        template.merge(velocityContext, stringWriter);
	        
	        mimeMessageHelper.setText(stringWriter.toString(), true);
	        mailSender.send(mimeMessageHelper.getMimeMessage());
	        System.out.println(context.getContextPath());
	       
		}catch(Exception e){
			e.printStackTrace();
		}
		/*
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        
        Template template = this.velocityEngine.getTemplate("/templates/email-template.html");
        
        VelocityContext velocityContext = new VelocityContext();
        
        StringWriter stringWriter = new StringWriter();
        
        template.merge(velocityContext, stringWriter);
        
        message.setText("<p>texto de prueba</p>");
        
        mailSender.send(message);
		*/
		
	}

}
