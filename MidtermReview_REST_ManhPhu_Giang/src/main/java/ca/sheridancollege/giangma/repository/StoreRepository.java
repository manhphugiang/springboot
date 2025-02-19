package ca.sheridancollege.giangma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.beans.Store;
@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
	   Store findByName(String name); 
}

