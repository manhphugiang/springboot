import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Programmer } from './programmer';
import { EventEmitter } from '@angular/core';

const restUrl = '/api/programmers';

@Injectable({
  providedIn: 'root'
})
export class ProgrammerService {

  constructor(private http: HttpClient) {}

    onProgrammerAdded = new EventEmitter<Programmer>();

    getAll(): Observable<Programmer[]> {
      return this.http.get<Programmer[]>(restUrl);
    }
  
    create(data: any): Observable<any> {
      return this.http.post(restUrl, data);
    }
  
    getById(id: number): Observable<Programmer> {
      return this.http.get<Programmer>(`${restUrl}/${id}`);
    }
   
}
