package ca.sheridancollege.giangma.service;

import java.util.List;

import ca.sheridancollege.giangma.domain.Shirt;

public interface ShirtService {
	
	public List<Shirt> findAll();
	public Shirt findById(Long id);
	public Shirt save(Shirt shirt);
	public Shirt editById(Shirt shirt, Long id);
	public void deleteById(Long id);
	
}
