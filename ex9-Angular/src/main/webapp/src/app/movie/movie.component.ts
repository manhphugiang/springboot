import { Component } from '@angular/core';
import { MovieAddComponent } from "./movie-add/movie-add.component";
import { MovieListComponent } from "./movie-list/movie-list.component";

import { RouterOutlet } from '@angular/router';
@Component({
  selector: 'app-movie',
  standalone: true,
  imports: [MovieAddComponent, MovieListComponent, RouterOutlet],
  templateUrl: './movie.component.html',
  styleUrl: './movie.component.css'
})
export class MovieComponent {

}
