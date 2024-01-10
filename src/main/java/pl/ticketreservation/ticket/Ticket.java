package pl.ticketreservation.ticket;

import pl.ticketreservation.Client;
import pl.ticketreservation.Movie;

public class Ticket {
    private int ticketId;
    private float price;
    private Client owner;
    private String row;
    private String seat;
    private Movie movieName;

    public Ticket(int ticketId, float price, Client owner, String row, String seat, Movie movieName) {
        this.ticketId = ticketId;
        this.price = price;
        this.owner = owner;
        this.row = row;
        this.seat = seat;
        this.movieName = movieName;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Movie getMovieName() {
        return movieName;
    }

    public void setMovieName(Movie movieName) {
        this.movieName = movieName;
    }
}
