package pl.ticketreservation.ticket;

import pl.ticketreservation.Client;
import pl.ticketreservation.Movie;

public class VIPTicket extends Ticket{
    private float ticketPrice;

    public VIPTicket(int ticketId, float price, Client owner, String row, String seat, Movie movieName) {
        super(ticketId, price, owner, row, seat, movieName);
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
