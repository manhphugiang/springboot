package ca.sheridancollege.giangma.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.giangma.beans.Store;

@Controller
public class StoreController {
	
	private final String REST_URL = "http://localhost:8085/store";

	
	@GetMapping("/view")
	public String getAllStore(Model model, RestTemplate restTemplate) {
		ResponseEntity<Store[]> responseEntity = restTemplate.getForEntity(REST_URL, Store[].class);
		model.addAttribute("store", responseEntity.getBody());
		return "viewStore.html";
	}
	
	@GetMapping("/add")
	public String addStore() {
		return "addStore.html";
	}
	
	@PostMapping("/add")
	public String processingAddStore(@RequestParam String name, RestTemplate restTemplate) {
		Store store = Store.builder().name(name).build();
		restTemplate.postForLocation(REST_URL, store);
		return "addStore.html";
	}
	
}
