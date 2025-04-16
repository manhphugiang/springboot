import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from './item';
import { EventEmitter } from '@angular/core';
import { Employee } from '../empl/employee';

const restUrl = '/api/items';
const restUrl2 = '/api/employees';


@Injectable({
  providedIn: 'root'
})
export class ItemService {

  //set the connection to the web service
  constructor(private http: HttpClient) { }

  onItemAdded = new EventEmitter<Item>();

  onItemDeleted = new EventEmitter<Item>();

  getAll(): Observable<Item[]> {
    return this.http.get<Item[]>(restUrl);
  }

  getAllEmployee(): Observable<Employee[]> {
    return this.http.get<Employee[]>(restUrl2);
  }

  create(data: any): Observable<any> {
    return this.http.post(restUrl, data);
  }

  
  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${restUrl}/${id}`);
  }


  // why do we need thisssssssssssssssss
  getById(id: number): Observable<Item> {
    return this.http.get<Item>(`${restUrl}/${id}`);
  }
}
