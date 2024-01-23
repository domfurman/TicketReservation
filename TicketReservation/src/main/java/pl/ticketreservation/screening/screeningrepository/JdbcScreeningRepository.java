package pl.ticketreservation.screening.screeningrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.ticketreservation.screening.Screening;

import java.util.List;

@Repository
public class JdbcScreeningRepository implements ScreeningRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Screening> findAll() {
        return jdbcTemplate.query("SELECT s.screeningId, m.movieName, " +
                        "s.date, a.auditoriumName FROM screening s JOIN movie m ON s.movieId = m.movieId " +
                        "JOIN  auditorium a ON s.auditoriumId = a.auditoriumId", BeanPropertyRowMapper.newInstance(Screening.class));
    }

    @Override
    public Screening findScreening(int screeningId){
        return jdbcTemplate.queryForObject("SELECT s.screeningId, m.movieName, " +
                        "s.date, a.auditoriumName FROM screening s JOIN movie m ON s.movieId = m.movieId " +
                        "JOIN  auditorium a ON s.auditoriumId = a.auditoriumId WHERE screeningId = ?",
                BeanPropertyRowMapper.newInstance(Screening.class), screeningId);
    }
    @Override
    public String findMovieNameByScreeningId(int screeningId){
        return jdbcTemplate.queryForObject("""
                SELECT movie.movieName
                FROM screening
                JOIN movie ON screening.movieId = movie.movieId
                WHERE screening.screeningId = ?
                """,
                String.class, screeningId);
    }

    @Override
    public Screening getScreeningInfoByTicketId(int ticketId){
        return jdbcTemplate.queryForObject("""
                SELECT s.*
                FROM screening s
                JOIN ticket t ON s.screeningId = t.screeningId
                WHERE t.ticketId = ?;
                """, BeanPropertyRowMapper.newInstance(Screening.class), ticketId);
    }
}
