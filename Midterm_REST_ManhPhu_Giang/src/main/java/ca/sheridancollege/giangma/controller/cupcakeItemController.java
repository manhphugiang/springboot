package ca.sheridancollege.giangma.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.giangma.beans.Cupcake;
import ca.sheridancollege.giangma.beans.Firefighter;
import ca.sheridancollege.giangma.repository.CupcakeRepository;
import ca.sheridancollege.giangma.repository.FirefighterRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/item")
public class cupcakeItemController {
	
	private CupcakeRepository cupcakeRepo;
	private FirefighterRepository firefighterRepo;
	@GetMapping(value= {"", "/"})
	public List<Cupcake> getAllItem(){
		List<Cupcake> l1 = cupcakeRepo.findAll();
		return l1;
	}
	
	@GetMapping("/{id}")
	public Cupcake getItemById(@PathVariable long id){
		Optional<Cupcake> i1 = cupcakeRepo.findById(id);
		
		if(i1.isPresent())
			return i1.get();
		else
			return null;
	}
	

	@PostMapping(value = "", headers = "Content-type=application/json")
	public Cupcake processingAddItem(@RequestBody Map<String, Object> requestData) {
	    String cupcakeName = (String) requestData.get("cupcakeName");
	    double price = Double.parseDouble(requestData.get("price").toString());
	    String employeeName = (String) requestData.get("employeeName");
	    int quantity = Integer.parseInt(requestData.get("quantity").toString());
	    		
	    		
	    Firefighter firefighter = firefighterRepo.findByName(employeeName);
	    if (firefighter == null) {
	        throw new RuntimeException("firefighter not found");
	    }

	    Cupcake item = new Cupcake();
	    item.setCupcakeName(cupcakeName);
	    item.setPrice(price);
	    item.setQuantity(quantity);
	    
	    item.setEmployeeName(firefighter);

	    return cupcakeRepo.save(item);
	}
	

	
	@PutMapping(value = "/{id}")
	public Cupcake buyCupcakeById(@PathVariable long id) {
		
	    Cupcake existingCupcake = cupcakeRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Cupcake not found with id: " + id));

	    // buy 1
	    existingCupcake.setQuantity(existingCupcake.getQuantity() - 1);

	    return cupcakeRepo.save(existingCupcake);
	}


	
	@DeleteMapping(value="/{id}")
	public String deleteCupcakeById(@PathVariable long id) {
		cupcakeRepo.deleteById(id);
		return "Deleted " + id;
	}
	
	
	
}
