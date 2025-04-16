package ca.sheridancollege.giangma.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.giangma.domain.Shirt;
import ca.sheridancollege.giangma.service.ShirtService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/shirts")
public class restController {
	
	private ShirtService shirtService;
	
	
	@PostMapping(value={"","/"}, headers = {"Content-type=application/json"})
	public Shirt addShirt(@RequestBody Shirt shirt) {
		shirt.setId(null);
		return shirtService.save(shirt);
	}
	
	@GetMapping(value={"","/"}, headers = {"Content-type=application/json"})
	public List<Shirt> getShirt() {
		return shirtService.findAll();
	}
	
	
	@GetMapping(value={"/{id}"}, headers = {"Content-type=application/json"})
	public Shirt getShirtById(@PathVariable long id) {
		return shirtService.findById(id);
	}
	
	@PostMapping(value={"/edit/{id}"}, headers = {"Content-type=application/json"})
	public Shirt editShirt(@RequestBody Shirt shirt, @PathVariable long id) {
	    return shirtService.editById(shirt, id);

	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		shirtService.deleteById(id);
	}
	
}
