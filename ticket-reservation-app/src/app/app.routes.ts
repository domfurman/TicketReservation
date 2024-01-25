import { Routes } from '@angular/router';
import {HomepageComponent} from "./cinema/components/homepage/homepage.component";

export const routes: Routes = [
  { path: 'cinema', loadChildren: () => import('./cinema/cinema.module').then(m => m.CinemaModule)},
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'home', component: HomepageComponent}
];
