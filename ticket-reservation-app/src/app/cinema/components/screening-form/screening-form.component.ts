import {Component, OnInit} from '@angular/core';
import {CinemaService} from "../../services/cinema.service";
import {Router} from "@angular/router";
import {FormBuilder, FormControl, FormGroup, NgForm, Validators} from "@angular/forms";
import {Screening} from "../../models/screening";
import {Movie} from "../../models/movie";

@Component({
  selector: 'app-screening-form',
  standalone: false,
  templateUrl: './screening-form.component.html',
  styleUrl: './screening-form.component.scss'
})
export class ScreeningFormComponent implements OnInit{
  screening: Screening = new Screening();
  moviesList: Movie[] = new Array<Movie>;
  /*selectedMovie: Movie | null = null;
  selectedDateTime: Date | null = null;
  selectedAuditorium: number = 0;*/
  // screeningForm: FormGroup = new FormGroup<any>(Screening)

  constructor(
    private cinemaService: CinemaService,
    private router: Router,
    // private formBuilder: FormBuilder
  ) {}

  ngOnInit() {
    this.loadMovies();
    /*this.screeningForm = this.formBuilder.group({
      movieId: [null, Validators.required],
      date: [null, Validators.required],
      auditoriumId: [null, Validators.required],
    });*/
  }

  onSubmit(screeningForm: NgForm) {
    this.cinemaService.addNewScreening(this.screening).subscribe(
      (result: Screening) => {
        console.log('poszlo')
        this.router.navigate(['/cinema/screenings'])
      },
      (error) => {
        console.error('nie poszlo', error)
      }
    )
    // console.log(screeningForm.value)
  }

  loadMovies(): void {
    this.cinemaService.getAllMovies().subscribe(
      (data) => this.moviesList = data
    )
  }
}
