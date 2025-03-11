package ca.sheridancollege.giangma.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.domain.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	Optional<Student> findByName(String name);
}
