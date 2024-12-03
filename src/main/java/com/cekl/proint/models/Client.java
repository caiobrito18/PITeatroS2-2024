package com.cekl.proint.models;

import java.util.ArrayList;
import java.util.List;
//CLasse auxiliar para representar o Cliente que compra os ingressos
public class Client {
    private final String cpf;
    private final List<Ticket> tickets;

    public Client(String cpf) {
        this.cpf = cpf;
        this.tickets = new ArrayList<>();
    }
//retorna o cpf do cliente
    public String getCpf() {
        return cpf;
    }
//retorna a lista de ingressos do cliente
    public List<Ticket> getTickets() {
        return tickets;
    }
//adiciona um ingresso a lista
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
//remove um ingresso da lista do cliente
    public void removerTicket(Ticket ticket) {
        tickets.remove(ticket);
    }
}