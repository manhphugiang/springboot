import { Component } from '@angular/core';


import { Movie } from '../../movie';
import { MovieService } from '.././movie.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-movie-add',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './movie-add.component.html',
  styleUrl: './movie-add.component.css'
})
export class MovieAddComponent {

  movie: Movie = {
    id: 0,
    title: '',
    runtime: 0,
    genre: ''
  }

  constructor(private movieService: MovieService) { }

  saveMovie(): void {
    const data = {
      title: this.movie.title,
      runtime: this.movie.runtime,
      genre: this.movie.genre
    };


    this.movieService.create(data).subscribe(
      (data: Movie) => this.movieService.onMovieAdded.emit(data),
    );

  }
}
