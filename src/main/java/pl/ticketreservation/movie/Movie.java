package pl.ticketreservation.movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    public Integer movie_id;
    public String movie_name;
    public LocalDateTime date;
    public int duration;
}
