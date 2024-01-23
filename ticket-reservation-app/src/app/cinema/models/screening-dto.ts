import {Screening} from "./screening";
import {Movie} from "./movie";
import {Seat} from "./seat";

export class ScreeningDto {
  screening: Screening = new Screening()
  movie: Movie = new Movie();
  seats: Seat[] = new Array<Seat>
  availableSeats: Seat[] = new Array<Seat>
  constructor() {
  }
}
