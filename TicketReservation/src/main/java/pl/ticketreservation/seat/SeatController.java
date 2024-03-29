package pl.ticketreservation.seat;

//import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.ticketreservation.seat.seatrepository.JdbcSeatRepository;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class SeatController {

    private final JdbcSeatRepository jdbcSeatRepository;

    @Autowired
    public SeatController(JdbcSeatRepository jdbcSeatRepository) {
        this.jdbcSeatRepository = jdbcSeatRepository;
    }

    @GetMapping(path = "{movieId}/ticket")
    public ResponseEntity<List<Seat>> getSeats(Model model, @PathVariable("movieId") int movieId) {
        List<Seat> seats = jdbcSeatRepository.findAllSeatsForMovie(movieId);
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    /*@GetMapping(path = "api/seats")
    public ResponseEntity<List<Seat>> getAllSeats() {
        return jdbcSeatRepository.findAllSeatsForMovie(1);
    }*/
}
