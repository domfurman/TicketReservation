package pl.ticketreservation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDateTime;

public class MovieTest {

    @Test
    void thereIsMovie() {
        Movie movie = new Movie("Jaws3", Duration.ofHours(3), LocalDateTime.parse("2023-02-02T12:00:00"));

        assertNotNull(movie);
    }
}
