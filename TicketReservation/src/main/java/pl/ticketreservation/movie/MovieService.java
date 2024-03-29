package pl.ticketreservation.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.ticketreservation.movie.Movie;
import pl.ticketreservation.movie.movierepository.JdbcMovieRepository;
import pl.ticketreservation.movie.movierepository.MovieNotFoundException;
import pl.ticketreservation.movie.movierepository.MovieRepository;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieByName(String movieName) {
        try {
            Movie movie = movieRepository.getByName(movieName);
//            model.addAttribute("movie", movie);
            return movie;
        } catch (MovieNotFoundException e) {
            return null;
        }
    }


    public Movie getMovieInfoByTicketId(int ticketId) {
        return movieRepository.getMovieInfoByTicketId(ticketId);
    }

    public int addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }
}
