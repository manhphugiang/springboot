package ca.sheridancollege.giangma.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.giangma.beans.Player;
import ca.sheridancollege.giangma.beans.Videogame;
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
	public String viewPage(@RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy, Model model) {
	    List<Player> sortedPlayers;

	    switch (sortBy) {
	        case "name":
	            sortedPlayers = pRepo.findByOrderByNameAsc();
	            break;
	        case "guildPoint":
	            sortedPlayers = pRepo.findByOrderByGuildPointAsc();
	            break;
	        case "unitClass":
	            sortedPlayers = pRepo.findByOrderByUnitClassAsc();
	            break;
	        default:
	            sortedPlayers = pRepo.findAll();
	    }

	    model.addAttribute("player", sortedPlayers);
	    return "viewPlayer.html";
	}

	@GetMapping("/edit/{id}")
	public String goEdit(@PathVariable int id, Model model) {
		Optional<Player> player = pRepo.findById(id);
		if(player.isPresent()) { // there is a game with this id
			Player p = player.get();
			model.addAttribute("player", p);
			return "editPlayer.html";
		}else { // no game with that id
			return "redirect:/view";
		}
	}
	
	@PostMapping("/edit")
	public String processingEditGame(@ModelAttribute Player player) {
		pRepo.save(player);
		return "redirect:/view";
	}
	
	
	@GetMapping("/delete/{id}")
	public String processingDeleteGame(@PathVariable int id, Model model) {
		Optional<Player> player = pRepo.findById(id);
		if(player.isPresent()) { // there is a game with this id
			Player p = player.get();
			pRepo.delete(p);
			return "redirect:/view";
		}else { // no game with that id
			return "redirect:/view";
		}		
	}
	

}
