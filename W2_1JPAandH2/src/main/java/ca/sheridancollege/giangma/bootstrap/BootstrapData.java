package ca.sheridancollege.giangma.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.giangma.beans.Videogame;
import ca.sheridancollege.giangma.repositories.VideogameRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
	
	private VideogameRepository vgRepo;
	
	@Override
	public void run(String... args) throws Exception{
		Videogame g1 = new Videogame("Dead Space", 124, "Horror", 39.99);
		Videogame g2 = new Videogame("Dead Space 2", 434, "Horror", 59.99);
		Videogame g3 = new Videogame("Dead Space 3", 724, "Horror", 79.99);
		Videogame g4 = new Videogame("Mario Kart", 432, "Arcade",99.99);
		Videogame g5 = new Videogame("Resident Friendly", 654, "Horror", 19.99);
		
		
		vgRepo.save(g1);
		vgRepo.save(g2);
		vgRepo.save(g3);
		vgRepo.save(g4);
		vgRepo.save(g5);
	}
}
