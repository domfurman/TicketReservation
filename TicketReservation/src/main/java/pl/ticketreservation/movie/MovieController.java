package pl.ticketreservation.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.ticketreservation.movie.movierepository.JdbcMovieRepository;
import pl.ticketreservation.movie.movierepository.MovieNotFoundException;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(path = "/api/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/api/{name}")
    public ResponseEntity<Movie> getByName(@PathVariable("name") String name) {
        /*try {
            Movie movie = movieService.getMovieByName(name);
            model.addAttribute("movie", movie);
            return movie;
        } catch (MovieNotFoundException e) {
            return null;
        }*/
        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping(path = "/api/add-movie")
    public ResponseEntity<Integer> addMovie(@RequestBody Movie movie) {
        /*Movie movie = new Movie();
        movie.setMovieName(movieName);
        movie.setDuration(duration);
        movie.setForAdults(forAdults);*/
        int id = movieService.addMovie(movie);
        return ResponseEntity.ok(id);
    }
}

