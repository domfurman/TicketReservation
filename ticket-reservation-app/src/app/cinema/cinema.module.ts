import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CinemaService} from "./services/cinema.service";
import {HttpClientModule} from "@angular/common/http";
import {AllScreeningsComponent} from "./components/all-screenings/all-screenings.component";
import {CinemaRoutingModule} from "./cinema-routing.module";
import {SingleScreeningComponent} from "./components/single-screening/single-screening.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HomepageComponent} from "./components/homepage/homepage.component";
import {TicketComponent} from "./components/ticket/ticket.component";
import {MovieFormComponent} from "./components/movie-form/movie-form.component";
import {ScreeningFormComponent} from "./components/screening-form/screening-form.component";
import {MatSelectModule} from "@angular/material/select";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInput, MatInputModule} from "@angular/material/input";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatMomentDateModule} from "@angular/material-moment-adapter";
import {MatDatetimepickerModule} from "@mat-datetimepicker/core";
import {AllMoviesComponent} from "./components/all-movies/all-movies.component";


@NgModule({
  declarations: [
    AllScreeningsComponent,
    SingleScreeningComponent,
    HomepageComponent,
    TicketComponent,
    MovieFormComponent,
    ScreeningFormComponent,
    AllMoviesComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    CinemaRoutingModule,
    FormsModule,
    MatSelectModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatMomentDateModule,
    MatDatetimepickerModule,
  ],
  providers: [
    CinemaService
  ]
})
export class CinemaModule { }
