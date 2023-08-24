package com.betrybe.sistemadevotacao;

public class PessoaCandidata extends Pessoa {

  private int numero;
  private int votos;

  public PessoaCandidata(String nome, int numero) {
    this.numero = numero;
    this.nome = nome;
    this.votos = 0;
  }

  public int getNumero() {
    return this.numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return this.votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }

  public void receberVoto() {
    this.votos++;
  }


}
