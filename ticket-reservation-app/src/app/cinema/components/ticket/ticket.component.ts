import {Component, OnInit} from '@angular/core';
import {CinemaService} from "../../services/cinema.service";
import {ActivatedRoute} from "@angular/router";
import {Ticket} from "../../models/ticket";

@Component({
  selector: 'app-ticket',
  standalone: false,
  templateUrl: './ticket.component.html',
  styleUrl: './ticket.component.scss'
})
export class TicketComponent implements OnInit{
  ticket: Ticket = new Ticket()
  constructor(private cinemaService: CinemaService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.loadSingleScreening()
  }

  loadSingleScreening(): void {
    this.route.params.subscribe(params => {
      const ticketId = +params['ticketId'];
      this.cinemaService.getSingleTicket(ticketId).subscribe(ticket => {
      this.ticket = ticket;
      });
    });
  }
}
