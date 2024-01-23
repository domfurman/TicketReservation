import {Component, OnInit} from '@angular/core';
import {Screening} from "../../models/screening";
import {CinemaService} from "../../services/cinema.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-all-screenings',
  standalone: false,
  templateUrl: './all-screenings.component.html',
  styleUrl: './all-screenings.component.scss'
})
export class AllScreeningsComponent implements OnInit{
  screeningsList: Screening[] = new Array<Screening>
  constructor(private cinemaService: CinemaService,
              private router: Router) {
  }
  ngOnInit() {
    this.loadScreenings();
  }

  loadScreenings() {
    this.cinemaService.getAllScreenings().subscribe(
      (data) => this.screeningsList = data
    )
  }

  redirectToSeatChoice(screeningId: number) {
    // console.log(screeningId)
    this.router.navigate(['/cinema/screenings', screeningId]);
  }
}
