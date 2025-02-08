package ca.sheridancollege.giangma.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.giangma.beans.Student;

@Controller
public class StudentController {
	
	private final String REST_URL = "http://localhost:8080/students";
	
	@GetMapping("/")
	public String root() {
		return "root.html";
	}
	@GetMapping("/view")
	public String viewStudents(Model model, RestTemplate restTemplate) {
		ResponseEntity<Student[]> responeEntity = restTemplate.getForEntity(REST_URL, Student[].class);
		
		model.addAttribute("meow", responeEntity.getBody());
		return "view.html";
	}
	
	
	
	@GetMapping("/add")
	public String goAdd() {
		return "add.html";
	}
	
	@PostMapping("/add")
	public String processAdd(@RequestParam String name,
								@RequestParam int grade,
								RestTemplate restTemplate) {
		Student student = Student.builder().name(name).grade(grade).build();
		restTemplate.postForLocation(REST_URL, student);
		return "add.html";
	}
	
	@GetMapping("/edit/{id}")
	public String getEdit(@PathVariable int id, Model model, RestTemplate restTemplate) {
		ResponseEntity<Student> responseEntity =
				restTemplate.getForEntity( REST_URL + "/" + id, Student.class);
		
		model.addAttribute("student", responseEntity.getBody());
		return "edit.html";
	}

	@PostMapping("/{id}")
	public String processEdit(@ModelAttribute Student student,
								RestTemplate restTemplate) {
		//Student student = Student.builder().id(id).name(name).grade(grade).build();
		//restTemplate.postForLocation(REST_URL, student);
		restTemplate.put(REST_URL, student);
		return "view.html";
	}
}
