package ca.sheridancollege.giangma.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.giangma.beans.Player;
import ca.sheridancollege.giangma.repository.PlayerRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner{
	private PlayerRepository playerRepo;
	
	@Override
	public void run(String... args) throws Exception{
		Player p1 = new Player("Henry", 23, 34, 4, 32);
	    Player p2 = new Player("James", 25, 30, 5, 54);
	    Player p3 = new Player("Sophia", 22, 28, 3, 86);
	    Player p4 = new Player("Lucas", 24, 36, 6, 234);
	    Player p5 = new Player("Emma", 21, 25, 4, 299);
	    Player p6 = new Player("Oliver", 27, 33, 5, 123);
	    Player p7 = new Player("Isabella", 26, 31, 4, 345);
	    Player p8 = new Player("Ethan", 23, 29, 3, 476);
	    Player p9 = new Player("Mia", 22, 26, 4, 599);
	    Player p10 = new Player("Liam", 25, 34, 6, 705);
	    Player p11 = new Player("Ava", 24, 30, 5, 618);
	    Player p12 = new Player("Noah", 28, 35, 7, 838);
	    Player p13 = new Player("Charlotte", 23, 32, 4, 1667);
	    Player p14 = new Player("Amelia", 22, 27, 3, 2554);
	    Player p15 = new Player("Mason", 26, 33, 6, 3682);

	    playerRepo.save(p1);
	    playerRepo.save(p2);
	    playerRepo.save(p3);
	    playerRepo.save(p4);
	    playerRepo.save(p5);
	    playerRepo.save(p6);
	    playerRepo.save(p7);
	    playerRepo.save(p8);
	    playerRepo.save(p9);
	    playerRepo.save(p10);
	    playerRepo.save(p11);
	    playerRepo.save(p12);
	    playerRepo.save(p13);
	    playerRepo.save(p14);
	    playerRepo.save(p15);
	}
}
