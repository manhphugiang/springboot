package ca.sheridancollege.giangma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.beans.Videogame;
@Repository
public interface VideogameRepository extends JpaRepository<Videogame, Integer> {

}
