package br.com.testeautomatizado.operacoes;

import org.junit.Before;
import org.junit.Test;

import br.com.testeautomatizado.domain.Lance;
import br.com.testeautomatizado.domain.Usuario;

public class LanceTest {
	
	
	private Usuario steve;
	private Usuario carlos;
	@Before
	public void criaUsuarios(){
		this.steve = new Usuario("Steve");
		this.carlos = new Usuario("carlos");		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void paraLancesMenoresQue0(){
		Lance lance = new Lance(steve, -100);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void paraaLancesIguaisA0(){
		Lance lance = new Lance(carlos, 0);
	}
}
