package com.mongo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MongoController {

	@GetMapping("/login1")
	public String getLogin1() {
		
		return "login1";
	}
	
	@GetMapping("/login2")
	public String getLogin2() {
		
		return "login2";
	}
	
	@GetMapping("/home")
	public String getHome() {
		
		return "home";
	}
	@GetMapping("/hellosp")
	public String getHello() {
		
		return "hellosp";
	}
	@GetMapping("/hellouser")
	public String getHelloUser() {
		
		return "hellouser";
	}
}
