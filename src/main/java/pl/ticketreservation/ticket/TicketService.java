package pl.ticketreservation.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ticketreservation.seat.seatrepository.JdbcSeatRepository;
import pl.ticketreservation.ticket.ticketrepository.JdbcTicketRepository;

@Service
public class TicketService {

    private final JdbcTicketRepository jdbcTicketRepository;

    @Autowired
    public TicketService(JdbcTicketRepository jdbcTicketRepository) {
        this.jdbcTicketRepository = jdbcTicketRepository;
    }

    public int makeTicketReservation(Ticket ticket){
        return jdbcTicketRepository.makeTicketReservation(ticket);
    }

}
