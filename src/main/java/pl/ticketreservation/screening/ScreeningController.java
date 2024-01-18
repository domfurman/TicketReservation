package pl.ticketreservation.screening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.ticketreservation.seat.seatrepository.JdbcSeatRepository;

@Controller
public class ScreeningController {
    private final ScreeningService screeningService;
    private final JdbcSeatRepository jdbcSeatRepository;


    @Autowired
    public ScreeningController(ScreeningService screeningService, JdbcSeatRepository jdbcSeatRepository) {
        this.screeningService = screeningService;
        this.jdbcSeatRepository = jdbcSeatRepository;
    }

    @GetMapping(path = "/screenings")
    String getScreenings(Model model) {
        model.addAttribute("screeningList",
                screeningService.getAllScreenings());
        return "all-screenings";
    }

    @GetMapping(path = "/screenings/{screeningId}")
    public String getScreening(@PathVariable("screeningId") int screeningId, Model model) {
        model.addAttribute("screening",
                screeningService.getScreeningById(screeningId));
        model.addAttribute("seats",
                jdbcSeatRepository.findSeatsByScreeningId(screeningId));
        model.addAttribute("availableSeats",
                jdbcSeatRepository.findAvailableSeatsByScreeningId(screeningId));
        model.addAttribute("movieName",
                screeningService.findMovieNameByScreeningId(screeningId));
        return "single-screening";
    }
}


