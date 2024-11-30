/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cekl.proint.models;

/**
 *
 * @author caio
 */

    // Classe auxiliar para armazenar os dados de uma venda
    public class Venda {
        String cpf, peca, sessao, area, poltrona;
        double preco;
        String dataCompra;

        public Venda(String cpf, String peca, String sessao, String area, String poltrona, double preco, String dataCompra) {
            this.cpf = cpf;
            this.peca = peca;
            this.sessao = sessao;
            this.area = area;
            this.poltrona = poltrona;
            this.preco = preco;
            this.dataCompra = dataCompra;
        }
    }