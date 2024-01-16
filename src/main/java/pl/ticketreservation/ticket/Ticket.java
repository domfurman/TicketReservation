package pl.ticketreservation.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    public int ticketId;
    public int userId;
    public int screeningId;
    public int seatId;
    public int typeId;

    public enum typeOfTicket {
        NORMAL,
        PROMO,
        VIP


    }
}
