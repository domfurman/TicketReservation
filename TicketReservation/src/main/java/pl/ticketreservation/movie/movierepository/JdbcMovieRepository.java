package pl.ticketreservation.movie.movierepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.ticketreservation.movie.Movie;

import java.util.List;

@Repository
public class JdbcMovieRepository implements MovieRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public Movie getMovieInfoByTicketId(int ticketId) {
        return jdbcTemplate.queryForObject("SELECT m.*" +
                " FROM movie m " +
                " JOIN screening s ON m.movieId = s.movieId" +
                " JOIN ticket t ON s.screeningId = t.screeningId" +
                " WHERE t.ticketId = ?", BeanPropertyRowMapper.newInstance(Movie.class), ticketId);
    }

    @Override
    public int addMovie(Movie movie) {
        return jdbcTemplate.update("""
            INSERT INTO movie(movieName, duration, forAdults)
            VALUES(?, ?, ?)
            """,
                movie.getMovieName(), movie.getDuration(), movie.getForAdults());
    }

    @Override
    public List<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movie",
                BeanPropertyRowMapper.newInstance(Movie.class));
    }

    @Override
    public Movie getByName(String name) throws MovieNotFoundException {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM movie WHERE movieName = ?",
                    BeanPropertyRowMapper.newInstance(Movie.class), name);
        } catch (EmptyResultDataAccessException e) {
            throw new MovieNotFoundException("Movie with name " + name + " not found");
        }
    }
}
