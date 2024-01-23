import {Component, OnInit} from '@angular/core';
import {CinemaService} from "../../services/cinema.service";
import {ActivatedRoute} from "@angular/router";
import {Movie} from "../../models/movie";
import {ScreeningDto} from "../../models/screening-dto";

@Component({
  selector: 'app-single-screenings',
  standalone: false,
  templateUrl: './single-screening.component.html',
  styleUrl: './single-screening.component.scss'
})
export class SingleScreeningComponent implements OnInit{
  screeningDto: ScreeningDto = new ScreeningDto();
  movie: Movie = new Movie();

  constructor(private cinemaService: CinemaService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.loadSingleScreening()
  }

  loadSingleScreening(): void {
    this.route.params.subscribe(params => {
      const screeningId = +params['screeningId'];
      this.cinemaService.getSingleScreening(screeningId).subscribe(screeningDto => {
        this.screeningDto = screeningDto;
      });
    });
  }
}

