package ca.sheridancollege.giangma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.giangma.beans.Guest;
import ca.sheridancollege.giangma.beans.Pet;
import ca.sheridancollege.giangma.repository.guestRepository;
import ca.sheridancollege.giangma.repository.petRepository;
import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class expoController {
	
	private guestRepository guestRepo;
	private petRepository petRepo;
	
	@GetMapping("/")
	public String getHomePage() {
		return "home.html";
	}
	
	@GetMapping("/addGuest")
	public String getAddGuest(Model model) {
		model.addAttribute("guest", new Guest());
		return "addGuest.html";
	}
	
	@PostMapping("/addGuest")
	public String processAddGuest(@ModelAttribute Guest guest) {
		guestRepo.save(guest);
		return "redirect:/addGuest";
	}
	
	@GetMapping("/addPet")
	public String getAddPet(Model model) {
		model.addAttribute("pet", new Pet());
		model.addAttribute("guestList", guestRepo.findAll());
		return "addPet.html";
	}
	
	@PostMapping("/addPet")
	public String processAddPet(@ModelAttribute Pet pet) {
		petRepo.save(pet);
		return "redirect:/addPet";
	}
	
	@GetMapping("/view")
	public String getViewPage(Model model) {
		model.addAttribute("guestList", guestRepo.findAll());
		model.addAttribute("");
		return "view.html";
	}
}
