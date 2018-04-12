package br.com.testeautomatizado.builder;

import br.com.testeautomatizado.domain.Lance;
import br.com.testeautomatizado.domain.Leilao;
import br.com.testeautomatizado.domain.Usuario;

public class CriadorDeLeilao {

	private Leilao leilao;

	public CriadorDeLeilao para(String descricao) {
		this.leilao = new Leilao(descricao);
		return this;
	}

	public CriadorDeLeilao lance(Usuario usuario, double valor) {
		this.leilao.propoe(new Lance(usuario, valor));
		return this;
	}

	public Leilao constroi() {
		return leilao;
	}
	
	
	

}
