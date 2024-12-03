package com.cekl.proint.models;

import java.util.ArrayList;
import java.util.List;
//Classe auxiliar para Representar os turnos 

public class Turn {
   //Cada turno tem uma lista de Tickets e uma lista de bancos
  private final List<Ticket> tickets;
  private Seats seats = new Seats();
  public Turn() {
    this.tickets = new ArrayList<>();
  }
  //adiciona um ticket na lista do turno
  public void addTicket(Ticket ticket) {
    tickets.add(ticket);
  }
  // remove o ricket da lista do turno
  public void removeTicket(Ticket ticket) {
    tickets.remove(ticket);
  }
  //pega o total de Tickets Vendidos
  public int getTotalTicketsSold() {
    return tickets.size();
  }
  //pega o total de dinheiro gerado pelos tickets vendidos no turno
  public double getRevenue() {
    return tickets.stream().mapToDouble(Ticket::getPreco).sum();
  }

    /**
     * Retorna os bancos
     */
    public Seats getSeats() {
        return seats;
    }

    /**
     * Adiciona os bancos à lista de bancos
     */
    public void setSeats(Seats seats) {
        this.seats = seats;
    }
}