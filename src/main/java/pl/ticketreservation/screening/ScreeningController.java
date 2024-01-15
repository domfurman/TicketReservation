package pl.ticketreservation.screening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ticketreservation.screening.screeningrepository.JdbcScreeningRepository;

import java.util.List;

@RestController
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
}


