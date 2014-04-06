package br.com.qualister.eleitor.test.unitario;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.qualister.eleitor.Eleitor;
import br.com.qualister.eleitor.Eleitor.TipoVoto;

/**
 * Classe contendo os testes unitarios utilizando JUnit
 * @author Elias Nogueira
 */
public class TestePreCadastro {

	@Test
	public void testaNaoPodeVotar() {
		Eleitor eleitor = new Eleitor("Elias Nogueira", 2000);
		assertEquals(TipoVoto.NEGADO.toString(), eleitor.podeVotar());
	}
	
	@Test
	public void testaVotoFacultativo16Anos() {
		Eleitor eleitor = new Eleitor("Elias Nogueira", 1998);
		assertEquals(TipoVoto.FACULTATIVO.toString(), eleitor.podeVotar());
	}	
	
	@Test
	public void testaVotoFacultativo17Anos() {
		Eleitor eleitor = new Eleitor("Elias Nogueira", 1997);
		assertEquals(TipoVoto.FACULTATIVO.toString(), eleitor.podeVotar());
	}
	
	@Test
	public void testaVotoFacultativo70Anos() {
		Eleitor eleitor = new Eleitor("Elias Nogueira", 1944);
		assertEquals(TipoVoto.FACULTATIVO.toString(), eleitor.podeVotar());
	}
	
	@Test
	public void testaVotoFacultativo71Anos() {
		Eleitor eleitor = new Eleitor("Elias Nogueira", 1943);
		assertEquals(TipoVoto.FACULTATIVO.toString(), eleitor.podeVotar());
	}
	
	@Test
	public void testeVotoObirgatorio18Anos() {
		Eleitor eleitor = new Eleitor("Elias Nogueira", 1996);
		assertEquals(TipoVoto.OBRIGATORIO.toString(), eleitor.podeVotar());
	}
	
	@Test
	public void testeVotoObirgatorio30Anos() {
		Eleitor eleitor = new Eleitor("Elias Nogueira", 1984);
		assertEquals(TipoVoto.OBRIGATORIO.toString(), eleitor.podeVotar());
	}
		
	
	@Test
	public void testeVotoObirgatorio69Anos() {
		Eleitor eleitor = new Eleitor("Elias Nogueira", 1945);
		assertEquals(TipoVoto.OBRIGATORIO.toString(), eleitor.podeVotar());
	}

}
