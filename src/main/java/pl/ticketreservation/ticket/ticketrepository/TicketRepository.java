package pl.ticketreservation.ticket.ticketrepository;

import org.springframework.http.HttpEntity;
import pl.ticketreservation.ticket.Ticket;

public interface TicketRepository {
    int makeTicketReservation(Ticket ticket);
}
