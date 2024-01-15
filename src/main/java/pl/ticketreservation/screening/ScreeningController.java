package pl.ticketreservation.screening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.ticketreservation.seat.seatrepository.JdbcSeatRepository;

@Controller
public class ScreeningController {
    private ScreeningService screeningService;

    @Autowired
    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @GetMapping(path = "/api/screenings")
    public List<Screening> getMovies() {
        return screeningService.getAllScreenings();
    }

    @GetMapping(path = "/screening/{screeningId}")
    public String getScreening(@PathVariable("screeningId") int screeningId, Model model) {
        model.addAttribute("screening",
                screeningService.getScreeningById(screeningId));
        model.addAttribute("seats",
//                #TODO implement this method
                jdbcSeatRepository.getSeatsByScreeningId(screeningId));
        return "single-screening";
    }
}


