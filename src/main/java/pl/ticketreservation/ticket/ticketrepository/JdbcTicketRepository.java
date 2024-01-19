package pl.ticketreservation.ticket.ticketrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.ticketreservation.ticket.Ticket;

import java.util.List;

@Repository
public class JdbcTicketRepository implements TicketRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int makeTicketReservation(Ticket ticket) {
        jdbcTemplate.update("INSERT INTO ticket(userId, screeningId, seatId, typeId) VALUES (?, ?, ?, ?)",
                ticket.getUserId(),
                ticket.getScreeningId(),
                ticket.getSeatId(),
                ticket.getTypeId());
        return 200;
    }

    @Override
    public List<Ticket> findAll() {
        return jdbcTemplate.query("SELECT * FROM ticket",
                BeanPropertyRowMapper.newInstance(Ticket.class));
    }
}
