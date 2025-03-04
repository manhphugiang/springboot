package ca.sheridancollege.giangma.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.sheridancollege.giangma.beans.Student;
import ca.sheridancollege.giangma.repository.StudentRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {
	private StudentRepository stuRepo;
	
	@PostMapping(value= {""}, headers = {"Content-type=application/json"})
	public Student add(@RequestBody Student student) {
		student.setId(null);
		student.setGrade(student.getGrade());
		student.assignLetterGrade();
		stuRepo.save(student);
		return student;
	}
	
	@GetMapping("/{id}")
	public Student getStudents(@PathVariable long id){	
		Optional<Student> stu = stuRepo.findById(id);
		if(stu.isPresent())
			return stu.get();
		else
			return null;
	}
	
	@GetMapping(value= {"", "/"})
	public List<Student> getStudents(){
		return stuRepo.findAll();
	}
	
	@PutMapping(value="", headers = {"Content-type=application/json"})
	public String updateStudentList(@RequestBody List<Student> students) {
		List<Student> updateList = new ArrayList<Student>();
		for(Student s: students) {
			updateList.add(stuRepo.save(s));
		}
		return "Records Added:" + stuRepo.count();
	} 
	@PutMapping(value="/{id}", headers = {"Content-type=application/json"})
	public Student updateStudentListById(@RequestBody Student student, @PathVariable long id) {
		student.setId(id);
		return stuRepo.save(student);
	}
}
