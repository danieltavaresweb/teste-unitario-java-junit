package br.com.testeautomatizado.operacoes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.testeautomatizado.domain.Lance;
import br.com.testeautomatizado.domain.Usuario;

public class FiltroDeLancesTest {

    @Test
    public void deveSelecionarLancesEntre1000E3000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,2000), 
                new Lance(joao,1000), 
                new Lance(joao,3000), 
                new Lance(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(2000, resultado.get(0).getValor(), 0.00001);
    }

    @Test
    public void deveSelecionarLancesEntre500E700() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,600), 
                new Lance(joao,500), 
                new Lance(joao,700), 
                new Lance(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(600, resultado.get(0).getValor(), 0.00001);
    }
    
    @Test
    public void deveSelecionarLancesMaioresQue5000(){
    	
    	 Usuario joao = new Usuario("Joao");

         FiltroDeLances filtro = new FiltroDeLances();
         List<Lance> resultado = filtro.filtra(Arrays.asList(
                 new Lance(joao,1000), 
                 new Lance(joao,6000), 
                 new Lance(joao,700), 
                 new Lance(joao, 800)));

         assertEquals(1, resultado.size());
         assertEquals(6000, resultado.get(0).getValor(), 0.00001);
    }
    
    @Test
    
    public void deveNaoSelecionarLancesMenoresQue500(){
    	 Usuario joao = new Usuario("Joao");

         FiltroDeLances filtro = new FiltroDeLances();
         List<Lance> resultado = filtro.filtra(Arrays.asList(
                 new Lance(joao,100), 
                 new Lance(joao,300), 
                 new Lance(joao,200), 
                 new Lance(joao,80)));

         assertEquals(0, resultado.size());
         
    }
    
    
}