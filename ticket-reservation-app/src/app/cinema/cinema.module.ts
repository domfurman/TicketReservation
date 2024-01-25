import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CinemaService} from "./services/cinema.service";
import {HttpClientModule} from "@angular/common/http";
import {AllScreeningsComponent} from "./components/all-screenings/all-screenings.component";
import {CinemaRoutingModule} from "./cinema-routing.module";
import {SingleScreeningComponent} from "./components/single-screening/single-screening.component";
import {FormsModule} from "@angular/forms";
import {HomepageComponent} from "./components/homepage/homepage.component";



@NgModule({
  declarations: [
    AllScreeningsComponent,
    SingleScreeningComponent,
    HomepageComponent
  ],
    imports: [
        CommonModule,
        HttpClientModule,
        CinemaRoutingModule,
        FormsModule
    ],
  providers: [
    CinemaService
  ]
})
export class CinemaModule { }
