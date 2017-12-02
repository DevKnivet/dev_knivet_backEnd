package email;

import java.util.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailPost {
	
    public void enviarEmail(String usuario, String senha, String destinatario, String assunto, String corpo)
    {    	
    	Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.user", usuario);
		props.put("mail.smtp.password", senha);
		props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", "true");
	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);
	    try 
	    {
	    	 message.setFrom(new InternetAddress(usuario));	    	 
	    	 message.addRecipients(Message.RecipientType.TO, destinatario);	    	 
	    	 message.setSubject(assunto);
	    	 message.setText(corpo);
	    	 Transport transport = session.getTransport("smtp");
	         transport.connect(host,usuario, senha);
	         transport.sendMessage(message, message.getAllRecipients());
	         transport.close();
	    }
	    catch (AddressException ae) 
	    {
	    	ae.printStackTrace();
	    }
	    catch (MessagingException me) 
	    {
	    	me.printStackTrace();
	    }
    }
    
}
