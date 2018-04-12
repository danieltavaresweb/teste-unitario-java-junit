package br.com.testeautomatizado.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		int total = 0;
		
		for(Lance l : lances){
			if(l.getUsuario().equals(lance.getUsuario())){
				total++;
			}
		}
		
		if(lances.isEmpty() || (!lances.get(lances.size()-1).getUsuario().equals(lance.getUsuario()) && total < 5  )){
			lances.add(lance);
		}
		
	}
	
	public void dobraLance(Usuario usuario){		
		Lance ultimoLance = ultimoLanceDo(usuario);
		if(ultimoLance!= null){
			propoe(new Lance(usuario, ultimoLance.getValor()*2));
		}
	}

	private Lance ultimoLanceDo(Usuario usuario) {
		for(int i = lances.size() -1;i >= 0; i--){
			if(lances.get(i).getUsuario().equals(usuario)){
				return lances.get(i);
			}
		}
		return null;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}
	
	public double valorMedio(){
		double media = 0;
		for(Lance lance : this.lances){
			media += lance.getValor();
		}
		
		return media/this.lances.size();
		
	}
}
