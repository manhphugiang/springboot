package ca.sheridancollege.giangma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.beans.Cupcake;
@Repository
public interface CupcakeRepository extends JpaRepository<Cupcake, Long> {

}
