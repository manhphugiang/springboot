package ca.sheridancollege.giangma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.beans.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
	
}



