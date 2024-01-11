package pl.ticketreservation.ticket;

import pl.ticketreservation.client.Client;
import pl.ticketreservation.movie.Movie;

public class NormalTicket extends Ticket{
    private float ticketPrice;

    public NormalTicket(int ticketId, float price, Client owner, String row, String seat, Movie movieName) {
        super(ticketId, price, owner, row, seat, movieName);
    }
}
