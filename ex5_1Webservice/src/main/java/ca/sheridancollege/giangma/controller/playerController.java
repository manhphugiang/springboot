package ca.sheridancollege.giangma.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.giangma.bean.Player;
import ca.sheridancollege.giangma.repository.playerRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor

public class playerController {
	
	private playerRepository playerRepo;
	
	@GetMapping(value= {"", "/"})
	public List<Player> getAllPlayerForDaddy() {
		return playerRepo.findAll();
	}
	
	@PutMapping(value="", headers = {"Content-type=application/json"})
	public String replaceAllPlayer(@RequestBody List<Player> players) {
		playerRepo.deleteAll();
	    players.forEach(player -> player.setId(null));
	    playerRepo.saveAll(players);  
	    return "Player List Replaced: " + playerRepo.count();
	}

	
	
	@PostMapping(value= {""}, headers = {"Content-type=application/json"})
	public String createEntryAndReturnId(@RequestBody Player player) {
        player.setId(null);
        player.setName(player.getName());
        player.setPlayerClass(player.getPlayerClass());
        player.setGamePlayed(player.getGamePlayed());
        player.setGameWon(player.getGameWon());
        player.setGameLost(player.getGameLost());
        player.setPoint(player.getPoint());
        
        playerRepo.save(player);
        
		return "The player ID added is: " + player.getId();
	}
	
	@DeleteMapping(value= {"", "/"})
	public String deleteAll() {
		playerRepo.deleteAll();
		return "Deleted";
	}
	
	
	
	// HTTP method for an element
	@GetMapping("/{id}")
	public Player getPlayerForDaddyById(@PathVariable long id) {
	    return playerRepo.findById(id).orElse(null);
	}
	
	@PutMapping(value="/{id}", headers = {"Content-type=application/json"})
	public Player replaceOnePlayer(@PathVariable long id, @RequestBody Player player) {
		player.setId(id);
	    return playerRepo.save(player);
	}

	
	@DeleteMapping(value= {"/{id}"})
	public String deleteAll(@PathVariable long id) {
		playerRepo.deleteById(id);
		return "Deleted";
	}
}
