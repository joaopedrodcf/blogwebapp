package com.infinitymaze.application.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinitymaze.application.dto.MessageDTO;
import com.infinitymaze.application.services.SendMailService;
@RestController
@RequestMapping("/contact")
public class ContactRestController {

	
	@Autowired
	private SendMailService sendMailService;

	@PostMapping
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<Void> sendEmail(@RequestBody MessageDTO message) {

		if(!sendMailService.sendMail(message)) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
