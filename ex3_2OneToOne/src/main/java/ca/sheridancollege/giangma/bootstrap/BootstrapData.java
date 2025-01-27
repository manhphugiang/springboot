package ca.sheridancollege.giangma.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.giangma.beans.Guest;
import ca.sheridancollege.giangma.beans.Pet;
import ca.sheridancollege.giangma.repository.guestRepository;
import ca.sheridancollege.giangma.repository.petRepository;
import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
	private guestRepository guestRepo;
	private petRepository petRepo;
	@Override
	public void run(String... args) throws Exception {
		Guest g1 = Guest.builder().name("Manh").age(23).build();
		Guest g2 = Guest.builder().name("Alice").age(30).build();
		Guest g3 = Guest.builder().name("Bob").age(25).build();
		Guest g4 = Guest.builder().name("Charlie").age(35).build();
		Guest g5 = Guest.builder().name("Diana").age(28).build();
		Guest g6 = Guest.builder().name("Edward").age(40).build();
		Guest g7 = Guest.builder().name("Fiona").age(22).build();
		Guest g8 = Guest.builder().name("George").age(32).build();
		Guest g9 = Guest.builder().name("Hannah").age(27).build();
		Guest g10 = Guest.builder().name("Ian").age(45).build();

		Pet p1 = Pet.builder().guest(g1).name("Mobius").species("Chihuahua").build();
		Pet p2 = Pet.builder().guest(g3).name("Hulk").species("Husky").build();
		Pet p3 = Pet.builder().guest(g4).name("Loki").species("German Shepherd").build();
		Pet p4 = Pet.builder().guest(g7).name("Audi").species("Japanese Cat").build();
		Pet p5 = Pet.builder().guest(g10).name("Thor").species("Croissant").build();
		
		
		guestRepo.save(g1);
		guestRepo.save(g2);
		guestRepo.save(g3);
		guestRepo.save(g4);
		guestRepo.save(g5);
		guestRepo.save(g6);
		guestRepo.save(g7);
		guestRepo.save(g8);
		guestRepo.save(g9);
		guestRepo.save(g10);
		
		petRepo.save(p1);
		petRepo.save(p2);
		petRepo.save(p3);
		petRepo.save(p4);
		petRepo.save(p5);

	}

}
