import { Component } from '@angular/core';
import { Item } from '../item';
import { ItemService } from '../item.service';
import { EmployeeService } from '../../empl/employee.service';
import { Employee } from '../../empl/employee';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-add-item',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add-item.component.html',
  styleUrl: './add-item.component.css'
})
export class AddItemComponent {
  
    item: Item = {
      id: 0,
      name: '',
      price: 0,
      quantity: 0,
      employeeName: ''
    }
    constructor(private itemService: ItemService, private employeeService: EmployeeService) { }
  
    employees: Employee[] = [];

    ngOnInit(): void {
      this.getEmployees();
    }
    
    getEmployees(): void {
      this.employeeService.getAll().subscribe({
        next: (data: Employee[]) => {
          this.employees = data;
          // set the default employee name to the first one in the list after it is populated
          if (this.employees.length > 0) {
            this.item.employeeName = this.employees[0].name;  // Default to the first employee's name
          }
        }
      });
    }
    



    
    saveItem(): void {
      const data = {
        id: this.item.id,
        name: this.item.name,
        price: this.item.price,
        quantity: this.item.quantity,
        employeeName: this.item.employeeName
      };
      // Submit the item record to the Rest Controller
      this.itemService.create(data).subscribe(
        (data: Item) => this.itemService.onItemAdded.emit(data)
      );

      //reset the form
      this.item.name = '';
      this.item.price = 0;
      this.item.quantity = 0;


    }
}

