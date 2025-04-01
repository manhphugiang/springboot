package ca.sheridancollege.giangma.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.giangma.domain.Employee;
import ca.sheridancollege.giangma.service.EmployeeService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class RestEmployeeController {

	private EmployeeService emplService;
	
	@PostMapping(value={"","/"}, headers = {"Content-type=application/json"})
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(null);
		return emplService.save(employee);
	}
	
	@GetMapping(value={"","/"}, headers = {"Content-type=application/json"})
	public List<Employee> getEmployee() {
		return emplService.findAll();
	}
	
	
	@GetMapping(value={"/{id}"}, headers = {"Content-type=application/json"})
	public Employee getEmployeeById(@PathVariable long id) {
		return emplService.findById(id);
	}
	
}
