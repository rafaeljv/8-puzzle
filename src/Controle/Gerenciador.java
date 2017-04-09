package Controle;

import java.util.ArrayList;

import Modelo.Caminho;
import Modelo.Fronteira;
import Modelo.Jogada;
import Modelo.Percorridos;



public class Gerenciador {
	

Caminho umCaminho;
Fronteira umaFronteira;
Percorridos umPercorrido;
	
	public Gerenciador(Caminho vUmCaminho, Fronteira vUmaFronteira){
		
		
		umCaminho = vUmCaminho;
		umaFronteira = vUmaFronteira;
		umPercorrido = new Percorridos();
		
	}
	
	
	
	public Percorridos getUmPercorrido() {
		return umPercorrido;
	}



	public void setUmPercorrido(Percorridos umPercorrido) {
		this.umPercorrido = umPercorrido;
	}



	public boolean verificaVencedor(Jogada j) {
		
		if(j.calculaHeuristica()==0) {return true;} else {return false;}
		
		}
	/*
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

*/

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
	
	public boolean verificaPercorrido(Caminho n){
		
		
		int tamF = this.getUmaFronteira().getCaminhos().size(); // tamanho da fronteira
		Jogada j = n.jogadaDoTopo(); // jogada do topo do caminho a ser analisado
		
		for (int i = 0; i< tamF; i++) {
			
			Jogada f = this.getUmaFronteira().getCaminhos().get(i).jogadaDoTopo();
			if(f.equals(j)) { return false;} //se jogada ja passou por percorridos, retorna falso
			
		}
				
		return true;
	}
	



		public void iniciar() throws CloneNotSupportedException {
			
			Jogada j = this.getUmCaminho().jogadaDoTopo(); //pega o ultimo caminho adicionado
			
			if(this.verificaVencedor(j)) {
				
				System.out.println("Solucao encontrada!"); j.mostrarJogada();
				
			}
			
			
		else {
			
			ArrayList<Jogada> alj = new ArrayList<Jogada>();
			alj = this.getUmCaminho().expandirJogada();
			
			int tamL = alj.size();
			int tamC = this.getUmCaminho().getListaJogadas().size();
		
			for( int z = 0; z < tamL;z++ ) {
				Caminho n = new Caminho();
		
				for(int k = 0; k < tamC; k++)
				{n.getListaJogadas().add(this.getUmCaminho().getListaJogadas().get(k));}
			n.getListaJogadas().add(alj.get(z));
			
			if(verificaPercorrido(n))
			{this.getUmaFronteira().getCaminhos().add(n);} // adiciona os caminhos decorrentes da expansao na fronteira
			
			}
			
		//Jogada h = this.getUmaFronteira().avaliarFronteira();
		
		Caminho c = this.getUmaFronteira().avaliarFronteira(); // extrai da fronteira o caminho de menor custo
		
		
		System.out.println("\n jogada extraida da fronteira: ");c.jogadaDoTopo().mostrarJogada();
		
		
		// checagem se jogada eh repetida:
		
		
		while ( ! this.verificaPercorrido(c) || c.jogadaDoTopo().equals(this.getUmCaminho().getListaJogadas().get(0))) { // se falso, ha estado repetido 
			
			c = this.getUmaFronteira().avaliarFronteira();
			
		}
		
		//this.getUmCaminho().getListaJogadas().add(h);
		
		this.getUmPercorrido().getCaminhosPercorridos().add(this.getUmCaminho()); //acrescenta o caminho atual em Percorridos
		
		this.setUmCaminho(c); // atualiza o caminho atual
		int custo = +this.getUmCaminho().jogadaDoTopo().calculaHeuristica()+this.getUmCaminho().jogadaDoTopo().calculaSegundaHeuristica();
		System.out.println("\ncusto heuristico da jogada: "+custo);
		this.getUmCaminho().jogadaDoTopo().mostrarJogada();
		System.out.println("tamanho do caminho "+this.getUmCaminho().getListaJogadas().size());
		
		
		}
		
	}
	
	

}
