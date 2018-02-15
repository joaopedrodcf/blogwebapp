package com.infitymaze.application.ping;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingRestController {
	
	@RequestMapping("/ping")
    @ResponseBody
    @CrossOrigin(origins = {"http://localhost:3000"})
    String home() {
        return "Hello World!";
    }
}
