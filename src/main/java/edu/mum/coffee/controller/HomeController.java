package edu.mum.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@GetMapping({"/", "/index", "/home"})
	public String homePage() {
		return "index";
	}

	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}
}
