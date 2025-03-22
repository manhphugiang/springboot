import { Component } from '@angular/core';
import { StudentListComponent } from "./student-list/student-list.component";
import { StudentAddComponent } from "./student-add/student-add.component";
import { RouterOutlet } from '@angular/router';
@Component({
  selector: 'app-students',
  standalone: true,
  imports: [StudentListComponent, StudentAddComponent, RouterOutlet],
  templateUrl: './students.component.html',
  styleUrl: './students.component.css'
})
export class StudentsComponent {

}
