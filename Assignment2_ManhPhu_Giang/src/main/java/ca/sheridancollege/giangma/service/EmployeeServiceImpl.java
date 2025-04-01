package ca.sheridancollege.giangma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.sheridancollege.giangma.domain.Employee;
import ca.sheridancollege.giangma.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeRepository emplRepo;

	@Override
	public List<Employee> findAll() {
		return emplRepo.findAll();
	}

	@Override
	public Employee findById(Long id) {
		if (emplRepo.findById(id).isPresent()) {
			return emplRepo.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public Employee save(Employee employee) {
		return emplRepo.save(employee);
	}
	
}
