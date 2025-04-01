package ca.sheridancollege.giangma.service;

import java.util.List;

import ca.sheridancollege.giangma.domain.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	public Employee findById(Long id);
	public Employee save(Employee employee);
	
}
