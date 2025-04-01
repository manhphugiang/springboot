import { Component } from '@angular/core';
import { Item } from '../item';
import { ItemService } from '../item.service';
@Component({
  selector: 'app-list-item',
  standalone: true,
  imports: [],
  templateUrl: './list-item.component.html',
  styleUrl: './list-item.component.css'
})
export class ListItemComponent {

  items: Item[] = [];

  constructor(private itemService: ItemService) { }

  getItems(): void {
    this.itemService.getAll().subscribe({ next: (data) => this.items = data });
  }
  deleteItem(id: number): void {
    this.itemService.delete(id).subscribe({
      next: () => {
        this.getItems();
      },
    });
  }
  

  ngOnInit(): void {
    this.getItems();
    this.itemService.onItemDeleted.subscribe(
      (id: number) => {
        this.items = this.items.filter(item => item.id !== id);
      }
    );
  }  
}