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
    public User user;
    public Screening screening;
    public Seat seat;
    public typeOfTicket typeOfTicket;
    public BigDecimal price;

    public enum typeOfTicket{
        NORMAL,
        VIP,
        PROMO

    }

    public BigDecimal getPrice(){
        BigDecimal price = null;
        switch (typeOfTicket){
            case NORMAL:
                price = BigDecimal.valueOf(18.00);
            case VIP:
                price = BigDecimal.valueOf(24.00);
            case PROMO:
                price = BigDecimal.valueOf(14.00);
        }
        return price;
    }
}
