import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import {AllScreeningsComponent} from "./components/all-screenings/all-screenings.component";
import {SingleScreeningComponent} from "./components/single-screening/single-screening.component";
import {HomepageComponent} from "./components/homepage/homepage.component";


const routes: Routes = [
  { path: 'screenings', component: AllScreeningsComponent},
  { path: 'screenings/:screeningId', component: SingleScreeningComponent},


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
