package ca.sheridancollege.giangma.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.giangma.domain.Employee;
import ca.sheridancollege.giangma.domain.Item;
import ca.sheridancollege.giangma.service.EmployeeService;
import ca.sheridancollege.giangma.service.ItemService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DataBootsrap implements CommandLineRunner{
	
	private EmployeeService emplService;
	private ItemService itemService;
	
	public void run(String... args) throws Exception{
		
		emplService.save(Employee.builder().name("Manh").build());
		emplService.save(Employee.builder().name("Phu").build());
		emplService.save(Employee.builder().name("Giang").build());
		
		itemService.save(Item.builder().name("Laptop").employeeName("Manh").price(123.99).quantity(3).build());
		itemService.save(Item.builder().name("Mouse").employeeName("Phu").price(25.50).quantity(10).build());
		itemService.save(Item.builder().name("Keyboard").employeeName("Giang").price(45.99).quantity(5).build());
		itemService.save(Item.builder().name("Monitor").employeeName("Manh").price(199.99).quantity(2).build());
		itemService.save(Item.builder().name("Headphones").employeeName("Phu").price(79.99).quantity(4).build());
		itemService.save(Item.builder().name("Phone").employeeName("Giang").price(899.99).quantity(1).build());
		itemService.save(Item.builder().name("Tablet").employeeName("Manh").price(349.99).quantity(2).build());
		itemService.save(Item.builder().name("Printer").employeeName("Phu").price(120.00).quantity(3).build());
		itemService.save(Item.builder().name("External HDD").employeeName("Giang").price(89.99).quantity(6).build());
		itemService.save(Item.builder().name("USB Drive").employeeName("Manh").price(15.99).quantity(20).build());
		itemService.save(Item.builder().name("Webcam").employeeName("Phu").price(55.00).quantity(3).build());

		
	}
}
