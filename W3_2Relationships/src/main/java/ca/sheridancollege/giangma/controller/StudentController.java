package ca.sheridancollege.giangma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.giangma.repository.AccountRepository;
import ca.sheridancollege.giangma.repository.StudentRepository;
import lombok.*;

@Controller
@AllArgsConstructor
public class StudentController {

	private StudentRepository stuRepo;
	private AccountRepository accRepo;
	
	@GetMapping("/")
	public String iAmRoot(Model model) {
		model.addAttribute("meow", stuRepo.findAll());
		model.addAttribute("meowmeow", stuRepo.findAll());

		return "viewAccounts.html";
	}
}
