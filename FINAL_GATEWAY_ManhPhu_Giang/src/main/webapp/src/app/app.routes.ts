import { Routes } from '@angular/router';
import { AddProgrammersComponent } from './programmers/add-programmers/add-programmers.component';
import { ListProgrammersComponent } from './programmers/list-programmers/list-programmers.component';
import { AddShirtsComponent } from './shirts/add-shirts/add-shirts.component';
import { ListShirtsComponent } from './shirts/list-shirts/list-shirts.component';

export const routes: Routes = [
    {'path': 'add-programmer', 'component': AddProgrammersComponent},
    {'path': 'list-programmer', 'component': ListProgrammersComponent},
    {'path': 'list-shirt', 'component': ListShirtsComponent},
    {'path': 'add-shirt', 'component': AddShirtsComponent},
];
