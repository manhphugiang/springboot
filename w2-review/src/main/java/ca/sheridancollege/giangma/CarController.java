package ca.sheridancollege.giangma;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
 
import ca.sheridancollege.giangma.beans.Car;

@Controller
public class CarController {
	
	public static ArrayList<Car> cars = new ArrayList<Car>();
	
	@GetMapping("/")
	public String iAmRoot() {
		return "home.html";
	}
	
	@GetMapping("/add")
	public String loadAddCar(Model model) {
		model.addAttribute("car", new Car());
		return "addCar.html";
	}
	
	@PostMapping("/add")
	public String processingAddCar(@ModelAttribute Car car){
		cars.add(car);
		System.out.println(car.toString());
		System.out.print(cars.toString());
		return "redirect:/add";		
	}


	@GetMapping("view")
	public String loadView(Model model) {
		model.addAttribute("carToList", cars);
		
		return "viewCars.html";
	}
}
