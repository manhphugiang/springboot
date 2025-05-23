package ca.sheridancollege.giangma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.domain.Programmer;
@Repository
public interface ProgrammerRepository extends JpaRepository<Programmer, Long>{

}
