package ca.sheridancollege.giangma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.giangma.beans.Employee;
import ca.sheridancollege.giangma.beans.Store;
import ca.sheridancollege.giangma.repository.employeeRepository;
import ca.sheridancollege.giangma.repository.storeRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class StoreController {
	
	private storeRepository storeRepo;
	private employeeRepository empRepo;

	@GetMapping("/")
	public String getHomePage(Model model) {
		
//		Store s = storeRepo.findById(1).get();
//		Employee e = empRepo.findById(6).get();
//		e.setStore(s);
//		empRepo.save(e);
		
		//Employee e2 = empRepo.findById(4).get();
	//	empRepo.deleteById(4);
//		
//		
//		for(Employee em: storeRepo.findById(2).get().getEmployees()) {
//			em.setStore(null);
//		}
//		storeRepo.deleteById(2);
//		
		model.addAttribute("storeList", storeRepo.findAll());
		
		return "view.html";
	}	
}
