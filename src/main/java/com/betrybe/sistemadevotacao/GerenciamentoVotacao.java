package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private final ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();

  private final ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();

  private final ArrayList<String> cpfsComputados = new ArrayList<String>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pessoasCandidata : pessoasCandidatas) {

      int numeroCandidato = pessoasCandidata.getNumero();

      if (numeroCandidato == numero) {
        System.out.println("Pessoa candidata já cadastrada!");
      } else {
        PessoaCandidata candidato = new PessoaCandidata(nome, numero);
        pessoasCandidatas.add(candidato);
      }
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
//    int cpfToInt = Integer.parseInt(cpf);
    for (PessoaEleitora pessoasEleitora : pessoasEleitoras) {

      String cpfEleitor = pessoasEleitora.getCpf();

      if (cpfEleitor.equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
      } else {
        PessoaEleitora eleitor = new PessoaEleitora(nome, cpf);
        pessoasEleitoras.add(eleitor);
      }
    }
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

  }

  @Override
  public void mostrarResultado() {

  }
}
