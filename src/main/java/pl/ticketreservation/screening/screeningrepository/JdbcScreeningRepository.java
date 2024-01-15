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
                        "s.date, a.auditoriumName FROM sql11676201.screening s JOIN sql11676201.movie m ON s.movieId = m.movieId " +
                        "JOIN sql11676201. auditorium a ON s.auditoriumId = a.auditoriumId", BeanPropertyRowMapper.newInstance(Screening.class));
    }

    @Override
    public Screening findScreening(int screeningId){
        return jdbcTemplate.queryForObject("SELECT s.screeningId, m.movieName, " +
                        "s.date, a.auditoriumName FROM sql11676201.screening s JOIN sql11676201.movie m ON s.movieId = m.movieId " +
                        "JOIN sql11676201. auditorium a ON s.auditoriumId = a.auditoriumId WHERE screeningId = ?",
                BeanPropertyRowMapper.newInstance(Screening.class), screeningId);
    }
}
