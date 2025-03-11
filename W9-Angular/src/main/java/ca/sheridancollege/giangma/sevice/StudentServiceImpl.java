package ca.sheridancollege.giangma.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ca.sheridancollege.giangma.domain.Student;
import ca.sheridancollege.giangma.repositories.StudentRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepo;

	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public Student findById(Long id) {
		if (studentRepo.findById(id).isPresent()) {
			return studentRepo.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public Student findByName(String name) {
		if (studentRepo.findByName(name).isPresent()) {
			return studentRepo.findByName(name).get();
		} else {
			return null;
		}
	}

	@Override
	public Student save(Student student) {
		return studentRepo.save(student);
	}
}
