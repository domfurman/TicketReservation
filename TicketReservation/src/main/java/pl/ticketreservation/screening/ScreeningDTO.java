package pl.ticketreservation.screening;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ticketreservation.movie.Movie;
import pl.ticketreservation.seat.Seat;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScreeningDTO {
    private Screening screening;
    private Movie movie;
    private List<Seat> seats;
    private List<Seat> availableSeats;
}
