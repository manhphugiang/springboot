package ca.sheridancollege.giangma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.domain.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
