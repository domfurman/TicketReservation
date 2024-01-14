package pl.ticketreservation.seat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ticketreservation.auditorium.Auditorium;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    public int seatId;
    public int row;
    public int seatNo;
    public Auditorium auditorium;
}
