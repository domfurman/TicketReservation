package pl.ticketreservation.ticket.ticketrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.ticketreservation.ticket.Ticket;

@Repository
public class JdbcTicketRepository implements TicketRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int makeTicketReservation(Ticket ticket) {
        int response = jdbcTemplate.update("INSERT INTO ticket(userId, screeningId, seatId, typeId) VALUES (?, ?, ?, ?)",
                ticket.getUserId(), ticket.getScreeningId(), ticket.getTicketId());
        return response;
    }
}
