package br.com.qualister.eleitor.test.bdd;

import br.com.qualister.eleitor.Eleitor;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import static org.junit.Assert.*;

/**
 * Classe que executa o criterio de aceite para o pre-cadastro do Eleitor
 * A estutura da classe foi gerada pelo Cucumber automaticamente
 * @author Elias Nogueira
 */
public class PreCadastroStepsDefinition {

	Eleitor eleitor;
	String nome;
	int nascimento;
	
	@Dado("^que eu estou na pagina de pre-cadastro$")
	public void que_eu_estou_na_pagina_de_pre_cadastro() throws Throwable {
		assertTrue(true);
	}

	@Quando("^eu informar o nome \"(.*?)\"$")
	public void eu_informar_o_nome(String nome) throws Throwable {
		this.nome = nome;
	}

	@Quando("^quando eu informar o ano de nascimento \"(.*?)\"$")
	public void quando_eu_informar_o_ano_de_nascimento(int nascimento) throws Throwable {
		this.nascimento = nascimento;
	}

	@Entao("^meu voto e \"(.*?)\"$")
	public void meu_voto_e(String resultado) throws Throwable {
		eleitor = new Eleitor(nome, nascimento);
		assertEquals(resultado.toUpperCase(), eleitor.podeVotar());
	}
}
