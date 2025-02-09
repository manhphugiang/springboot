package ca.sheridancollege.giangma.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.giangma.bean.Player;
@Controller

public class playerController {
	private final String REST_URL = "http://localhost:8080/";
	
	@GetMapping("/")
	public String root() {
		return "root.html";
	}
	
	//view - aka Read
	@GetMapping("/view")
	public String viewPlayers(Model model, RestTemplate restTemplate) {
		ResponseEntity<Player[]> responseEntity = restTemplate.getForEntity(REST_URL, Player[].class);
		
		model.addAttribute("players", responseEntity.getBody());
		
		return "view.html";				
	}
	
	@GetMapping("/add")
	public String addPageGoGo() {
		return "add.html";
	}
	
	//add the player - aka Create
	@PostMapping("/add")
	public String processAdd(@RequestParam String name,
	                         @RequestParam String playerClass,
	                         @RequestParam int gamePlayed,
	                         @RequestParam int gameWon,
	                         @RequestParam int gameLost,
	                         @RequestParam int point,
	                         RestTemplate restTemplate) {
	    Player player = Player.builder()
	            .name(name)
	            .playerClass(playerClass)
	            .gamePlayed(gamePlayed)
	            .gameWon(gameWon)
	            .gameLost(gameLost)
	            .point(point)
	            .build();
	    
	    restTemplate.postForLocation(REST_URL, player);
	    return "add.html";
	}
	
	@GetMapping("/edit/{id}")
	public String getIditPageForMe(@PathVariable long id,
									Model model, 
									RestTemplate restTemplate) {
		ResponseEntity<Player> responseEntity = 
				restTemplate.getForEntity(REST_URL + "/" + id, Player.class);
		
		model.addAttribute("player", responseEntity.getBody());
		return "edit.html";
	}
	
	
	//update the player - aka Update
	@PostMapping("/edit/{id}")
	public String updatePlayer(@PathVariable long id,
								@ModelAttribute Player player,
	                           RestTemplate restTemplate) {
	    restTemplate.put(REST_URL + "/" + id, player);
	    return "redirect:/view"; 
	}

	@GetMapping("/delete/{id}")
	public String deleteSomePlayer(@PathVariable long id, RestTemplate restTemplate) {
		restTemplate.delete(REST_URL + "/" + id);
		return "redirect:/view";
	}

}
