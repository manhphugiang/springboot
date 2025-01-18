package ca.sheridancollege.giangma.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.beans.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
}
