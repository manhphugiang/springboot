package ca.sheridancollege.giangma.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.giangma.beans.Item;
import ca.sheridancollege.giangma.repository.ItemRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/item")
public class ItemRestController {
	private ItemRepository itemRepo;
	
	@GetMapping(value= {"", "/"})
	public List<Item> getAllItem(){
		List<Item> l1 = itemRepo.findAll();
		return l1;
	}
	
	@GetMapping("/{id}")
	public Item getItemById(@PathVariable long id){
		Optional<Item> i1 = itemRepo.findById(id);
		
		if(i1.isPresent())
			return i1.get();
		else
			return null;
	}
	
	@PostMapping(value= {""}, headers = {"Content-type=application/json"})
	public Item processingAddItem(@RequestBody Item item) {
		item.setId(null);
		item.setName(item.getName());
		item.setPrice(item.getPrice());
		item.setStore(item.getStore());
		itemRepo.save(item);
		return item;
	}
	
	
	@PutMapping(value="/{id}", headers = {"Content-type=application/json"})
	public Item editItemById(@RequestBody Item item, @PathVariable long id) {
		item.setId(id);
		return itemRepo.save(item);
	}
	
	@DeleteMapping(value="/{id}")
	public String deleteItemById(@PathVariable long id) {
		itemRepo.deleteById(id);
		return "Deleted" + id;
	}
	
	
}
