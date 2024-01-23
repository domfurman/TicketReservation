import { Routes } from '@angular/router';

export const routes: Routes = [
  {path: 'cinema', loadChildren: () => import('./cinema/cinema.module').then(m => m.CinemaModule)}
];
