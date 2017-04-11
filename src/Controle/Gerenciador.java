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
				if(this.jogadasIguais(f, j)) { return false;} //se jogada ja passou por percorridos, retorna falso
				}
		return true;
}
		
public ArrayList<Jogada> varreduraDeEstadosRepetidos(ArrayList<Jogada> a){
	
	int tamPercorridos = this.getUmPercorrido().getCaminhosPercorridos().size();
	int tamFronteira = this.getUmaFronteira().getCaminhos().size();
	int tamArray = a.size();
	ArrayList<Jogada> b = new ArrayList<Jogada>();
	
	
	for(int i = 0; i< tamArray; i++)
	{							
		if(tamFronteira == 0) {
			if( ! this.jogadasIguais(a.get(i), this.getUmCaminho().getListaJogadas().get(0)) )
				
			{b.add(a.get(i)); }
			
		}
			else {
				int cont = 0;
				for(int k = 0; k<tamFronteira;k++){
					if( this.jogadasIguais(a.get(i), this.getUmCaminho().getListaJogadas().get(0)) ||
							 this.jogadasIguais(a.get(i), this.getUmaFronteira().getCaminhos().get(k).jogadaDoTopo()))
					{ cont++;}}
				
						if(tamPercorridos > 0) {
				
				for(int u = 0; u< tamPercorridos; u++){
								if( this.jogadasIguais(a.get(i), this.getUmPercorrido().getCaminhosPercorridos().get(u).jogadaDoTopo())){
						cont++;}}
												}
				if(cont == 0) {b.add(a.get(i));
				//System.out.println("novo estado");
				} 
				//else {System.out.println("barrou estado repetido");}
				
				}
	}
		
		
	return b;}
	
	
	
	


public Boolean jogadasIguais(Jogada jogada1, Jogada jogada2) {
	
	int t1 = jogada1.getJogada().size();
					
		for(int i = 0; i<t1; i++){
			if(jogada1.getJogada().get(i) != jogada2.getJogada().get(i)){return false;}
				}
		
		return true;
				
	}


		public void iniciar() throws InterruptedException {
			
			Jogada j = this.getUmCaminho().jogadaDoTopo(); //pega o ultimo caminho adicionado
			
			if(this.verificaVencedor(j)) {
				
				System.out.println("Solucao encontrada!\n"); j.mostrarJogada();
				System.out.println("\nVeja o caminho percorrido: \n"); this.getUmCaminho().mostrarCaminho();
				System.out.println("Tamanho da fronteira "+this.getUmaFronteira().getCaminhos().size());
				System.out.println("Jogadas realizadas "+this.getUmCaminho().getListaJogadas().size());
				System.out.println("Tamanho da lista de caminhos percorridos "+ this.getUmPercorrido().getCaminhosPercorridos().size());
				
				
			}
			
			
		else {
			
			ArrayList<Jogada> alj = new ArrayList<Jogada>();
			alj = varreduraDeEstadosRepetidos(this.getUmCaminho().expandirJogada());
						//System.out.println("tamanho de alj1 "+ alj.size()); 
						//Thread.sleep(1000);
			//com base nas jogadas decorrentes da expansao, passa pelo verificador para avaliar se ja passou por ela
			//alj = this.varreduraDeEstadosRepetidos(alj);
						//System.out.println("tamanho de alj2 "+ alj.size());
			int tamL = alj.size();
			int tamC = this.getUmCaminho().getListaJogadas().size();
		
			for( int z = 0; z < tamL;z++ ) {
				Caminho n = new Caminho(); // cria um caminho
					for(int k = 0; k < tamC; k++) {
						n.getListaJogadas().add(this.getUmCaminho().getListaJogadas().get(k));
						} // replica o caminho atual no novo caminho
						n.getListaJogadas().add(alj.get(z)); // adiciona a nova jogada decorrente da expansao
			
			if( verificaPercorrido(n) ) {
				this.getUmaFronteira().getCaminhos().add(n);} // adiciona os caminhos decorrentes da expansao na fronteira, se nao foi percorrido
			}
		
			Caminho c = this.getUmaFronteira().avaliarFronteira(); // extrai da fronteira o caminho de menor custo
		
		//System.out.println("\n jogada extraida da fronteira: ");c.jogadaDoTopo().mostrarJogada();
		//System.out.println("custo da jogada da fronteira "+ c.calculaHeuristicaDoCaminho());
		
		
		this.getUmPercorrido().getCaminhosPercorridos().add(this.getUmCaminho()); //acrescenta o caminho atual em Percorridos
		
		this.setUmCaminho(c); // atualiza o caminho atual
		
		
		
		}
		
	}



	
	
	

}
