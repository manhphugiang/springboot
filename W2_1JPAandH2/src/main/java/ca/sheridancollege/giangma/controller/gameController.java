package ca.sheridancollege.giangma.controller;

import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
//	@GetMapping("/view")
//	public String getViewPage(Model model) {
//		
//		Pageable page = PageRequest.of(0, 3);
//		model.addAttribute("videogame", vgRepo.findBy(page));
//		return "viewGames.html";
//	}
	
	@GetMapping("/view")
	public String getViewPage(Model model) {
	    Pageable pageable = PageRequest.of(0, 3);
	    model.addAttribute("videogame", vgRepo.findAll(pageable)); // Correct method
	    return "viewGames.html";
	}

	
	@GetMapping("/edit/{id}")
	public String goEdit(@PathVariable int id, Model model) {
		Optional<Videogame> game = vgRepo.findById(id);
		if(game.isPresent()) { // there is a game with this id
			Videogame g = game.get();
			model.addAttribute("videogame", g);
			return "editGame.html";
		}else { // no game with that id
			return "redirect:/view";
		}
	}
	
	@PostMapping("/edit")
	public String processingEditGame(@ModelAttribute Videogame videogame) {
		vgRepo.save(videogame);
		return "redirect:/view";
	}
	
	@GetMapping("/delete/{id}")
	public String processingDeleteGame(@PathVariable int id, Model model) {
		Optional<Videogame> game = vgRepo.findById(id);
		if(game.isPresent()) { // there is a game with this id
			Videogame g = game.get();
			vgRepo.delete(g);
			return "redirect:/view";
		}else { // no game with that id
			return "redirect:/view";
		}		
	}
	
	@GetMapping("/search") //nav to search
	public String getSearchPage() {
		return "search.html";
	}
	
	@GetMapping("/searchTitle") //nav to search
	public String getTitle(@RequestParam String title, Model model) {
		model.addAttribute("videogame", vgRepo.findByTitleContainingIgnoreCase(title));
		return "search.html";
	}
	
	@GetMapping("/searchPrice") //nav to search
	public String getPrice(@RequestParam double price, Model model) {
		model.addAttribute("videogame", vgRepo.findByPriceLessThan(price));
		return "search.html";
	}
	
	
}
