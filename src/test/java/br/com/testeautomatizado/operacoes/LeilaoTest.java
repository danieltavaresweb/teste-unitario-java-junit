package br.com.testeautomatizado.operacoes;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.testeautomatizado.domain.Lance;
import br.com.testeautomatizado.domain.Leilao;
import br.com.testeautomatizado.domain.Usuario;

public class LeilaoTest {
	
	@Before
	public void testandoBefore(){
		System.out.println("Before - executa antes de cada teste.");
	}
	
	@BeforeClass
	public static void testandoBeforeClass(){
		System.out.println("Before class - executa apenas uma vez");
	}
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario(){
		Leilao leilao = new Leilao("Play 3");
		
		Usuario sergio = new Usuario("sergio");
		
		leilao.propoe(new Lance(sergio, 200.0));
		leilao.propoe(new Lance(sergio, 200.0));
		
		assertEquals(1, leilao.getLances().size());
	}
	
	@Test
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario(){
		Leilao leilao = new Leilao("Play 3");
		
		Usuario pedro = new Usuario("pedro");
		Usuario sergio = new Usuario("sergio");
		
		leilao.propoe(new Lance(sergio, 200.0));
		leilao.propoe(new Lance(pedro, 430.0));
		leilao.propoe(new Lance(sergio, 1600.0));
		leilao.propoe(new Lance(pedro, 6700.0));
		leilao.propoe(new Lance(sergio, 5900.0));
		leilao.propoe(new Lance(pedro, 760.0));
		leilao.propoe(new Lance(sergio, 34700.0));
		leilao.propoe(new Lance(pedro, 566.0));
		leilao.propoe(new Lance(sergio, 580.0));
		leilao.propoe(new Lance(pedro, 8580.0));
		
		//nao pode adicionar 
		leilao.propoe(new Lance(sergio, 111.0));
		
		assertEquals(10, leilao.getLances().size());
		assertEquals(8580.0, leilao.getLances().get(leilao.getLances().size() - 1).getValor(), 0.0001);
		
			
		
	}
	
	@Test
	public void deveDobrarUltimoLanceDoUsuario(){
		Leilao leilao = new Leilao("Play 3");
		
		Usuario pedro = new Usuario("pedro");
		Usuario sergio = new Usuario("sergio");
		
		leilao.propoe(new Lance(sergio, 200.0));
		leilao.propoe(new Lance(pedro, 430.0));
		leilao.propoe(new Lance(sergio, 1600.0));
		leilao.propoe(new Lance(pedro, 6700.0));
		leilao.dobraLance(sergio);
		
		assertEquals(3200.0, leilao.getLances().get(leilao.getLances().size() -1).getValor(), 0.001);
		
		
	}
	
	@Test 
	public void naoDeveDobrarCasoNaoHajaLanceAnterior(){
		Leilao leilao = new Leilao("Play 3");
		Usuario pedro = new Usuario("pedro");
		Usuario sergio = new Usuario("sergio");
		
		leilao.dobraLance(sergio);
		
		assertEquals(0, leilao.getLances().size());
	
		
	
	}
	
}
