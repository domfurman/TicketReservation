package pl.ticketreservation.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ticketreservation.screening.Screening;
import pl.ticketreservation.seat.Seat;
import pl.ticketreservation.user.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
    private Ticket ticket;
    private Screening screening;
    private User user;
    private Seat seat;
}
