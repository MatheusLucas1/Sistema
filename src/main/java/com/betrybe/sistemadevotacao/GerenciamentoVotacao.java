package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe responsável por gerenciar o processo de votação.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {


  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfsComputados = new ArrayList<String>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {

    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        return;
      }
    }
    PessoaCandidata novoCandidato = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(novoCandidato);
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {

    for (PessoaEleitora pessoasEleitora : pessoasEleitoras) {
      if (pessoasEleitora.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }
    PessoaEleitora novaPessoaEleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(novaPessoaEleitora);
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (String cpfComputado : cpfsComputados) {
      if (Objects.equals(cpfComputado, cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
        return;
      }
    }

    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
        pessoaCandidata.receberVoto();
      }
    }

    cpfsComputados.add(cpfPessoaEleitora);

  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("Pessoa eleitora já votou!");
    }

    short totalVotos = (short) cpfsComputados.size();

    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      short votosCandidato = (short) pessoaCandidata.getVotos();
      String nomeCandidato = pessoaCandidata.getNome();
      double porcentagemVotos = (double) votosCandidato / totalVotos * 100;
      System.out.printf("\nNome: %s - %d votos ( %2f )\n", nomeCandidato, votosCandidato,
          porcentagemVotos);
    }
    System.out.printf("Total de votos: %d\n", totalVotos);
  }

}
