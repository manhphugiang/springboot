import { Component } from '@angular/core';
import { Programmer } from '../../programmers/programmer';
import { ShirtService } from '../shirt.service';
import { ProgrammerService } from '../../programmers/programmer.service';
import { Shirt } from '../shirt';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-shirts',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add-shirts.component.html',
  styleUrl: './add-shirts.component.css'
})
export class AddShirtsComponent {

  shirts: Shirt = {
    id: 0,
    name: '',
    price: 0,
    quantity: 0,
    employeeName: ''
  }
  constructor(private shirtService: ShirtService, private programmerService: ProgrammerService) { }

  programmers: Programmer[] = [];

  ngOnInit(): void {
    this.getProgrammers();
  }
  
  getProgrammers(): void {
    this.programmerService.getAll().subscribe({
      next: (data: Programmer[]) => {
        this.programmers = data;
        if (this.programmers.length > 0) {
          this.shirts.employeeName = this.programmers[0].name; 
        }
      }
    });
  }
  
  saveShirt(): void {
    const data = {
      id: this.shirts.id,
      name: this.shirts.name,
      price: this.shirts.price,
      quantity: this.shirts.quantity,
      employeeName: this.shirts.employeeName
    };
    // Submit the shirts record to the Rest Controller
    this.shirtService.create(data).subscribe(
      (data: Shirt) => this.shirtService.onShirtAdded.emit(data)
    );

    //reset the form
    this.shirts.name = '';
    this.shirts.price = 0;
    this.shirts.quantity = 0;
  }
}
