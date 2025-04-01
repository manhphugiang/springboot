import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { EventEmitter } from '@angular/core';

const restUrl = '/api/employees';


@Injectable({
  providedIn: 'root'
})

export class EmployeeService {

  constructor(private http:HttpClient) { }

  onEmployeeAdded = new EventEmitter<Employee>();

  getAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(restUrl);
  }

  create(data: any): Observable<any> {
    return this.http.post(restUrl, data);
  }

  getById(id: number): Observable<Employee> {
    return this.http.get<Employee>(`${restUrl}/${id}`);
  }
  
}
