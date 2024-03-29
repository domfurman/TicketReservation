package pl.ticketreservation.screening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ticketreservation.movie.Movie;
import pl.ticketreservation.screening.screeningrepository.JdbcScreeningRepository;

import java.util.List;

@Service
public class ScreeningService {
    private final JdbcScreeningRepository jdbcScreeningRepository;

    @Autowired
    public ScreeningService(JdbcScreeningRepository jdbcScreeningRepository) {
        this.jdbcScreeningRepository = jdbcScreeningRepository;
    }

    public List<Screening> getAllScreenings() {
        return jdbcScreeningRepository.findAll();
    }

    public Screening getScreeningById(int screeningId) {
        return jdbcScreeningRepository.findScreening(screeningId);
    }

    String findMovieNameByScreeningId(int screeningId) {
        return jdbcScreeningRepository.findMovieNameByScreeningId(screeningId);
    }

    public Screening getScreeningInfoByTicketId(int ticketId) {
        return jdbcScreeningRepository.getScreeningInfoByTicketId(ticketId);
    }

    public Movie getMovieByScreeningId(int screeningId) {
        return jdbcScreeningRepository.findMovieByScreeningId(screeningId);
    }

    public int createNewScreening(Screening screening) {
        return jdbcScreeningRepository.createNewScreening(screening);
    }
}
