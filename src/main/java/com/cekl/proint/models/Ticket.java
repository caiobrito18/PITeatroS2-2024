package com.cekl.proint.models;

public class Ticket {
  private final String cpf;
  private final String peca;
  private final String sessao;
  private final String area;
  private final int poltrona;
  private final double preco;
 
  //classe auxiliar para representar os ingressos
  public Ticket(String cpf, String peca, String turno, String area, int poltrona, double preco) {
    this.cpf = cpf;
    this.peca = peca;
    this.sessao = turno;
    this.area = area;
    this.poltrona = poltrona;
    this.preco = preco;
  }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @return the peca
     */
    public String getPeca() {
        return peca;
    }

    /**
     * @return the sessao
     */
    public String getSessao() {
        return sessao;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @return the poltrona
     */
    public int getPoltrona() {
        return poltrona;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

}