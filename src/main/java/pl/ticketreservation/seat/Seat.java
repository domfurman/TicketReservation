package pl.ticketreservation.seat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    private int seatId;
    private int row;
    private int seatNo;
    private int screeningRoomId;
    private boolean isTaken = false;


}
