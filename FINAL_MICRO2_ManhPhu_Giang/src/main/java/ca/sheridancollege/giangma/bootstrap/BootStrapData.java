package ca.sheridancollege.giangma.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.giangma.domain.Shirt;
import ca.sheridancollege.giangma.service.ShirtService;
import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor

public class BootStrapData implements CommandLineRunner {
	private ShirtService shirtService;

	@Override
	public void run(String... args) throws Exception {
		shirtService.save(Shirt.builder().name("Nike").price(99.99).quantity(3).employeeName("Manh").build());
		shirtService.save(Shirt.builder().name("Adidas").price(59.99).quantity(9).employeeName("Phu").build());
		shirtService.save(Shirt.builder().name("Patagonia").price(12.99).quantity(33).employeeName("Giang").build());
		shirtService.save(Shirt.builder().name("Puma").price(39.99).quantity(1).employeeName("Manh").build());
		shirtService.save(Shirt.builder().name("Stussy").price(169.99).quantity(9).employeeName("Phu").build());
		shirtService.save(Shirt.builder().name("Supreme").price(999.99).quantity(23).employeeName("Giang").build());
		shirtService.save(Shirt.builder().name("Prada").price(129.99).quantity(39).employeeName("Manh").build());
		shirtService.save(Shirt.builder().name("Gucci").price(231.99).quantity(93).employeeName("Phu").build());
		shirtService.save(Shirt.builder().name("LV").price(342.99).quantity(57).employeeName("Giang").build());
		shirtService.save(Shirt.builder().name("Carhartt").price(22.99).quantity(63).employeeName("Giang").build());

	}

}
