package pl.ticketreservation.ticket.ticketrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import pl.ticketreservation.ticket.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class JdbcTicketRepository implements TicketRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int makeTicketReservation(Ticket ticket) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update("INSERT INTO ticket(userId, screeningId, seatId, typeId) VALUES (?, ?, ?, ?)",
//                ticket.getUserId(),
//                ticket.getScreeningId(),
//                ticket.getSeatId(),
//                ticket.getTypeId());
//        return 200;
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(
                        "INSERT INTO ticket(userId, screeningId, seatId, typeId) VALUES (?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);

                ps.setInt(1, ticket.getUserId());
                ps.setInt(2, ticket.getScreeningId());
                ps.setInt(3, ticket.getSeatId());
                ps.setInt(4, ticket.getTypeId());

                return ps;
            }
        }, keyHolder);

        // Retrieve the generated key (ticketId)
        Number ticketId = keyHolder.getKey();

        if (ticketId != null) {
            return ticketId.intValue();
        } else {
            // Handle the case where the ticketId is not generated
            throw new RuntimeException("Failed to generate ticketId");
        }
    }

    @Override
    public List<Ticket> findAll() {
        return jdbcTemplate.query("SELECT * FROM ticket",
                BeanPropertyRowMapper.newInstance(Ticket.class));
    }

    @Override
    public Ticket findTicketById(int ticketId) {
        return jdbcTemplate.queryForObject("SELECT * FROM ticket WHERE ticketId = ?",
                BeanPropertyRowMapper.newInstance(Ticket.class), ticketId);
    }
}
