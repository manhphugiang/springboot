package ca.sheridancollege.giangma.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.giangma.beans.Store;
import ca.sheridancollege.giangma.repository.StoreRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class storeRestController {
	
	private StoreRepository storeRepo;
	
	@GetMapping("/view")
	public List<Store> getAllStore(){
		List<Store> l1 = storeRepo.findAll();
		return l1;
	}
	
	@GetMapping("/view/{id}")
	public Store getStoreById(@PathVariable long id){
		Optional<Store> s1 = storeRepo.findById(id);
		
		if(s1.isPresent())
			return s1.get();
		else
			return null;
	}
	
	@PostMapping("/add")
	public Store processingAddStore(@RequestBody Store store) {
		store.setId(null);
		store.setName(store.getName());
		storeRepo.save(store);
		return store;
	}
	
	
	
}

