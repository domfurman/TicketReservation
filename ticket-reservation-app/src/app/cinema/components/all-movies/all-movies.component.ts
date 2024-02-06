import {Component, OnInit} from '@angular/core';
import {CinemaService} from "../../services/cinema.service";
import {Movie} from "../../models/movie";

@Component({
  selector: 'app-all-movies',
  standalone: false,
  templateUrl: './all-movies.component.html',
  styleUrl: './all-movies.component.scss'
})
export class AllMoviesComponent implements OnInit{
  moviesList: Movie[] = new Array<Movie>

  constructor(private cinemaService: CinemaService) {
  }

  ngOnInit() {
    this.loadMovies()
  }

  loadMovies() {
    this.cinemaService.getAllMovies().subscribe(
      (data) => this.moviesList = data
    )
  }

}
