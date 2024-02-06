import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {CinemaService} from "../../services/cinema.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Movie} from "../../models/movie";
import {ScreeningDto} from "../../models/screening-dto";
import {Ticket} from "../../models/ticket";
import {NgForm} from "@angular/forms";
import {User} from "../../models/user";
import {Seat} from "../../models/seat";
import {error} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-single-screenings',
  standalone: false,
  templateUrl: './single-screening.component.html',
  styleUrl: './single-screening.component.scss',
  encapsulation: ViewEncapsulation.None
})
export class SingleScreeningComponent implements OnInit {
    screeningDto: ScreeningDto = new ScreeningDto();
    showPrivateUserForm: boolean = true
    ticket: Ticket = new Ticket();
    user: User = new User();
    seatChecked: number = 0;
    constructor(private cinemaService: CinemaService,
                private route: ActivatedRoute,
                private router: Router) {
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

    isSeatUnavailable(seat: any): boolean {
        const seatIdentifier = `${seat.row}${seat.seatNo}`;
        return !this.screeningDto.availableSeats.some(availableSeat => `${availableSeat.row}${availableSeat.seatNo}` === seatIdentifier);
    }

    changeForm() {
        this.showPrivateUserForm = !this.showPrivateUserForm
    }

    onCheckboxChange(seat: Seat) {
        console.log('Checkbox clicked:', seat.seatId);
        this.seatChecked = seat.seatId
    }

    async makeUser(reservationForm: NgForm) {
      try {
        const result = await this.cinemaService.makeUser(this.user).toPromise()
        console.log('User made')
        this.getUser(this.user.email)
        // console.log(this.user.userId)
        // this.ticket.userId = this.user.userId
      } catch (error) {
        console.error(error)
      }
    }

    getUser(email: string): Promise<any> {
      return new Promise((resolve, reject) => {
        this.cinemaService.getUserByEmail(email).subscribe(
          (data) => {
            // console.log(data);
            this.ticket.userId = data.userId;
            this.ticket.typeId = 1;
            this.ticket.seatId = this.seatChecked;
            this.ticket.screeningId = this.screeningDto.screening.screeningId;
            console.log(this.ticket)
            this.makeTicketReservation()
          },
          (error) => {
            console.error(error);
            reject(error); // Reject the promise if there is an error
          }
        );
      });
    }
      /*this.cinemaService.getUserByEmail(email).subscribe(
        (data) => {
          console.log(data)
          // console.log("getUser func " + this.userIddelta)
          this.ticket.userId = data.userId
          this.ticket.typeId = 1
          this.ticket.seatId = this.seatChecked
          this.ticket.screeningId = this.screeningDto.screening.screeningId
          // this.ticket.userId = data.userId
          // console.log(this.ticket)
        }, (error) => {
          console.error(error)
        }
      )

    }*/

    reserveTicket(reservationForm: NgForm): void {
      this.makeUser(reservationForm)
    }

  makeTicketReservation(): void {
    this.cinemaService.makeTicketReservation(this.ticket).subscribe(
      (data) => {
        console.log("Ticket reserved", data);
        this.router.navigate(['/cinema/ticket/'+data])
      },
      (error) => {
        console.log(error);
      }
    );
  }


}

