package br.com.testeautomatizado.operacoes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.testeautomatizado.builder.CriadorDeLeilao;
import br.com.testeautomatizado.domain.Lance;
import br.com.testeautomatizado.domain.Leilao;
import br.com.testeautomatizado.domain.Usuario;
 
public class AvaliadorTest {
	
	private Avaliador leiloeiro;

	@Before
	public void setUp(){
		this.leiloeiro = new Avaliador();
	
	}
	
	@Test(expected=RuntimeException.class)
	public void testeLeilaoSemNenhumLance(){
		
		Leilao leilao = new CriadorDeLeilao()
				.para("Play 4")
				.constroi();
		
			leiloeiro.avalia(leilao);
		
	}
	
	@Test
	public void entenderLancesEmOrdemCrescente(){
		Leilao leilao = new CriadorDeLeilao().para("Play 4")
				.lance(new Usuario("Steve"), 2000.0)
				.lance(new Usuario("Pedro"), 3000.0)
				.constroi();
		
		leiloeiro.avalia(leilao);
		
		double maiorLance = 3000.0;
		double menorLance = 2000.0;
		
		assertEquals(maiorLance, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorLance, leiloeiro.getMenorLance(), 0.0001);
		}
	
	@Test
	public void testaLeilaoComApenasUmLance(){
		Usuario joao = new Usuario("Joao");
		Leilao judia = new Leilao("Play 4");
		
		judia.propoe(new Lance(joao,400.0));
		
		Avaliador sergio = new Avaliador();
		sergio.avalia(judia);
		
		assertEquals(400.0, sergio.getMaiorLance(),400.0);
		assertEquals(400.0, sergio.getMenorLance(),400.0);
	}

	@Test
	public void testaLeilaoOrdemAleatorio(){
		
		Usuario joao = new Usuario("joao");
		Usuario pedro = new Usuario("pedro");
		Usuario maria = new Usuario("maria");
		
		Leilao leilao = new Leilao("Play 4");
		
		leilao.propoe(new Lance(maria, 330.0));
		leilao.propoe(new Lance(pedro, 700.0));
		leilao.propoe(new Lance(joao, 120.0));
		leilao.propoe(new Lance(maria, 587.0));
		leilao.propoe(new Lance(joao, 180.0));
		leilao.propoe(new Lance(pedro, 500.0));
		
		leiloeiro.avalia(leilao);
		
		assertEquals(700.0, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(120.0, leiloeiro.getMenorLance(), 0.0001);		
	}
	
	@Test
	public void testaLeilaoOrdemDescrecente(){
		Usuario joao = new Usuario("joao");
		Usuario pedro = new Usuario("pedro");
		Usuario maria = new Usuario("maria");
		
		Leilao leilao = new Leilao("Play 4");
		
		leilao.propoe(new Lance(maria, 700.0));
		leilao.propoe(new Lance(pedro, 500.0));
		leilao.propoe(new Lance(joao, 300.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorLance = 700.0;
		double menorLance = 300.0;
		double valorMedio = 500.0;
		
		assertEquals(maiorLance, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorLance, leiloeiro.getMenorLance(), 0.0001);
	}
	
	@Test
	public void testaLeilaoCom5Lances(){
		Usuario joao = new Usuario("joao");
		Usuario pedro = new Usuario("pedro");
		Usuario maria = new Usuario("maria");
		
		Leilao leilao = new Leilao("Play 4");
		
		leilao.propoe(new Lance(maria, 1700.0));
		leilao.propoe(new Lance(pedro, 500.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(pedro, 1500.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 100.0));
		
		leiloeiro.avalia(leilao);
		
		assertEquals(3, leiloeiro.getTresMaiores().size());
	}	

	
	@Test
	public void testaLeilaoComDoisLances(){
		Usuario pedro = new Usuario("pedro");
		Usuario maria = new Usuario("maria");
		
		Leilao leilao = new Leilao("Play 4");
		
		leilao.propoe(new Lance(maria, 1700.0));
		leilao.propoe(new Lance(pedro, 500.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(2, leiloeiro.getTresMaiores().size());
		
	}
}

