package ca.sheridancollege.giangma.beans.bootstrap;



import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.giangma.beans.Player;
import ca.sheridancollege.giangma.repository.PlayerRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
	
	private PlayerRepository pRepo;
	
	@Override
	public void run(String... args) throws Exception{
		Player g1 = new Player("Dead Space", 124, "Healer");
		Player g2 = new Player("Shadow Blade", 532, "Tank");
		Player g3 = new Player("Crimson Fury", 2983, "Melee DPS");
		Player g4 = new Player("Frost Reaper", 1278, "Ranged DPS");
		Player g5 = new Player("Divine Light", 876, "Healer");
		Player g6 = new Player("Storm Breaker", 4500, "Tank");
		Player g7 = new Player("Phantom Strike", 645, "Melee DPS");
		Player g8 = new Player("Inferno Mage", 3391, "Ranged DPS");
		Player g9 = new Player("Celestial Guard", 9230, "Healer");
		Player g10 = new Player("Iron Bastion", 7123, "Tank");
		Player g11 = new Player("Arcane Hunter", 1874, "Ranged DPS");

		pRepo.save(g1);
		pRepo.save(g2);
		pRepo.save(g3);
		pRepo.save(g4);
		pRepo.save(g5);
		pRepo.save(g6);
		pRepo.save(g7);
		pRepo.save(g8);
		pRepo.save(g9);
		pRepo.save(g10);
		pRepo.save(g11);
		
	
	}

}
