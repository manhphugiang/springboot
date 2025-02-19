package ca.sheridancollege.giangma.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.giangma.beans.Cupcake;
import ca.sheridancollege.giangma.beans.Firefighter;
import ca.sheridancollege.giangma.repository.CupcakeRepository;
import ca.sheridancollege.giangma.repository.FirefighterRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

	private FirefighterRepository firefighterRepo;
	private CupcakeRepository cupcakeRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
        Firefighter f1 = Firefighter.builder().name("Thor").build();
        Firefighter f2 = Firefighter.builder().name("Loki").build();
        Firefighter f3 = Firefighter.builder().name("Odin").build();

        
        firefighterRepo.save(f1);
        firefighterRepo.save(f2);
        firefighterRepo.save(f3);
        
        
        Cupcake c1 = Cupcake.builder().cupcakeName("Vanila").price(9.99).quantity(10).employeeName(f1).build();
        Cupcake c2 = Cupcake.builder().cupcakeName("Chocolate").price(6.99).quantity(10).employeeName(f1).build();
        Cupcake c3 = Cupcake.builder().cupcakeName("Nutella").price(8.99).quantity(10).employeeName(f1).build();
        Cupcake c4 = Cupcake.builder().cupcakeName("Plain").price(999.99).quantity(10).employeeName(f2).build();
        Cupcake c5 = Cupcake.builder().cupcakeName("Strawberry").price(5.99).quantity(10).employeeName(f2).build();
        Cupcake c6 = Cupcake.builder().cupcakeName("Guava").price(4.99).quantity(10).employeeName(f2).build();
        Cupcake c7 = Cupcake.builder().cupcakeName("Passion Fruit").price(3.99).quantity(10).employeeName(f3).build();
        Cupcake c8 = Cupcake.builder().cupcakeName("Pineapple").price(2.99).quantity(10).employeeName(f3).build();
        Cupcake c9 = Cupcake.builder().cupcakeName("Dark Chocolate").price(1.99).quantity(10).employeeName(f3).build();
        Cupcake c10 = Cupcake.builder().cupcakeName("Pistachio").price(99.99).quantity(10).employeeName(f3).build();
        
        
        cupcakeRepo.save(c1);
        cupcakeRepo.save(c2);
        cupcakeRepo.save(c3);
        cupcakeRepo.save(c4);
        cupcakeRepo.save(c5);
        cupcakeRepo.save(c6);
        cupcakeRepo.save(c7);
        cupcakeRepo.save(c8);
        cupcakeRepo.save(c9);
        cupcakeRepo.save(c10);
        
	}

}
