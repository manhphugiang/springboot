import { Component } from '@angular/core';
import { StudentListComponent } from "./student-list/student-list.component";
import { StudentAddComponent } from "./student-add/student-add.component";

@Component({
  selector: 'app-students',
  standalone: true,
  imports: [StudentListComponent, StudentAddComponent],
  templateUrl: './students.component.html',
  styleUrl: './students.component.css'
})
export class StudentsComponent {

}
