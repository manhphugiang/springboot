import { Routes } from '@angular/router';
import { ListItemComponent } from './item/list-item/list-item.component';
import { AddItemComponent } from './item/add-item/add-item.component';
import { ListEmplComponent } from './empl/list-empl/list-empl.component';
import { AddEmplComponent } from './empl/add-empl/add-empl.component';

export const routes: Routes = [
    {'path': 'add-item', 'component': AddItemComponent},
    {'path': 'list-item', 'component': ListItemComponent},
    {'path': 'add-empl', 'component': AddEmplComponent},
    {'path': 'list-empl', 'component': ListEmplComponent},
];
