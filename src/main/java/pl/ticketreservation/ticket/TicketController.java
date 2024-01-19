package pl.ticketreservation.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ticketreservation.ticket.ticketrepository.JdbcTicketRepository;

@RestController
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @PostMapping("")
    public ResponseEntity<Ticket> makeTicketReservation(@RequestBody Ticket ticket){
      int response = ticketService.makeTicketReservation(ticket);
      if (response == 1) {
          return new ResponseEntity<>(ticket, HttpStatus.CREATED);
      }else {
          return new ResponseEntity<>(ticket, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
}
