import {Ticket} from "./ticket";
import {Screening} from "./screening";
import {User} from "./user";
import {Seat} from "./seat";
import {Movie} from "./movie";

export class TicketDto {
  ticket: Ticket = new Ticket()
  movie: Movie = new Movie()
  screening: Screening = new Screening()
  user: User = new User()
  seat: Seat = new Seat()

}
