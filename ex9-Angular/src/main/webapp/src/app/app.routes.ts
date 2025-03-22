import { Routes } from '@angular/router';
import { MovieAddComponent } from './movie/movie-add/movie-add.component';
import { MovieListComponent } from './movie/movie-list/movie-list.component';

export const routes: Routes = [
    {'path': 'add', 'component': MovieAddComponent},
    {'path': 'view', 'component': MovieListComponent},
];
