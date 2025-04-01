import { Component } from '@angular/core';
import { Employee } from '../employee';
import { FormsModule } from '@angular/forms';
import { EmployeeService } from '../employee.service';
@Component({
  selector: 'app-add-empl',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add-empl.component.html',
  styleUrl: './add-empl.component.css'
})

export class AddEmplComponent {


  employee: Employee = {
    id: 0,
    name: ''
  }
  constructor(private employeeService: EmployeeService) { }

  saveEmployee(): void {
    const data = {
      name: this.employee.name,
      id: this.employee.id
    };

    // Submit the employee record to the Rest Controller
    this.employeeService.create(data).subscribe(
      (data: Employee) => this.employeeService.onEmployeeAdded.emit(data)
    );
    //reset the form
    this.employee.name = '';
  }
}
