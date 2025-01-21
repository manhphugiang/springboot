package ca.sheridancollege.giangma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.beans.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
	public List<Player> findByOrderByIdAsc();
	public List<Player> findByOrderByNameAsc();
    public List<Player> findByOrderByGuildPointAsc();
    public List<Player> findByOrderByUnitClassAsc();
}



