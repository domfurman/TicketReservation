import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import {AllScreeningsComponent} from "./components/all-screenings/all-screenings.component";


const routes: Routes = [
  { path: 'screenings', component: AllScreeningsComponent}

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
