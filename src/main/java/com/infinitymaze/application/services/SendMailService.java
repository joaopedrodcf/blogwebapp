package com.infinitymaze.application.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.infinitymaze.application.dto.MessageDTO;
import com.infinitymaze.application.rest.controllers.PostRestController;

@Service
public class SendMailService {

	private final String EMAIL = System.getenv().get("EMAIL_GMAIL"); 
	private final String PASSWORD = System.getenv().get("PASSWORD_GMAIL");
	
	private static final Logger logger = LogManager.getLogger(PostRestController.class);

	public boolean sendMail(MessageDTO message) {
		
		
		// setting gmail smtp properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// check the authentication
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL, PASSWORD);
			}
		});
		
		try {
			
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(EMAIL));

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EMAIL));

			msg.setSubject("Contact form BlogWebapp");

			msg.setText("Message from: " + message.getName() + "\nFor contact: " + message.getEmail() + "\nMessage: "
					+ message.getMessage());

			Transport.send(msg);

			System.out.println("Email Sent Successfully");

		} catch (MessagingException e) {
			logger.error(e.getMessage());
			return false;
			
		}
		
		return true;
		
	}

}
