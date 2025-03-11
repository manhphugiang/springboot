package ca.sheridancollege.giangma.sevice;

import java.util.List;

import ca.sheridancollege.giangma.domain.Student;

public interface StudentService {
	
	public List<Student> findAll();
	public Student findById(Long id);
	public Student findByName(String name);
	public Student save(Student student);
	
	
	
}
