package pl.ticketreservation.screening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.ticketreservation.movie.Movie;
import pl.ticketreservation.seat.Seat;
import pl.ticketreservation.seat.seatrepository.JdbcSeatRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ScreeningController {
    private final ScreeningService screeningService;
    private final JdbcSeatRepository jdbcSeatRepository;


    @Autowired
    public ScreeningController(ScreeningService screeningService, JdbcSeatRepository jdbcSeatRepository) {
        this.screeningService = screeningService;
        this.jdbcSeatRepository = jdbcSeatRepository;
    }

    @GetMapping(path = "/api/screenings")
    public ResponseEntity<List<Screening>> getScreenings() {
        List<Screening> screenings = screeningService.getAllScreenings();
        return new ResponseEntity<>(screenings, HttpStatus.OK);
    }

    @GetMapping(path = "api/screenings/{screeningId}")
    public ResponseEntity<ScreeningDTO> getScreening(@PathVariable("screeningId") int screeningId, Model model) {
        Screening screening = screeningService.getScreeningById(screeningId);
        Movie movie = screeningService.getMovieByScreeningId(screeningId);
        List<Seat> seats = jdbcSeatRepository.findSeatsByScreeningId(screeningId);
        List<Seat> availableSeats = jdbcSeatRepository.findAvailableSeatsByScreeningId(screeningId);

        ScreeningDTO screeningDTO = new ScreeningDTO(screening, movie, seats, availableSeats);

        return new ResponseEntity<>(screeningDTO, HttpStatus.OK);
    }

    @PostMapping(path = "api/add-screening")
    public ResponseEntity<Integer> createNewScreening(@RequestBody Screening screening) {
        int id = screeningService.createNewScreening(screening);
        return ResponseEntity.ok(id);
    }
}


