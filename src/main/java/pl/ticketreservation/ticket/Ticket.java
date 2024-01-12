package pl.ticketreservation.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ticketreservation.client.Client;
import pl.ticketreservation.movie.Movie;
import pl.ticketreservation.seat.Seat;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private int ticketId;
    private float price;
    private Client owner;
    private Seat seat;
    private Movie movieName;
    private typeOfTicket typeOfTicket;

    enum typeOfTicket{
        NORMAL,
        PROMO,
        VIP
    }
}
