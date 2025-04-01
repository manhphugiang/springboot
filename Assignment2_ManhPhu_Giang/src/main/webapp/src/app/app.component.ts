import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import  { EmplComponent } from './empl/empl.component';
import  { ItemComponent } from './item/item.component';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, EmplComponent, ItemComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'webapp';
  constructor() { }
}
