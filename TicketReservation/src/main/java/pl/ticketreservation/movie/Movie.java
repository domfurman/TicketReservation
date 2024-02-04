package pl.ticketreservation.movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    public Integer movieId;
    public String movieName;
    public int duration;
    public boolean forAdults;

    public boolean getForAdults() {
        return forAdults;
    }

}
