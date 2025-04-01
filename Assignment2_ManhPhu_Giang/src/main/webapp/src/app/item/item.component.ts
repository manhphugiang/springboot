import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-item',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './item.component.html',
  styleUrl: './item.component.css'
})
export class ItemComponent {

}
