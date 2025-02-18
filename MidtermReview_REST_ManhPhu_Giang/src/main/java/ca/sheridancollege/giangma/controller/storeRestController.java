package ca.sheridancollege.giangma.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.giangma.beans.Store;
import ca.sheridancollege.giangma.repository.StoreRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/store")
public class storeRestController {
	
	private StoreRepository storeRepo;
	
	@GetMapping(value= {"", "/"})
	public List<Store> getAllStore(){
		List<Store> l1 = storeRepo.findAll();
		return l1;
	}
	
	@GetMapping("/{id}")
	public Store getStoreById(@PathVariable long id){
		Optional<Store> s1 = storeRepo.findById(id);
		
		if(s1.isPresent())
			return s1.get();
		else
			return null;
	}
	
	@PostMapping(value= {""}, headers = {"Content-type=application/json"})
	public Store processingAddStore(@RequestBody Store store) {
		store.setId(null);
		store.setName(store.getName());
		storeRepo.save(store);
		return store;
	}
	
	
	
}

