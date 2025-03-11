package ca.sheridancollege.giangma.Bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.giangma.domain.Student;
import ca.sheridancollege.giangma.sevice.StudentService;
import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class StudentBootstrap implements CommandLineRunner {
	private StudentService studentService;
	@Override
	public void run(String... args) throws Exception {

		studentService.save(Student.builder().name("Jon").age(22).build());
		studentService.save(Student.builder().name("Ann").age(23).build());
		studentService.save(Student.builder().name("Tod").age(24).build());
		
		
	}
}
