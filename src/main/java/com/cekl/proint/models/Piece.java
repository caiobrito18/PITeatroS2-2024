package com.cekl.proint.models;

import java.util.HashMap;
import java.util.Map;
//Classe auxiliar para representar as peças que são ofertadas pelo teatro

public class Piece {
    private final String nome;
    private final Map<String, Turn> turns;

    public Piece(String nome) {
        this.nome = nome;
        this.turns = new HashMap<>();
        turns.put("Manhã", new Turn());
        turns.put("Tarde", new Turn());
        turns.put("Noite", new Turn());
    }
//retorna o nome da peça
    public String getName() {
        return nome;
    }
//retornas os turnos presentes em cada peça
    public Map<String, Turn> getTurns() {
        return turns;
    }
//Retorna o total de ingressos vendidos em todas as área
    public int getTotalTicketsSold() {
        return turns.values().stream().mapToInt(Turn::getTotalTicketsSold).sum();
    }
//retorna o total de Dinheiro feito com todas as áreas
    public double getTotalRevenue() {
        return turns.values().stream().mapToDouble(Turn::getRevenue).sum();
    }
}