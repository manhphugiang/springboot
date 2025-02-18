package ca.sheridancollege.giangma.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.giangma.beans.Item;
import ca.sheridancollege.giangma.beans.Store;


@Controller
public class ItemController {

	private final String RESTItem_URL = "http://localhost:8085/item";
	private final String RESTStore_URL = "http://localhost:8085/store";
	
	@GetMapping("/viewItem")
	public String getAllItem(Model model, RestTemplate restTemplate) {
	ResponseEntity<Item[]> responseEntity = restTemplate.getForEntity(RESTItem_URL, Item[].class);
	model.addAttribute("item", responseEntity.getBody());
	return "viewItem.html";
	}
	
	@GetMapping("/addItem")
	public String addItem(Model model, RestTemplate restTemplate) {
		ResponseEntity<Store[]> responseEntity = restTemplate.getForEntity(RESTStore_URL, Store[].class);
		model.addAttribute("storeList", responseEntity.getBody());
		return "addItem.html";
	}
	
	@PostMapping("/addItem")
	public String processingAddItem(@RequestParam String name,
									@RequestParam double price,
	                                 @RequestParam(required = false) Long storeId,
									RestTemplate restTemplate) {
		ResponseEntity<Store> responseEntity = restTemplate.getForEntity(RESTStore_URL + "/" + storeId, Store.class);

		Store s1 = responseEntity.getBody();
		
		
		Item item= Item.builder().name(name).price(price).store(s1).build();
		
		restTemplate.postForLocation(RESTItem_URL, item);
		return "redirect:/addItem";
	}
	
	
	@GetMapping("/editItem/{id}")
	public String getEditItemById(@PathVariable long id, Model model, RestTemplate restTemplate) {
		
		ResponseEntity<Item> responseEntity = restTemplate.getForEntity(RESTItem_URL + "/" + id, Item.class);
		model.addAttribute("item", responseEntity.getBody());
		ResponseEntity<Store[]> responseEntity2 = restTemplate.getForEntity(RESTStore_URL, Store[].class);
		model.addAttribute("storeList", responseEntity2.getBody());
		return "editItem.html";
	}
	
	@PostMapping("/editItem/{id}")
	public String processingEditItem(@PathVariable long id,
									@RequestParam String name,
									@RequestParam double price,
	                                 @RequestParam(required = false) Long storeId,
									RestTemplate restTemplate) {
		ResponseEntity<Store> responseEntity = restTemplate.getForEntity(RESTStore_URL + "/" + storeId, Store.class);

		Store s1 = responseEntity.getBody();
		
		
		Item item= Item.builder().name(name).price(price).store(s1).build();
		
	    restTemplate.put(RESTItem_URL + "/" + id, item);
	    
	    
		return "redirect:/viewItem";
	}
	
	@GetMapping("/deleteItem/{id}")
	public String deleteItemWithId(@PathVariable long id, RestTemplate restTemplate) {
		restTemplate.delete(RESTItem_URL + "/" + id);
		return "redirect:/viewItem";
	}
	
	
	
	
	
	
	
}
