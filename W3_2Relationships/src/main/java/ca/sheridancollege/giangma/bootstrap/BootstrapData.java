package ca.sheridancollege.giangma.bootstrap;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.giangma.beans.Account;
import ca.sheridancollege.giangma.beans.AccountStatus;
import ca.sheridancollege.giangma.beans.Student;
import ca.sheridancollege.giangma.repository.AccountRepository;
import ca.sheridancollege.giangma.repository.StudentRepository;
import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
	
	private StudentRepository stuRepo;
	private AccountRepository accRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// Student s1a = new Student(1l, "Jon"); // USing constructor to make student
		Student s1b = new Student();
		s1b.setName("Kevin");
		
		Student s1 = Student.builder().name("Jon").id(null).build();
		Student s2 = Student.builder().name("Tod").build();
		
		Account a1 = Account.builder().accountNumber(123).balance(new BigDecimal(1000.0)).status(AccountStatus.APPROVE).build();

		Account a2 = Account.builder().accountNumber(223).balance(new BigDecimal(4000.0)).status(AccountStatus.UNDER_REVIEW).build();
		
		
		
		
		accRepo.save(a1);

		accRepo.save(a2);
		s1.setAccount(a1);
		s2.setAccount(a2);
	

		stuRepo.save(s1);

		stuRepo.save(s2);
		
		
		
		
		List<Student> students= stuRepo.findAll();
		
		for(Student test : students) {
		System.out.println("Name of the student: " + test.getName());	
		}
	}

}
