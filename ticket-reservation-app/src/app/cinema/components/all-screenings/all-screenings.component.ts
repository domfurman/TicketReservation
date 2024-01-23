import {Component, OnInit} from '@angular/core';
import {Screening} from "../../models/screening";
import {CinemaService} from "../../services/cinema.service";


@Component({
  selector: 'app-all-screenings',
  standalone: false,
  templateUrl: './all-screenings.component.html',
  styleUrl: './all-screenings.component.scss'
})
export class AllScreeningsComponent implements OnInit{
  screeningsList: Screening[] = new Array<Screening>
  constructor(private cinemaService: CinemaService) {
  }
  ngOnInit() {
    this.loadScreenings();
  }

  loadScreenings() {
    this.cinemaService.getAllScreenings().subscribe(
      (data) => this.screeningsList = data
    )
  }
}
