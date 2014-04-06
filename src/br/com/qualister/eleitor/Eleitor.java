package br.com.qualister.eleitor;

import java.util.Calendar;

/**
 * Classe para expressar o eleitor
 * @author Elias Nogueira
 */
public class Eleitor {

	/*
	 * Enumeração para definir o tipo de voto
	 */
	public enum TipoVoto {
		OBRIGATORIO, FACULTATIVO, NEGADO;
	}
	
	@SuppressWarnings("unused")
	/*
	 * Atributos do Eleitor
	 */
	private String nome;
	private int nascimento;
	
	/*
	 * Construtor do Eleitor para a criação de seu objeto concreto
	 */
	public Eleitor(String nome, int nascimento) {
		this.nome = nome;
		this.nascimento = nascimento;
	}

	/*
	 * Metodo que verifica a idade do eleitor e retorna se ele pode ou nao
	 * efetuar o pre-cadastro
	 */
	public String podeVotar() {
		String voto = null;
		
		int idade = calculaIdade(nascimento);
		
		if (idade < 16) {
			voto = TipoVoto.NEGADO.toString();
		} else if ((idade >= 16) & (idade < 18) || (idade >= 70)) {
			voto = TipoVoto.FACULTATIVO.toString();
		} else {
			voto = TipoVoto.OBRIGATORIO.toString();
		}
		
		return voto;
	}
	
	/*
	 * Metodo de apoio que calcula a idade do eleitor dado a sua
	 * data de nascimento
	 */
	private int calculaIdade(int nascimento) {
		final Calendar calendar = Calendar.getInstance();
		
		return calendar.get(Calendar.YEAR) - nascimento;
	}

}
