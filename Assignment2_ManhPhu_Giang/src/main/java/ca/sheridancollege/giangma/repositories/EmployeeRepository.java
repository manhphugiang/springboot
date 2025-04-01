package ca.sheridancollege.giangma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.domain.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
