import { Injectable } from '@angular/core';
import { Programmer } from '../programmers/programmer';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EventEmitter } from '@angular/core';
import { Shirt } from './shirt';

const restUrl = '/api/shirts';
const restUrl2 = '/api/programmers';

@Injectable({
  providedIn: 'root'
})
export class ShirtService {

  //set the connection to the web service
  constructor(private http: HttpClient) { }

  onShirtAdded = new EventEmitter<Shirt>();

  onShirtDeleted = new EventEmitter<Shirt>();

  getAll(): Observable<Shirt[]> {
    return this.http.get<Shirt[]>(restUrl);
  }

  getAllProgrammer(): Observable<Programmer[]> {
    return this.http.get<Programmer[]>(restUrl2);
  }

  create(data: any): Observable<any> {
    return this.http.post(restUrl, data);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${restUrl}/${id}`);
  }  

  getById(id: number): Observable<Shirt> {
    return this.http.get<Shirt>(`${restUrl}/${id}`);
  }
}
