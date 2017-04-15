package Modelo;

import java.util.ArrayList;

public class Fronteira {
	
	ArrayList<Caminho> caminhos;
	
	public Fronteira(){
			caminhos = new ArrayList<Caminho>(1);	
	}

	public ArrayList<Caminho> getCaminhos() {
		return caminhos;
	}

	public void setCaminhos(ArrayList<Caminho> caminhos) {
		this.caminhos = caminhos;
	}
	
	public void mostrarFronteira(){
		
		int tamF = this.getCaminhos().size();
		
			for (int i=0;i<tamF;i++){
				int tamC = this.getCaminhos().get(i).getListaJogadas().size();
					for(int k=0;k<tamC;k++) {
			//	System.out.println("\n jogada "+ k+ " do caminho"+ i+" \n");
				this.getCaminhos().get(i).getListaJogadas().get(k).mostrarJogada();}
			}
	}
	///*
	public Caminho avaliarFronteira() {
		int tam = this.getCaminhos().size();
		if(tam>0){
		Caminho n = this.getCaminhos().get(0);
		this.getCaminhos().remove(0); // remove da fronteira o caminho escolhido
		return n;} else {
			
			Caminho u = new Caminho(); System.out.println("Fronteira Vazia"); return u;
		}
			
		
		
	}
	//*/
	
	
	
	/*
	public Caminho avaliarFronteira() {
		
	int min = 1000000000;
	Jogada j = new Jogada();
	Caminho n = new Caminho();
		
		int t = this.getCaminhos().size();
		for(int i = 0; i< t; i++){
					
			int custo = this.getCaminhos().get(i).calculaHeuristicaDoCaminho();
				//	+
			 //this.getCaminhos().get(i).jogadaDoTopo().calculaHeuristica();
			//System.out.println("custo do caminho "+i+" da fronteira ="+custo); this.getCaminhos().get(i).jogadaDoTopo().mostrarJogada();
			
			if(custo<min){
			j = this.getCaminhos().get(i).jogadaDoTopo();
			n = this.getCaminhos().get(i);
				min = custo;
				//System.out.println("custo minimo "+custo);
			}
			
			}
		this.getCaminhos().remove(n);
	 // remove da fronteira o caminho escolhido
	return n;		
	}
	*/
	/*
	public boolean removerDaFronteira(Caminho n){
		
		int tamF = this.getCaminhos().size();
		for(int i=0;i<tamF;i++){
			
			
		}
		return true;
	}
//*/
	public void incluirNaFronteira(Caminho n) {
		
		int tam = this.getCaminhos().size();
		int custoEntrante = n.calculaHeuristicaDoCaminho();
		
		if(tam == 0){this.getCaminhos().add(n);}
					
			if(tam == 1){
			
				if (custoEntrante>this.getCaminhos().get(0).calculaHeuristicaDoCaminho()){
							this.getCaminhos().add(n);} else {this.getCaminhos().add(0 , n);} }
				else {
			
					int j = tam;
					int cont = 0;
		
					while(j>0 && cont==0 ) {
			
						int custoExistenteAtual = this.getCaminhos().get(j-1).calculaHeuristicaDoCaminho();
						int custoExistenteAnterior = this.getCaminhos().get(j-2).calculaHeuristicaDoCaminho();
			
						if(custoEntrante > custoExistenteAnterior && custoEntrante <= custoExistenteAtual) 
						{this.getCaminhos().add(j-1, n); cont++;} else{
							
								
							j--;
							
							if(j == 1 && cont == 0){if (custoEntrante>this.getCaminhos().get(0).calculaHeuristicaDoCaminho()){
								this.getCaminhos().add(n);cont++;} else {this.getCaminhos().add(0 , n);cont++;}}
						
						}
					}
				}
			}
		
		
	
	
	
	
	
	
	
}
