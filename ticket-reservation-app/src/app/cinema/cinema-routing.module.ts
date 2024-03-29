import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import {AllScreeningsComponent} from "./components/all-screenings/all-screenings.component";
import {SingleScreeningComponent} from "./components/single-screening/single-screening.component";
import {HomepageComponent} from "./components/homepage/homepage.component";
import {TicketComponent} from "./components/ticket/ticket.component";
import {MovieFormComponent} from "./components/movie-form/movie-form.component";
import {ScreeningFormComponent} from "./components/screening-form/screening-form.component";
import {AllMoviesComponent} from "./components/all-movies/all-movies.component";


const routes: Routes = [
  { path: 'screenings', component: AllScreeningsComponent},
  { path: 'screenings/:screeningId', component: SingleScreeningComponent},
  { path: 'ticket/:ticketId', component: TicketComponent},
  { path: 'add-movie', component: MovieFormComponent},
  { path: 'add-screening', component: ScreeningFormComponent},
  { path: 'movies', component: AllMoviesComponent}

];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class CinemaRoutingModule { }
