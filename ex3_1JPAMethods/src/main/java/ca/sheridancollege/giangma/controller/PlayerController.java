package ca.sheridancollege.giangma.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	private PlayerRepository pRepo;

	
	@GetMapping("/")
	public String getHomePage() {
		return "home.html";
	}
	
	
	@GetMapping("/add")
	public String getAddPlayer(Model model) {
		model.addAttribute("player", new Player());
		return "addPlayer.html";
	}
	
	@PostMapping("/add")
	public String processingAddPlayer(@ModelAttribute Player player) {
		pRepo.save(player);
		return "redirect:/add";
	}
	
	
	@GetMapping("/view")
	public String viewPage(Model model) {
		model.addAttribute("player", pRepo.findAll());
		return "viewPlayer.html";
	}
	

}
