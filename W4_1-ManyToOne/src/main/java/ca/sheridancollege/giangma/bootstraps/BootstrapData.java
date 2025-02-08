package ca.sheridancollege.giangma.bootstraps;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.giangma.beans.Employee;
import ca.sheridancollege.giangma.beans.Store;
import ca.sheridancollege.giangma.beans.Videogame;
import ca.sheridancollege.giangma.repository.employeeRepository;
import ca.sheridancollege.giangma.repository.storeRepository;
import ca.sheridancollege.giangma.repository.VideogameRepository;

import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

	private storeRepository storeRepo;
	private employeeRepository empRepo;
    private VideogameRepository gameRepo;

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
		
		

		Videogame g1 = Videogame.builder().name("The Legend of Zelda").stores(Arrays.asList(s1)).build();

		Videogame g2 = Videogame.builder().name("Call of Duty").stores(Arrays.asList(s1)).build();

		Videogame g3 = Videogame.builder().name("Minecraft").stores(Arrays.asList(s2)).build();
	
		Videogame g4 = Videogame.builder().name("Grand Theft Auto V").stores(Arrays.asList(s2)).build();

		Videogame g5 = Videogame.builder().name("Mario Bro").stores(Arrays.asList(s1)).build();

		Videogame g6 = Videogame.builder().name("PUBG").stores(Arrays.asList(s1)).build();

		Videogame g7 = Videogame.builder().name("Racing Weelchair").stores(Arrays.asList(s2)).build();
	
		Videogame g8 = Videogame.builder().name("Grand Theft Auto Vine City").stores(Arrays.asList(s2)).build();

		Videogame g9 = Videogame.builder().name("Agar IO").stores(Arrays.asList(s1)).build();

		Videogame g10 = Videogame.builder().name("Apple Car").stores(Arrays.asList(s1)).build();

	        
        gameRepo.save(g1);
        gameRepo.save(g2);
        gameRepo.save(g3);
        gameRepo.save(g4);
        gameRepo.save(g5);
        gameRepo.save(g6);
        gameRepo.save(g7);
        gameRepo.save(g8);
        gameRepo.save(g9);
        gameRepo.save(g10);

	}
}
