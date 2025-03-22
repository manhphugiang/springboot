import { Routes } from '@angular/router';
import { StudentAddComponent } from './students/student-add/student-add.component';
import { StudentListComponent } from './students/student-list/student-list.component';

export const routes: Routes = [
    {'path': 'add', 'component': StudentAddComponent},
    {'path': 'view', 'component': StudentListComponent}
];
