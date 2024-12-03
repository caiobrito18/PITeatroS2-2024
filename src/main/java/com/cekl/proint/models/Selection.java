/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cekl.proint.models;

/**
 *
 * @author caio
 * Classe auxiliar para armazenar os dados da tela de compra para renderização
 */
public class Selection {
  private String cpf;
  private String peca;
  private String sessao;
  private int area;
  private int poltrona;

  public Selection(){
  }
  public Selection(String cpf, String peca, String turn, int area, int poltrona) {
    this.cpf = cpf;
    this.peca = peca;
    this.sessao = turn;
    this.area = area;
    this.poltrona = poltrona;
  }
/**
     * @return the cpf
     */
    public double getAreaPreco() {
        return Seats.getAreas().get(area).getPreco();
    }
    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the peca
     */
    public String getPeca() {
        return peca;
    }

    /**
     * @param peca the peca to set
     */
    public void setPeca(String peca) {
        this.peca = peca;
    }

    /**
     * @return the sessao
     */
    public String getSessao() {
        return sessao;
    }

    /**
     * @param sessao the sessao to set
     */
    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    /**
     * @return the area
     */
    public int getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(int area) {
        this.area = area;
    }

    /**
     * @return the poltrona
     */
    public int getPoltrona() {
        return poltrona;
    }

    /**
     * @param poltrona the poltrona to set
     */
    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }



}
