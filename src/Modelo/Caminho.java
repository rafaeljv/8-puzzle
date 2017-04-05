package Modelo;

import java.util.ArrayList;

public class Caminho {
	
	ArrayList<Jogada> caminhoAtual; //caminho atual sob analise
	int custoHeuristica; // custo heuristico do nodo
	
	
	public Caminho(Jogada jogadaInicial){
		
		caminhoAtual = new ArrayList<Jogada>(50);
		
		caminhoAtual.add(jogadaInicial);
		
		custoHeuristica = jogadaInicial.calculaHeuristica();
	}
	
	
	public ArrayList<Jogada> getCaminhoAtual() {
		return caminhoAtual;
	}


	public void setCaminhoAtual(ArrayList<Jogada> caminhoAtual) {
		this.caminhoAtual = caminhoAtual;
	}


	public void expandirJogada(){
		
	for(int i = 0; i<this.getCaminhoAtual().size();i++){
		
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
			
			
			}
			
			
			
			
			
			
		}
		
	}	
		
		
	}
	
	
	
	

}
