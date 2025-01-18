package ca.sheridancollege.giangma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.giangma.beans.Contact;
import ca.sheridancollege.giangma.repositories.ContactRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class contactController {
	private ContactRepository ctRepo;
	
	@GetMapping("/")
	public String getHomePage() {
		return "home.html";
	}
	
	@GetMapping("/add")
	public String getAddPage(Model model) {
		model.addAttribute("contact", new Contact());
		return "add.html";
	}
	
	@PostMapping("/add")
	public String processingAddPage(@ModelAttribute Contact contact) {
		ctRepo.save(contact);
		return "redirect:/add";
	}
	
	@GetMapping("/view")
	public String getViewPage(Model model) {
		model.addAttribute("contact", ctRepo.findAll());
		return "view.html";
	}
	
}
