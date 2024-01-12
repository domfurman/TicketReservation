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
        return jdbcTemplate.query("SELECT s.* FROM sql11676201.seat s JOIN sql11676201.movie_ticket mt on s.ticketId = mt.ticketId WHERE mt.movieId = ? AND s.isTaken = 0",
                BeanPropertyRowMapper.newInstance(Seat.class), movieId);
    }
}
