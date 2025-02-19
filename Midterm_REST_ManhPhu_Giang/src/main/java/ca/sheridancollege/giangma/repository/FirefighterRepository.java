package ca.sheridancollege.giangma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.beans.Firefighter;
@Repository
public interface FirefighterRepository extends JpaRepository<Firefighter, Long> {
	Firefighter findByName(String name);
}
