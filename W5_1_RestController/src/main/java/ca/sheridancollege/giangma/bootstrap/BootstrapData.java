package ca.sheridancollege.giangma.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.giangma.beans.Student;
import ca.sheridancollege.giangma.repository.StudentRepository;
import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor

public class BootstrapData implements CommandLineRunner {
	private StudentRepository stuRepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		for(int i = 1; i <=10; i++) {
			Student s = stuRepo.save(Student.builder().name("Student" + i)
					.grade((int)(Math.random()*100+30))
					.build());
			s.setGrade(s.getGrade());
			s.assignLetterGrade();
			stuRepo.save(s);
		}
		
	}

}
