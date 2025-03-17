import { Component } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-student-add',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './student-add.component.html',
  styleUrl: './student-add.component.css'
})
export class StudentAddComponent {

  student: Student = {
    id: 0,
    name: '',
    age: 0
  }

  constructor(private studentService: StudentService) { }

  saveStudent(): void {
    const data = {
      name: this.student.name,
      age: this.student.age
    };

    
    //Submit the student record to the Rest Controller
    this.studentService.create(data).subscribe(
      (data: Student) => this.studentService.onStudentAdded.emit(data)
    );
  }



}