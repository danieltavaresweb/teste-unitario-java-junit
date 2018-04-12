package br.com.testeautomatizado.operacoes;

public class AnoBissexto {
	public boolean ehBissexto(int ano) {
		if((ano % 400 == 0 || !(ano % 100 == 0)) && ano % 4 == 0){
			return true;
		}
		return false;
	}
}
