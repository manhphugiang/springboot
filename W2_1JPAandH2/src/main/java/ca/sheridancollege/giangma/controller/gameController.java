package ca.sheridancollege.giangma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.giangma.beans.Videogame;
import ca.sheridancollege.giangma.repositories.VideogameRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class gameController {
	
	private VideogameRepository vgRepo;
	
	

	@GetMapping("/")
	public String getHomePage(){
		return "home.html";
	}	
	
	@GetMapping("/add")
	public String getAddPage(Model model){
		model.addAttribute("videogame", new Videogame());
		return "addGame.html";
	}
	
	@PostMapping("/add")
	public String processingAddGame(@ModelAttribute Videogame videogame) {
		vgRepo.save(videogame);
		return "redirect:/add";
	}
	
	@GetMapping("/view")
	public String getViewPage(Model model) {
		model.addAttribute("videogame", vgRepo.findAll());
		return "viewGames.html";
	}
}
