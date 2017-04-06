package Modelo;

import java.util.ArrayList;

public class Caminho {
	
	ArrayList<Jogada> caminhoAtual; //caminho atual sob analise
	int custoHeuristica; // custo heuristico do nodo
	Fronteira umaFronteira;
	
	
	
	public Caminho(Jogada jogadaInicial, Fronteira umaFronteira){
		
		caminhoAtual = new ArrayList<Jogada>(100);
		
		caminhoAtual.add(jogadaInicial);
		
		custoHeuristica = jogadaInicial.calculaHeuristica();
		
		umaFronteira = new Fronteira();
		
		
	}
	
	
	public int getCustoHeuristica() {
		return custoHeuristica;
	}


	public void setCustoHeuristica(int custoHeuristica) {
		this.custoHeuristica = custoHeuristica;
	}


	public ArrayList<Jogada> getCaminhoAtual() {
		return caminhoAtual;
	}


	public void setCaminhoAtual(ArrayList<Jogada> caminhoAtual) {
		this.caminhoAtual = caminhoAtual;
	}


	public void expandirJogada(){
		
		int tam = this.getCaminhoAtual().size();
		
	for(int i = 0; i<tam;i++){
		
		if(this.getCaminhoAtual().get(i).equals(0))
			
		{
			
			switch(i) {
			
			case 0:
				
			case 1:
				
			case 2:
				
			case 3:
				
			case 4:
				
			case 5:
				
			case 6:
				
			case 7:
				
			case 8:
			
				Jogada a = new Jogada(this.getCaminhoAtual().get(tam-1));
				int peca = this.getCaminhoAtual().get(tam-1).getJogada().get(5);
				a.getJogada().set(5, 0);
				a.getJogada().set(8, peca);
				
				Jogada b = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca = this.getCaminhoAtual().get(tam-1).getJogada().get(7);
				a.getJogada().set(7, 0);
				a.getJogada().set(8, peca);
				
				this.entraNaFronteira(a);
				this.entraNaFronteira(b);
			
			}
			
			
			
			
			
			
		}
		
	}	
		
		
	}


	public Fronteira getUmaFronteira() {
		return umaFronteira;
	}


	public void setUmaFronteira(Fronteira umaFronteira) {
		this.umaFronteira = umaFronteira;
	}


	private void entraNaFronteira(Jogada a) {
		this.getCaminhoAtual().add(a);
		this.getUmaFronteira().getCaminhos().add(this);
		
	}
	
	
	
	

}
