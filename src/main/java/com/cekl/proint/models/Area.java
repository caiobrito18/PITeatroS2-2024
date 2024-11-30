package com.cekl.proint.models;

// Classe que representa uma área específica em um local (ex.: setor do teatro),
// com informações sobre assentos, preços e controle de vendas.
public class Area {
    private final boolean[] seats; // Array que representa os assentos da área (true = ocupado, false = disponível).
    private final double preco;   // Preço por assento nesta área.

    // Construtor que inicializa o número total de assentos e o preço por assento.
    public Area(int totalSeats, double preco) {
        this.seats = new boolean[totalSeats]; // Inicializa todos os assentos como disponíveis (false).
        this.preco = preco; // Define o preço do assento.
    }

    // Retorna o número total de assentos nesta área.
    public int getTotalSeats() {
        return seats.length;
    }

    // Retorna o preço do assento nesta área.
    public double getPreco() {
        return preco;
    }

    // Verifica se um assento específico está ocupado.
    public boolean isSeatOccupied(int index) {
        return seats[index];
    }

    // Marca um assento específico como vendido (ocupado).
    public void buySeats(int index) {
        seats[index] = true;
    }

    // Cancela a venda de um assento específico, tornando-o disponível novamente.
    public void cancelSeats(int index) {
        seats[index] = false;
    }

    // Retorna o número total de tickets vendidos nesta área.
    public int getTotalTicketsSold() {
        int total = 0;
        for (boolean seat : seats) { // Itera pelos assentos para contar os ocupados.
            if (seat) {
                total++;
            }
        }
        return total;
    }

    // Calcula a receita total gerada por esta área com base no número de tickets vendidos e no preço por assento.
    public double getReceita() {
        return getTotalTicketsSold() * preco; // Multiplica o total de vendas pelo preço por assento.
    }
}
