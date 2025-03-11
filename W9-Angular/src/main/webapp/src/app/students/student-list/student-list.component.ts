import { Component } from '@angular/core';
import { Student } from '../student';

@Component({
  selector: 'app-student-list',
  standalone: true,
  imports: [],
  templateUrl: './student-list.component.html',
  styleUrl: './student-list.component.css'
})
export class StudentListComponent {
  students:Student[] = [];

  ngOnInit():void {//when my component loads 
    this.students = [
      {id:1, name:"John", age: 20},
      {id:2, name:"Jane", age: 21},
      {id:3, name:"Doe", age: 22}
    ];
  }
}
