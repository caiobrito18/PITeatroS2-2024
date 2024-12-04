/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cekl.proint.models;

/**
 *
 * @author caio
 */
public class User {
  private final String cpf;
  private final String nome;
  private final String telefone;
  private final String dataNascimento;
  private final String endereco;
 
  //classe auxiliar para representar os ingressos
  public User(String cpf, String nome, String telefone, String dataNascimento, String endereco) {
    this.cpf = cpf;
    this.nome = nome;
    this.telefone = telefone;
    this.dataNascimento = dataNascimento;
    this.endereco = endereco;
  }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @return the dataNascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }
}
