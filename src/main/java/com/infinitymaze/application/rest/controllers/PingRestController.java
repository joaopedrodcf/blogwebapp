package com.infinitymaze.application.rest.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "https://blog-react-demo.herokuapp.com/"  })
public class PingRestController {
	
	@RequestMapping("/ping")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}
