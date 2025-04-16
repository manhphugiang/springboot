import { Component } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
@Component({
  selector: 'app-list-empl',
  standalone: true,
  imports: [],
  templateUrl: './list-empl.component.html',
  styleUrl: './list-empl.component.css'
})
export class ListEmplComponent {
  
  employees: Employee[] = [];

  constructor(private employeeService: EmployeeService) { }

  getEmployees(): void {
    this.employeeService.getAll().subscribe({ next: (data) => this.employees = data });
  }

  ngOnInit(): void {
    this.getEmployees();

    this.employeeService.onEmployeeAdded.subscribe(
      (data: Employee) => this.employees.push(data)
    );
  }

  
}
