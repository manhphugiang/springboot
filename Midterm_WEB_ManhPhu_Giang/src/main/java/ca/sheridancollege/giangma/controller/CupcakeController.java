package ca.sheridancollege.giangma.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.giangma.beans.Cupcake;
import ca.sheridancollege.giangma.beans.Firefighter;



@Controller
public class CupcakeController {

	private final String RESTCupcake_URL = "http://localhost:8085/item";
	private final String RESTEmployee_URL = "http://localhost:8085/employee";
	
	@GetMapping("/viewCupcake")
	public String getAllCupcake(Model model, RestTemplate restTemplate) {
	ResponseEntity<Cupcake[]> responseEntity = restTemplate.getForEntity(RESTCupcake_URL, Cupcake[].class);
	model.addAttribute("cupcake", responseEntity.getBody());
	return "viewCupcake.html";
	}
	
	@GetMapping("/addCupcake")
	public String addCupcake(Model model, RestTemplate restTemplate) {
		ResponseEntity<Firefighter[]> responseEntity = restTemplate.getForEntity(RESTEmployee_URL, Firefighter[].class);
		model.addAttribute("employeeList", responseEntity.getBody());
		return "addCupcake.html";
	}
	
	@PostMapping("/addCupcake")
	public String processingAddItem(@RequestParam String cupcakeName,
	                                 @RequestParam double price,
	                                 @RequestParam int quantity,
	                                 @RequestParam String employeeName,
	                                 RestTemplate restTemplate) {
	    Map<String, Object> requestData = new HashMap<>();
	    requestData.put("cupcakeName", cupcakeName);
	    requestData.put("price", price);
	    requestData.put("quantity", quantity);
	    requestData.put("employeeName", employeeName);

	    restTemplate.postForLocation(RESTCupcake_URL, requestData);

	    return "redirect:/addCupcake";
	}

	
	
	
	@GetMapping("/purchaseItem/{id}")
	public String buyCupcakeById(@PathVariable long id, RestTemplate restTemplate) {
	    restTemplate.put(RESTCupcake_URL + "/" + id, null);

	    return "redirect:/viewCupcake";
	}


	
	
	@GetMapping("/deleteCupcake/{id}")
	public String deleteCupcakeWithId(@PathVariable long id, RestTemplate restTemplate) {
		restTemplate.delete(RESTCupcake_URL + "/" + id);
		return "redirect:/viewCupcake";
	}
	
	
}
