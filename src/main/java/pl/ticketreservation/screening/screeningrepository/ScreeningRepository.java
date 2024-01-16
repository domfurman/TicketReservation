package pl.ticketreservation.screening.screeningrepository;

import pl.ticketreservation.screening.Screening;
import java.util.List;

public interface ScreeningRepository {
    List<Screening> findAll();

    Screening findScreening(int screeningId);
}
