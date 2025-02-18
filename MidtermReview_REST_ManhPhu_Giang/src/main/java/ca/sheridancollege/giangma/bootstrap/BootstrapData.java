package ca.sheridancollege.giangma.bootstrap;

import org.springframework.boot.CommandLineRunner;

import ca.sheridancollege.giangma.beans.Item;
import ca.sheridancollege.giangma.beans.Store;
import ca.sheridancollege.giangma.repository.ItemRepository;
import ca.sheridancollege.giangma.repository.StoreRepository;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

	private StoreRepository storeRepo;
	private ItemRepository itemRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
        Store s1 = Store.builder().name("Thor").build();
        Store s2 = Store.builder().name("Loki").build();
        Store s3 = Store.builder().name("Iron Man").build();
        Store s4 = Store.builder().name("Mobius").build();
        Store s5 = Store.builder().name("Alice").build();
    	
        storeRepo.save(s1);
        storeRepo.save(s2);
        storeRepo.save(s3);
        storeRepo.save(s4);
        storeRepo.save(s5);

        Item i1 = Item.builder().name("MacBook Air M1").price(199.99).store(s1).build();
        Item i2 = Item.builder().name("iPhone 15").price(999.99).store(s2).build();
        Item i3 = Item.builder().name("Samsung Galaxy S24").price(899.99).store(s3).build();
        Item i4 = Item.builder().name("Dell XPS 15").price(1299.99).store(s4).build();
        Item i5 = Item.builder().name("Sony WH-1000XM5").price(349.99).store(s5).build();
        Item i6 = Item.builder().name("Nintendo Switch OLED").price(349.99).store(s1).build();
        Item i7 = Item.builder().name("Apple Watch Series 9").price(429.99).store(s2).build();
        Item i8 = Item.builder().name("Google Pixel 8 Pro").price(999.99).store(s3).build();
        Item i9 = Item.builder().name("ASUS ROG Strix G16").price(1599.99).store(s4).build();
        Item i10 = Item.builder().name("Bose QuietComfort Earbuds II").price(279.99).store(s5).build();

        itemRepo.save(i1);
        itemRepo.save(i2);
        itemRepo.save(i3);
        itemRepo.save(i4);
        itemRepo.save(i5);
        itemRepo.save(i6);
        itemRepo.save(i7);
        itemRepo.save(i8);
        itemRepo.save(i9);
        itemRepo.save(i10);

        
        
	}

}
