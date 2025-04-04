import { Component } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student-list',
  standalone: true,
  imports: [],
  templateUrl: './student-list.component.html',
  styleUrl: './student-list.component.css'
})
export class StudentListComponent {
  students: Student[] = [];

  constructor(private studentService: StudentService) { }

  getStudents(): void {
    this.studentService.getAll().subscribe({ next: (data) => this.students = data });
  }

  ngOnInit(): void {
    this.getStudents();


    this.studentService.onStudentAdded.subscribe(
      (data: Student) => this.students.push(data)
    );
  }
}
