import { Component } from '@angular/core';
import { ListEmplComponent } from './list-empl/list-empl.component';
import { AddEmplComponent } from './add-empl/add-empl.component';
import { RouterOutlet } from '@angular/router';
@Component({
  selector: 'app-empl',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './empl.component.html',
  styleUrl: './empl.component.css'
})
export class EmplComponent {

}
