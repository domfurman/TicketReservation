package pl.ticketreservation;

import pl.ticketreservation.ticket.Ticket;

public class Client {
    private String name;
    private String surname;
    private int age;
    private boolean isAdult;
    private Ticket ticketID;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
        if(age >= 18){
            isAdult = true;
        } else {
            isAdult = false;
        }
    }
    public boolean isAdult() {
        return isAdult;
    }

    public Ticket getTicketID() {
        return ticketID;
    }

    public void buyTicket(Movie name, Ticket ticket){

    }

}
