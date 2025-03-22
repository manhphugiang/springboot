import { Component } from '@angular/core';
import { Movie } from '../../movie';
import { MovieService } from '../movie.service';
@Component({
  selector: 'app-movie-list',
  standalone: true,
  imports: [],
  templateUrl: './movie-list.component.html',
  styleUrl: './movie-list.component.css'
})
export class MovieListComponent {
  movies: Movie[] = [];

  constructor(private movieService: MovieService) { }
  getMovies(): void {
    this.movieService.getAll().subscribe({ next: (data) => this.movies = data });
  }
  ngOnInit(): void {//when my component loads 
    this.getMovies();

    this.movieService.onMovieAdded.subscribe(
      (data: Movie) => this.movies.push(data)
    );
  }
}
