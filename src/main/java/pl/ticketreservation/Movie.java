package pl.ticketreservation;

import java.time.Duration;
import java.time.LocalDateTime;

public class Movie {
    String name;
    Duration length;
    LocalDateTime dateAndTime;

    public Movie(String name, Duration length, LocalDateTime dateAndTime) {
        this.name = name;
        this.length = length;
        this.dateAndTime = dateAndTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getLength() {
        return length;
    }

    public void setLength(Duration length) {
        this.length = length;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }


}
