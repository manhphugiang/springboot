package ca.sheridancollege.giangma.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
	@GetMapping("/")
	public String goHome() {
		return "index.html";
	}
	@GetMapping("/add")
	public String goAdd() {
		return "redirect:/#/add";
	}
	@GetMapping("/view")
	public String goView() {
		return "redirect:/#/view";
	}
}
