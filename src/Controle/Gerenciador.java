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
		System.out.println("tamanho da fronteira "+tamFronteira);
		
		int min = 1000;
		Caminho caminhoMin = this.getUmCaminho();
		
		for (int i = 0; i < tamFronteira; i++){
			
			if(this.getUmaFronteira().getCaminhos().get(i).getCustoHeuristica() < min) {
				
				min = this.getUmaFronteira().getCaminhos().get(i).getCustoHeuristica();
				caminhoMin = this.getUmaFronteira().getCaminhos().get(i);
			}
				}
		
		int tamCaminho = caminhoMin.getCaminhoAtual().size();
		//System.out.println(tamCaminho);
		
		return caminhoMin.getCaminhoAtual().get(tamCaminho-1);
		
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



		public void iniciar() {
			
			int tamCaminhos = this.getUmCaminho().getCaminhoAtual().size(); //tamanho do caminho
			System.out.println("tamanho do caminho na jogada 1 "+tamCaminhos);
			Jogada j = this.getUmCaminho().getCaminhoAtual().get(tamCaminhos-1); //pega o ultimo caminho adicionado
			
			if(this.verificaVencedor(j)) {
				
				System.out.println("Solucao encontrada!"); j.mostrarJogada();
				
			}
			
			
		else {
			System.out.println("tamanho do caminho atual "+this.getUmCaminho().getCaminhoAtual().size());
			
		this.getUmCaminho().expandirJogada();
		
		System.out.println("tamanho do caminho atual "+this.getUmCaminho().getCaminhoAtual().size());
		
		Jogada novaJogada = this.avaliarFronteira();
		novaJogada.mostrarJogada();
		this.getUmCaminho().getCaminhoAtual().add(novaJogada);
		iniciar();
		}
		
	}
	
	

}
