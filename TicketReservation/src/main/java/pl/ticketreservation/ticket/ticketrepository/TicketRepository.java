package pl.ticketreservation.ticket.ticketrepository;

import org.springframework.http.HttpEntity;
import pl.ticketreservation.ticket.Ticket;

import java.util.List;

public interface TicketRepository {
    int makeTicketReservation(Ticket ticket);

    List<Ticket> findAll();

    Ticket findTicketById(int ticketId);
}
