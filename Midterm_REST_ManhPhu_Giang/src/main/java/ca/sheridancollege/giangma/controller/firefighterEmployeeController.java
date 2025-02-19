package ca.sheridancollege.giangma.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.giangma.beans.Firefighter;
import ca.sheridancollege.giangma.repository.FirefighterRepository;
import lombok.AllArgsConstructor;

@RestController

@AllArgsConstructor
@RequestMapping("/employee")
public class firefighterEmployeeController {
	
	private FirefighterRepository firefighterRepo;
	
	@GetMapping(value= {"", "/"})
	public List<Firefighter> getAllEmployee(){
		List<Firefighter> firefighterList = firefighterRepo.findAll();
		return firefighterList;
	}
	
	@GetMapping("/{id}")
	public Firefighter getFirefighterById(@PathVariable long id){
		Optional<Firefighter> f1 = firefighterRepo.findById(id);
		
		if(f1.isPresent())
			return f1.get();
		else
			return null;
	}
	
	@PostMapping(value= {""}, headers = {"Content-type=application/json"})
	public Firefighter processingAddEmployee(@RequestBody Firefighter firefighter) {
		firefighter.setId(null);
		firefighter.setName(firefighter.getName());
		firefighterRepo.save(firefighter);
		return firefighter;
	}
	
	
}
