package pl.ticketreservation.screening;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ticketreservation.auditorium.Auditorium;
import pl.ticketreservation.movie.Movie;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Screening {
    public int screeningId;
    public String movieName;
    public LocalDateTime date;
    public String auditoriumName;

}
