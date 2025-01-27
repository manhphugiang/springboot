package ca.sheridancollege.giangma.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.beans.Account;
@Repository
public interface AccountRepository extends JpaRepositoryImplementation<Account, Long> {

}
