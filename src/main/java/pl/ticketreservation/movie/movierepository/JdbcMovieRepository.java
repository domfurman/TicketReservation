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
    public List<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM sql11676201.movie",
                BeanPropertyRowMapper.newInstance(Movie.class));
    }

    @Override
    public Movie getByName(String name) throws MovieNotFoundException {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM sql11676201.movie WHERE movieName = ?",
                    BeanPropertyRowMapper.newInstance(Movie.class), name);
        } catch (EmptyResultDataAccessException e) {
            throw new MovieNotFoundException("Movie with name " + name + " not found");
        }
    }
}
