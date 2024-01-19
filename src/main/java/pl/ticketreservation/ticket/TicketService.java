package pl.ticketreservation.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ticketreservation.seat.seatrepository.JdbcSeatRepository;
import pl.ticketreservation.ticket.ticketrepository.JdbcTicketRepository;

import java.util.List;

@Service
public class TicketService {

    private final JdbcTicketRepository jdbcTicketRepository;

    @Autowired
    public TicketService(JdbcTicketRepository jdbcTicketRepository) {
        this.jdbcTicketRepository = jdbcTicketRepository;
    }

    public void makeTicketReservation(Ticket ticket){
        jdbcTicketRepository.makeTicketReservation(ticket);
    }

    public List<Ticket> getAallTickets() {
        return jdbcTicketRepository.findAll();
    }

}
