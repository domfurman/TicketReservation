package pl.ticketreservation.ticket.ticketrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.ticketreservation.ticket.Ticket;

@Repository
public class JdbcTicketRepository implements TicketRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public HttpEntity<Ticket> makeTicketReservation() {
        jdbcTemplate.query("INSERT INTO ticket(userId, screeningId, seatId, typeId)",
                new Object[] {

                });
        return null;
    }
}
