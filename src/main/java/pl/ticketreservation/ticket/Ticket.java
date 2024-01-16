package pl.ticketreservation.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ticketreservation.user.User;
import pl.ticketreservation.screening.Screening;
import pl.ticketreservation.seat.Seat;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    public int ticketId;
    public int userId;
    public int screeningId;
    public int seatId;
    public int typeId;

    public enum typeOfTicket{
        NORMAL,
        VIP,
        PROMO

    }
}
