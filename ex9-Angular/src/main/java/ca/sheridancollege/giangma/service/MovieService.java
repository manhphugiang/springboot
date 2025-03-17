package ca.sheridancollege.giangma.service;

import java.util.List;

import ca.sheridancollege.giangma.domain.Movie;

public interface MovieService {
	public List<Movie> findAll();
	public Movie findById(Long id);
	public Movie findByTitle(String title);
	public Movie save(Movie movie);
	
}
