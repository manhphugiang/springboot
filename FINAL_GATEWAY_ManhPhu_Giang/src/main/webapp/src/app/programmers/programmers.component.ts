import { Component } from '@angular/core';
import { ListProgrammersComponent } from './list-programmers/list-programmers.component';
import { AddProgrammersComponent } from './add-programmers/add-programmers.component';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-programmers',
  standalone: true,
  imports: [ListProgrammersComponent, AddProgrammersComponent, RouterOutlet],
  templateUrl: './programmers.component.html',
  styleUrl: './programmers.component.css'
})
export class ProgrammersComponent {

}
