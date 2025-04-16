package ca.sheridancollege.giangma.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.giangma.domain.Programmer;
import ca.sheridancollege.giangma.service.ProgrammerService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/programmers")
public class restController {
	
	private ProgrammerService progService;

	@PostMapping(value={"","/"}, headers = {"Content-type=application/json"})
	public Programmer addProgrammer(@RequestBody Programmer programmer) {
		programmer.setId(null);
		return progService.save(programmer);
	}
	
	@GetMapping(value={"","/"}, headers = {"Content-type=application/json"})
	public List<Programmer> getProgrammer() {
		return progService.findAll();
	}
	
	
	@GetMapping(value={"/{id}"}, headers = {"Content-type=application/json"})
	public Programmer getProgrammerById(@PathVariable long id) {
		return progService.findById(id);
	}
}
