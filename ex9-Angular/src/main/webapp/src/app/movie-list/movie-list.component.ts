import { Component } from '@angular/core';
import { Movie } from '../movie';
@Component({
  selector: 'app-movie-list',
  standalone: true,
  imports: [],
  templateUrl: './movie-list.component.html',
  styleUrl: './movie-list.component.css'
})
export class MovieListComponent {
  movies:Movie[] = [];

  ngOnInit():void {//when my component loads 
    this.movies = [
      {id:1, title:"John", runtime: 20, genre: "Action"},
      {id:2, title:"Jane", runtime: 21, genre: "Comedy"},
      {id:3, title:"Doe", runtime: 22, genre: "Romance"}
    ];
  }
}
