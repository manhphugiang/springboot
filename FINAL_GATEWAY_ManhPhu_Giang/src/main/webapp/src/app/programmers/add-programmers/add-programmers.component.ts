import { Component } from '@angular/core';
import { Programmer } from '../programmer';
import { ProgrammerService } from '../programmer.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-programmers',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add-programmers.component.html',
  styleUrl: './add-programmers.component.css'
})
export class AddProgrammersComponent {

  programmer: Programmer = {
    id: 0,
    name: ''
  }

  
  constructor(private programmerService: ProgrammerService) { }

  saveProgrammer(): void {
    const data = {
      name: this.programmer.name,
      id: this.programmer.id
    };

    // Submit the employee record to the Rest Controller
    this.programmerService.create(data).subscribe(
      (data: Programmer) => this.programmerService.onProgrammerAdded.emit(data)
    );
    //reset the form
    this.programmer.name = '';
  }

}
