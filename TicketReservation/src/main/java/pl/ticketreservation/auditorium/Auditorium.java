package pl.ticketreservation.auditorium;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auditorium {

    public int auditoriumId;
    public String name;
    public int seatsNo;
}
