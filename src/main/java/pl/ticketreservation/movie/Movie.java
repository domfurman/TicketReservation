package pl.ticketreservation.movie;

import java.time.Duration;
import java.time.LocalDateTime;

public class Movie {

    public Integer id;
    public String name;
    public LocalDateTime dateAndTime;
    public Duration length;

    public Movie(Integer id, String name, LocalDateTime dateAndTime, Duration length) {
        this.id = id;
        this.name = name;
        this.dateAndTime = dateAndTime;
        this.length = length;
    }

    public Movie() {
    }

    public Integer getId() {
        return id;
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
