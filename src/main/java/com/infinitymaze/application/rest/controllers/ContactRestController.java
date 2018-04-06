package com.infinitymaze.application.rest.controllers;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinitymaze.application.dto.MessageDTO;
@RestController
@RequestMapping("/contact")
public class ContactRestController {

	
	final String email = "YOUR EMAIL";
	
	// If you use two step authenticator create here a app password and use it here https://security.google.com/settings/security/apppasswords
	final String password = "YOUR PASSWORD";

	private static final Logger logger = LogManager.getLogger(PostRestController.class);

	@PostMapping
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<Void> sendEmail(@RequestBody MessageDTO message) {

		// setting gmail smtp properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// check the authentication
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});

		try {

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(email));

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

			msg.setSubject("Contact form BlogWebapp");

			msg.setText("Message from: " + message.getName() + "\nFor contact: " + message.getEmail() + "\nMessage: "
					+ message.getMessage());

			Transport.send(msg);

			System.out.println("Email Sent Successfully");

		} catch (MessagingException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
