import { Component } from '@angular/core';
import { Programmer } from '../programmer';
import { ProgrammerService } from '../programmer.service';

@Component({
  selector: 'app-list-programmers',
  standalone: true,
  imports: [],
  templateUrl: './list-programmers.component.html',
  styleUrl: './list-programmers.component.css'
})
export class ListProgrammersComponent {


  programmers: Programmer[] = [];

  constructor(private programmerService: ProgrammerService) { }

  getProgrammers(): void {
    this.programmerService.getAll().subscribe({ next: (data) => this.programmers = data });
  }


  ngOnInit(): void {
    this.getProgrammers();

    this.programmerService.onProgrammerAdded.subscribe(
      (data: Programmer) => this.programmers.push(data)
    );
  }

}
