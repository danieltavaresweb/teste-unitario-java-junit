package br.com.testeautomatizado.domain;

public class Lance {

	private Usuario usuario;
	private double valor;
	
	public Lance(Usuario usuario, double valor) {
		if(valor <= 0 ){
			throw new IllegalArgumentException("nao pode realizar lance menor que 0");
		}
		
		this.usuario = usuario;
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public double getValor() {
		return valor;
	}
	
	
	
}
