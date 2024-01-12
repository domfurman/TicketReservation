package pl.ticketreservation.seat.seatrepository;

import pl.ticketreservation.seat.Seat;

import java.util.List;

public interface SeatRepository {

    List<Seat> findAllSeatsForMovie(int movieName);


}
