package ca.sheridancollege.giangma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.giangma.beans.User;

@Repository
public interface userRepository extends JpaRepository<User, Long> {
	public Optional<User> findByEmail(String email);
}