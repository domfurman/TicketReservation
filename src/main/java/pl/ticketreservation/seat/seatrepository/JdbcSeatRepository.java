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
        return jdbcTemplate.query("SELECT * FROM movie_ticket WHERE movieId = ?",
                BeanPropertyRowMapper.newInstance(Seat.class), movieId);
    }

    @Override
    public List<Seat> findSeatsByScreeningId(int screeningId) {
        return jdbcTemplate.query("""
                        SELECT s.*
                        FROM seat s
                        JOIN auditorium a ON s.auditoriumId = a.auditoriumId
                        JOIN screening sc ON a.auditoriumId = sc.auditoriumId
                        WHERE sc.screeningId = ?;
                        """,
                BeanPropertyRowMapper.newInstance(Seat.class), screeningId);
    }

    @Override
    public List<Seat> findAvailableSeatsByScreeningId(int screeningId){
        return jdbcTemplate.query("""
                SELECT s.*
                    FROM seat s
                    JOIN auditorium a ON s.auditoriumId = a.auditoriumId
                    JOIN screening sc ON a.auditoriumId = sc.auditoriumId
                    LEFT JOIN ticket t ON s.seatId = t.seatId AND t.screeningId = sc.screeningId
                    WHERE sc.screeningId = ? AND t.ticketId IS NULL;
                """,
            BeanPropertyRowMapper.newInstance(Seat.class), screeningId);
    }
}
