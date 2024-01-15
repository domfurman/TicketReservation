package pl.ticketreservation.screening.screeningrepository;

import pl.ticketreservation.movie.Movie;
import pl.ticketreservation.screening.Screening;

import java.util.List;

public interface ScreeningRepository {
    List<Screening> findAll();
}