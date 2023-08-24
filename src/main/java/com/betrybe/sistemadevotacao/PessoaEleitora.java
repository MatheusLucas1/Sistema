package com.betrybe.sistemadevotacao;

public class PessoaEleitora extends Pessoa {


  private String cpf;

  /**
   * Classe que representa uma pessoa eleitora.
   */
  public PessoaEleitora(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }


}
