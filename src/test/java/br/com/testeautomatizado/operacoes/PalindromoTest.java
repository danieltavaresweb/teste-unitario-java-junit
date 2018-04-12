package br.com.testeautomatizado.operacoes;

import org.junit.Test;
import org.junit.Assert;

public class PalindromoTest {

	@Test
	public void verificaSeFunciona(){
		
		Palindromo palin = new Palindromo();
		
		boolean palavra1 = palin.ehPalindromo("Socorram-me subi no onibus em Marrocos");
		boolean palavra2 = palin.ehPalindromo("Anotaram a data da maratona");
		
		Assert.assertEquals(true, palavra1);
		Assert.assertEquals(true, palavra2);
		
	}
	
	@Test
	public void deveIdentificarSeNaoEhPalindromo(){
		Palindromo palin = new Palindromo();
		
		Assert.assertFalse(palin.ehPalindromo("Sergio antonio"));
	}
}
