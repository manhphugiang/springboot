package ca.sheridancollege.giangma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.domain.Shirt;
@Repository
public interface ShirtRepository extends JpaRepository<Shirt, Long>{

}
