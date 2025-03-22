package ca.sheridancollege.giangma.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.giangma.domain.Movie;
import ca.sheridancollege.giangma.service.MovieService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {
	private MovieService movieService;
		
	
	@PostMapping(value={"","/"}, headers = {"Content-type=application/json"})
	public Movie addMovie(@RequestBody Movie movie) {
		movie.setId(null);
		return movieService.save(movie);
	}
	
	@GetMapping(value={"","/"}, headers = {"Content-type=application/json"})
	public List<Movie> getMovieByName() {
		return movieService.findAll();
	}
	
	
	
}
