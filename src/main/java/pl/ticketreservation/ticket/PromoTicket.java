package pl.ticketreservation.ticket;

import pl.ticketreservation.Client;
import pl.ticketreservation.Movie;

public class PromoTicket extends Ticket{
    private float ticketPrice = getPrice()*0.75f;

    public PromoTicket(int ticketId, float price, Client owner, String row, String seat, Movie movieName) {
        super(ticketId, price, owner, row, seat, movieName);
    }
}
