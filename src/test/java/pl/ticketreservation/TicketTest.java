package pl.ticketreservation;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import pl.ticketreservation.client.Client;
import pl.ticketreservation.movie.Movie;
import pl.ticketreservation.ticket.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class TicketTest {

    @Test
    public void thereIsTicket(){
        Client client = new Client();
        Movie movie = new Movie("Jaws", Duration.ofHours(2), LocalDateTime.parse("2020-01-01T08:00:00"));
        Ticket ticket = new Ticket(1, 25f, client, "F", "3", movie);

        assertNotNull(ticket);
    }
}
