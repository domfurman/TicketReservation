package pl.ticketreservation.seat.seatrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.ticketreservation.seat.Seat;

import java.util.List;

@Repository
public class JdbcSeatRepository implements SeatRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Seat> findAllSeatsForMovie(int movieId) {
        return jdbcTemplate.query("SELECT * FROM sql11676201.movie_ticket WHERE movieId = ?",
                BeanPropertyRowMapper.newInstance(Seat.class), movieId);
    }
}
