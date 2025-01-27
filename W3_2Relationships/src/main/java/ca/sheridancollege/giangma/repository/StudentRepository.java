package ca.sheridancollege.giangma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.beans.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	public List<Student> findByAccount_IdIsNotNull();
}
