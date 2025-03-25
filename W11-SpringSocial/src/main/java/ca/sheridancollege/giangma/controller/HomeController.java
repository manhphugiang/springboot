package ca.sheridancollege.giangma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "home.html";
	}
	
	@GetMapping("/secure")
	public String secure() {
		return "secure.html";
	}
}
