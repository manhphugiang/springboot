package ca.sheridancollege.giangma.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.giangma.domain.Student;
import ca.sheridancollege.giangma.sevice.StudentService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
	private StudentService studentService;
		
	
	@PostMapping(value={"","/"}, headers = {"Content-type=application/json"})
	public Student addStudent(@RequestParam Student student) {
		student.setId(null);
		return studentService.save(student);
	}
	
	@GetMapping(value={"","/"}, headers = {"Content-type=application/json"})
	public List<Student> getStudentByName() {
		return studentService.findAll();
	}
	
	
	
}
