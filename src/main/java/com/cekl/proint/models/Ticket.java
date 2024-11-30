package com.cekl.proint.models;

public class Ticket {
  private final String cpf;
  private final String peca;
  private final String sessao;
  private final String area;
  private final int poltrona;
  private final double preco;

  public Ticket(String cpf, String peca, String turno, String area, int poltrona, double preco) {
    String[] pecas = { "Hamlet", "Romeu e Juleita", "Otelo" };
    String[] turnos = { "manhã", "Tarde", "Noite" };
    this.cpf = cpf;
    this.peca = peca;
    this.sessao = turno;
    this.area = area;
    this.poltrona = poltrona;
    this.preco = preco;
  }

  public String getCpf() {
    return cpf;
  }

  public String getPeca() {
    return peca;
  }

  public String getSessao() {
    return sessao;
  }

  public String getArea() {
    return area;
  }

  public int getPoltrona() {
    return poltrona;
  }

  public double getPreco() {
    return preco;
  }

}