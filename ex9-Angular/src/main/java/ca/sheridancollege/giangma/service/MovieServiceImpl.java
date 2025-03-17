package ca.sheridancollege.giangma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.sheridancollege.giangma.domain.Movie;
import ca.sheridancollege.giangma.repositories.MovieRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
	private MovieRepository movieRepo;

	@Override
	public List<Movie> findAll() {
		return movieRepo.findAll();
	}

	@Override
	public Movie findById(Long id) {
		if (movieRepo.findById(id).isPresent()) {
			return movieRepo.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public Movie findByTitle(String title) {
		if (movieRepo.findByTitle(title).isPresent()) {
			return movieRepo.findByTitle(title).get();
		} else {
			return null;
		}
	}

	@Override
	public Movie save(Movie movie) {
		return movieRepo.save(movie);
	}
	
	
}
