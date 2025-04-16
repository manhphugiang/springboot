package ca.sheridancollege.giangma.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.giangma.domain.Programmer;
import ca.sheridancollege.giangma.service.ProgrammerService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

	private ProgrammerService progService;
	@Override
	public void run(String... args) throws Exception {
		progService.save(Programmer.builder().name("Manh").build());
		progService.save(Programmer.builder().name("Phu").build());
		progService.save(Programmer.builder().name("Giang").build());
	}

}
