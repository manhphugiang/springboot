import { Component } from '@angular/core';
import { ShirtService } from '../shirt.service';
import { Shirt } from '../shirt';

@Component({
  selector: 'app-list-shirts',
  standalone: true,
  imports: [],
  templateUrl: './list-shirts.component.html',
  styleUrl: './list-shirts.component.css'
})
export class ListShirtsComponent {

  shirts: Shirt[] = [];

  constructor(private shirtService: ShirtService) { }

  getShirts(): void {
    this.shirtService.getAll().subscribe({ next: (data) => this.shirts = data });
  }
  
  deleteShirt(id: number): void {
    this.shirtService.delete(id).subscribe({
      next: () => {
        this.getShirts();
      },
    });
  }
  

  ngOnInit(): void {
    this.getShirts();
    this.shirtService.onShirtDeleted.subscribe(
      (id: number) => {
        this.shirts = this.shirts.filter(shirt => shirt.id !== id);
      }
    );
  }  
}
