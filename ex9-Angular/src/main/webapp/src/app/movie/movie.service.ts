import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from '.././movie';
import { EventEmitter } from '@angular/core';

const restUrl = '/api/movies';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  //set the connection
  constructor(private http:HttpClient) { }

  onMovieAdded = new EventEmitter<Movie>();
  getAll():Observable<Movie[]>{
    return this.http.get<Movie[]>(restUrl);
  }

  create (data:any):Observable<any>{
    return this.http.post(restUrl, data);
  }

}
