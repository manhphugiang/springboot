package ca.sheridancollege.giangma.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.beans.Videogame;
@Repository
public interface VideogameRepository extends JpaRepository<Videogame, Integer> {
	public List<Videogame> findByTitleContainingIgnoreCase(String title);
	public List<Videogame> findByPriceLessThan(double price);
	
//	@Query("Select g from videogame g where Lower(g.title) = Lower(:title)")
	// public Videogame retrieveIgnoringCase(@Param("title") String title);
}
