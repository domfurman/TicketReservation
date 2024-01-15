package pl.ticketreservation.screening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ticketreservation.movie.Movie;
import pl.ticketreservation.screening.screeningrepository.JdbcScreeningRepository;

import java.util.List;

@Service
public class ScreeningService {
    private JdbcScreeningRepository jdbcScreeningRepository;

    @Autowired
    public ScreeningService(JdbcScreeningRepository jdbcScreeningRepository) {
        this.jdbcScreeningRepository = jdbcScreeningRepository;
    }

    public List<Screening> getAllScreenings() {
        return jdbcScreeningRepository.findAll();
    }
}
