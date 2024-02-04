import { Component } from '@angular/core';
import {CinemaService} from "../../services/cinema.service";
import {Router} from "@angular/router";
import {NgFor} from "@angular/common";
import {NgForm} from "@angular/forms";
import {Movie} from "../../models/movie";

@Component({
  selector: 'app-movie-form',
  templateUrl: './movie-form.component.html',
  styleUrl: './movie-form.component.scss'
})
export class MovieFormComponent {
  movie: Movie = new Movie()

  constructor(
    private cinemaService: CinemaService,
    private router: Router
  ) {}

  onSubmit(movieForm: NgForm) {
    this.cinemaService.addNewMovie(this.movie).subscribe(
      (result: Movie) => {
        console.log('poszlo')
      },
      (error) => {
        console.log('nie poszlo')
      }
    )
    this.router.navigate(['/cinema/screenings'])
  }
}
