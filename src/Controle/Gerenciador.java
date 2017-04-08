package Controle;

import Modelo.Caminho;
import Modelo.Fronteira;
import Modelo.Jogada;



public class Gerenciador {
	

Caminho umCaminho;
Fronteira umaFronteira;
	
	public Gerenciador(Caminho vUmCaminho, Fronteira vUmaFronteira){
		
		
		umCaminho = vUmCaminho;
		umaFronteira = vUmaFronteira;
		
	}
	
	
	
	public boolean verificaVencedor(Jogada j) {
		
		if(j.calculaHeuristica()==0) {return true;} else {return false;}
		
		}
	
	public Jogada avaliarFronteira(){
		
		int tamFronteira = this.getUmaFronteira().getCaminhos().size();
		System.out.println("numero de caminhos da fronteira! "+tamFronteira);
		
		for(int i = 0 ; i < tamFronteira ; i++){
			int tamCaminho = this.getUmaFronteira().getCaminhos().size();
			System.out.println("numero de caminhos = "+tamCaminho+", este de numero "+i);
				for(int j = 0; j< tamCaminho; j++){
					int tamJogadas = this.getUmaFronteira().getCaminhos().get(i).getListaJogadas().size();
			System.out.println("\n tamanho das jogadas "+tamJogadas+" do caminho "+i);
			for(int z = 0; z< tamJogadas ; z++){
				 System.out.println("\n jogada "+z+" da pilha no caminho de fronteira "+i);
				this.getUmaFronteira().getCaminhos().get(i).getListaJogadas().get(z).mostrarJogada(); System.out.println("\n");
			}
			
			
			}
			
		}
		
		
		int min = 1000;
		Caminho caminhoMin = this.getUmCaminho();
		
		for (int i = 0; i < tamFronteira; i++){
			Caminho caminhoAnalisado =this.getUmaFronteira().getCaminhos().get(i);
			caminhoAnalisado.jogadaDoTopo().mostrarJogada();
			System.out.println(" heuristica total "+caminhoAnalisado.calculaHeuristicaDoCaminho(caminhoAnalisado));
			if(caminhoAnalisado.calculaHeuristicaDoCaminho(caminhoAnalisado) < min) {
				
				min = this.getUmaFronteira().getCaminhos().get(i).calculaHeuristicaDoCaminho(caminhoAnalisado);
				caminhoMin = this.getUmaFronteira().getCaminhos().get(i);
			}
				}
		
		int tamCaminho = caminhoMin.getListaJogadas().size();
		System.out.println(" tamanho do menor caminho "+tamCaminho);
		System.out.println(" heuristica total "+caminhoMin.calculaHeuristicaDoCaminho(caminhoMin));
		return caminhoMin.getListaJogadas().get(tamCaminho-1);
		
	}



		public Fronteira getUmaFronteira() {
		return umaFronteira;
	}



	public void setUmaFronteira(Fronteira umaFronteira) {
		this.umaFronteira = umaFronteira;
	}



		public Caminho getUmCaminho() {
		return umCaminho;
	}



	public void setUmCaminho(Caminho umCaminho) {
		this.umCaminho = umCaminho;
	}
	
	
	



		public void iniciar() throws CloneNotSupportedException {
			
			//int tamCaminhos = this.getUmCaminho().getListaJogadas().size(); //tamanho do caminho
			//System.out.println("tamanho do caminho na jogada 1 "+tamCaminhos);
			Jogada j = this.getUmCaminho().jogadaDoTopo(); //pega o ultimo caminho adicionado
			
			if(this.verificaVencedor(j)) {
				
				System.out.println("Solucao encontrada!"); j.mostrarJogada();
				
			}
			
			
		else {
			System.out.println("tamanho do caminho atual "+this.getUmCaminho().getListaJogadas().size());
			
			
		this.getUmCaminho().expandirJogada();
		
		System.out.println("tamanho da fronteira "+this.getUmaFronteira().getCaminhos().size());
		
		
		System.out.println("tamanho do caminho final "+this.getUmCaminho().getListaJogadas().size());
		
		this.getUmaFronteira().mostrarFronteira();
		
		//System.out.println("tamanho do caminho atual "+this.getUmCaminho().getCaminhoAtual().size());
		
		//Jogada novaJogada = this.avaliarFronteira();
		//novaJogada.mostrarJogada();
		//this.getUmCaminho().getCaminhoAtual().add(novaJogada);
		//iniciar();
		}
		
	}
	
	

}
