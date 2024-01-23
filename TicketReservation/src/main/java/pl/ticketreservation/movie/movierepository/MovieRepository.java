package pl.ticketreservation.movie.movierepository;

import pl.ticketreservation.movie.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> findAll();
    Movie getByName(String name) throws MovieNotFoundException;

    Movie getMovieInfoByTicketId(int ticketId);
}
