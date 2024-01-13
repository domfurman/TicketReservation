package pl.ticketreservation.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.ticketreservation.movie.movierepository.JdbcMovieRepository;
import pl.ticketreservation.movie.movierepository.MovieNotFoundException;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    JdbcMovieRepository movieRepository;

    @GetMapping(path = "/api/movies")
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/api/{name}")
    public Movie getByName(@PathVariable("name") String name, Model model) {
        try {
            Movie movie = movieRepository.getByName(name);
            model.addAttribute("movie", movie);
            return movie;
        } catch (MovieNotFoundException e) {
            return null;
        }
    }
}

