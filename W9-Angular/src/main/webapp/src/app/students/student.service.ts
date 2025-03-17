import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from './student';
import { EventEmitter } from '@angular/core';

const restUrl = '/api/students';



@Injectable({
  providedIn: 'root'
})
export class StudentService {
  //set the connection to the web service
  constructor(private http:HttpClient) { }

  onStudentAdded = new EventEmitter<Student>();

  getAll(): Observable<Student[]> {
    return this.http.get<Student[]>(restUrl);
  }

  create(data:any):Observable<any>{
    return this.http.post(restUrl, data);
    }

}
