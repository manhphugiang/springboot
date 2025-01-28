package ca.sheridancollege.giangma.bootstraps;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.giangma.beans.Employee;
import ca.sheridancollege.giangma.beans.Store;
import ca.sheridancollege.giangma.repository.employeeRepository;
import ca.sheridancollege.giangma.repository.storeRepository;
import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

	private storeRepository storeRepo;
	private employeeRepository empRepo;
	@Override
	public void run(String... args) throws Exception {
		Store s1 = Store.builder().name("Store 1").build();
		Store s2 = Store.builder().name("Store 2").build();
		storeRepo.save(s1);
		storeRepo.save(s2);
		Employee e1 = Employee.builder().name("Jack").store(s1).build();	
		Employee e2 = Employee.builder().name("Jill").store(s1).build();
		Employee e3 = Employee.builder().name("John").store(s1).build();
		Employee e4 = Employee.builder().name("Jane").store(s2).build();
		Employee e5 = Employee.builder().name("Mike").store(s2).build();



		empRepo.save(e1);
		empRepo.save(e2);
		empRepo.save(e3);
		empRepo.save(e4);
		empRepo.save(e5);
		
		Employee e6 = Employee.builder().name("Sara").build();

		empRepo.save(e6);
	}
}
