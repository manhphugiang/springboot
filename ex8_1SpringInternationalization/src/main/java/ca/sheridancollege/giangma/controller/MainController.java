package ca.sheridancollege.giangma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String getRoot() {
		return "root.html";
	}
}