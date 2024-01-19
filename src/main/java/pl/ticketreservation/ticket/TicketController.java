package pl.ticketreservation.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ticketreservation.ticket.ticketrepository.JdbcTicketRepository;

import java.util.List;

@RestController
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @GetMapping(path = "api/tickets")
    public List<Ticket> getAllTickets() {
        return ticketService.getAallTickets();
    }

    @PostMapping(value = "/make-ticket-reservation")
    public void makeTicketReservation(@RequestBody Ticket ticket){
      /*int response = ticketService.makeTicketReservation(ticket);
      if (response == 1) {
          return new ResponseEntity<>(ticket, HttpStatus.CREATED);
      }else {
          return new ResponseEntity<>(ticket, HttpStatus.INTERNAL_SERVER_ERROR);
      }*/
        ticketService.makeTicketReservation(ticket);
    }
}
