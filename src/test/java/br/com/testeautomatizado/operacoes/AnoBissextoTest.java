package br.com.testeautomatizado.operacoes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class AnoBissextoTest {
	
	@Test
	public void verificaSeEhBissexto(){
		AnoBissexto ano = new AnoBissexto();
		assertTrue(ano.ehBissexto(2016));
	}
}
