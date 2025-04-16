import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProgrammersComponent } from './programmers/programmers.component';
import { ShirtsComponent } from "./shirts/shirts.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ProgrammersComponent, ShirtsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'webapp';
}
