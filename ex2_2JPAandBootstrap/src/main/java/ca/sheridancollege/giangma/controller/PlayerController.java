package ca.sheridancollege.giangma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.giangma.beans.Player;
import ca.sheridancollege.giangma.repository.PlayerRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PlayerController {
	
	private PlayerRepository playerRepo;
	
	@GetMapping("/")
	public String getHomePage() {
		return "home.html";
	}
	@GetMapping("/add")
	public String getAddPage(Model model) {
		model.addAttribute("player", new Player());
		return "add.html";
	}
	
	@PostMapping("/add")
	public String processingAddPlayer(@ModelAttribute Player player) {
		playerRepo.save(player);
		return "redirect:/add";
	}
	
	@GetMapping("/view")
	public String getViewPage(Model model) {
		model.addAttribute("player", playerRepo.findAll());
		return "viewPlayers.html";
	}
	
	
}
