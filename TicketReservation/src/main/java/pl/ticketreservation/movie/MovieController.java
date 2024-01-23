package pl.ticketreservation.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.ticketreservation.movie.movierepository.JdbcMovieRepository;
import pl.ticketreservation.movie.movierepository.MovieNotFoundException;

import java.util.List;

@RestController
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(path = "/api/movies")
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/api/{name}")
    public Movie getByName(@PathVariable("name") String name, Model model) {
        /*try {
            Movie movie = movieService.getMovieByName(name);
            model.addAttribute("movie", movie);
            return movie;
        } catch (MovieNotFoundException e) {
            return null;
        }*/
        Movie movie = movieService.getMovieByName(name);
        model.addAttribute("movie", movie);
        return movie;
    }
}

