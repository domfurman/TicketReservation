package pl.ticketreservation.seat.seatrepository;

import pl.ticketreservation.seat.Seat;

import java.util.List;

public interface SeatRepository {

    List<Seat> findAllSeatsForMovie(int movieId);

    List<Seat> findSeatsByScreeningId(int screeningId);

    List<Seat> findAvailableSeatsByScreeningId(int screeningId);


}
