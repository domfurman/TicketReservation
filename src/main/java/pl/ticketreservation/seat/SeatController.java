package pl.ticketreservation.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ticketreservation.movie.movierepository.JdbcMovieRepository;
import pl.ticketreservation.seat.seatrepository.JdbcSeatRepository;

import java.util.List;

@RestController
public class SeatController {

    private final JdbcSeatRepository jdbcSeatRepository;

//    @Autowired
//    JdbcSeatRepository seatRepository;

    @Autowired
    public SeatController(JdbcSeatRepository jdbcSeatRepository) {
        this.jdbcSeatRepository = jdbcSeatRepository;
    }

    @GetMapping(path = "api/seats")
    public List<Seat> getSeats() {
        return jdbcSeatRepository.findAllSeatsForMovie(1);
    }
}
