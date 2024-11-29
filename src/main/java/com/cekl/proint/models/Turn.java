package com.cekl.proint.models;

import java.util.ArrayList;
import java.util.List;

public class Turn {

  private final List<Ticket> tickets;
  private Seats seats = new Seats();
  public Turn() {
    this.tickets = new ArrayList<>();
  }

  public void addTicket(Ticket ticket) {
    tickets.add(ticket);
  }

  public void removeTicket(Ticket ticket) {
    tickets.remove(ticket);
  }

  public int getTotalTicketsSold() {
    return tickets.size();
  }

  public double getRevenue() {
    return tickets.stream().mapToDouble(Ticket::getPreco).sum();
  }

    /**
     * @return the seats
     */
    public Seats getSeats() {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(Seats seats) {
        this.seats = seats;
    }
}