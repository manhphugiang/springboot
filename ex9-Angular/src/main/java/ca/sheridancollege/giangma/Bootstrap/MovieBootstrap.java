package ca.sheridancollege.giangma.Bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.giangma.domain.Movie;
import ca.sheridancollege.giangma.service.MovieService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Component
public class MovieBootstrap implements CommandLineRunner {
	private MovieService movieService;
	@Override
	public void run(String... args) throws Exception {
		movieService.save(Movie.builder().title("Avenger").runtime(200).genre("Heroes").build());
		movieService.save(Movie.builder().title("Iron Man").runtime(300).genre("Actions").build());
		movieService.save(Movie.builder().title("Openheimers").runtime(350).genre("Science").build());
		
	
	}

}
