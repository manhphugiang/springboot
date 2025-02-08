package ca.sheridancollege.giangma.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.giangma.bean.Player;
import ca.sheridancollege.giangma.repository.*;
import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
	
    private playerRepository playerRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
        for (int i = 1; i <= 10; i++) {
            Player player = playerRepository.save(Player.builder()
                    .name("Player" + i)
                    .playerClass("Class" + i)
                    .gamePlayed((int) (Math.random() * 50 + 10))
                    .gameWon((int) (Math.random() * 30 + 5))
                    .gameLost((int) (Math.random() * 20 + 5))
                    .point((int) (Math.random() * 500 + 100))
                    .build());
            
            player.setPoint(player.getPoint());
            playerRepository.save(player);
        }
	}

}
