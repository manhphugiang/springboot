package ca.sheridancollege.giangma.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.giangma.beans.Firefighter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class firefighterEmployeeController {

	private final String REST_URL = "http://localhost:8085/employee";
	
	@GetMapping("/")
	public String root() {
		return "root.html";
	}
	
	@GetMapping("/viewEmployee")
	public String getAllFireFighter(Model model, RestTemplate restTemplate) {
		ResponseEntity<Firefighter[]> responseEntity = restTemplate.getForEntity(REST_URL, Firefighter[].class);
		model.addAttribute("firefighter", responseEntity.getBody());
		return "viewEmployee.html";
	}
	
	@GetMapping("/addEmployee")
	public String addFirefighter() {
		return "addEmployee.html";
	}
	
	@PostMapping("/addEmployee")
	public String processingAddStore(@RequestParam String name, RestTemplate restTemplate) {
		Firefighter firefighter = Firefighter.builder().name(name).build();
		restTemplate.postForLocation(REST_URL, firefighter);
		return "addEmployee.html";
	}
	
}
