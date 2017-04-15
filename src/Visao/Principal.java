package Visao;

import java.util.Date;

import Controle.Gerenciador;
import Modelo.Caminho;
import Modelo.Fronteira;
import Modelo.Jogada;


public class Principal {

	public static void main(String[] args) throws InterruptedException  {
		
	// instanciar uma jogada
		Date d = new Date();
		Jogada jogadaInicial = new Jogada();
		jogadaInicial.mostrarJogada();
	
	// mostrar o custo heuristico do primeiro nodo
	
		int custo = +jogadaInicial.calculaHeuristica();
		System.out.println("\ncusto heuristico da jogada inicial: "+custo);
		
		int inversoes = jogadaInicial.calculaInversoes();
		System.out.println("\nnumero de inversoes: "+inversoes);
		if(inversoes%2==0){System.out.println("Numero de inversoes eh par. A jogada tem solucao.");} else{
			System.out.println("Numero de inversoes eh impar. A jogada sem soluçao.");}
		
	// instanciar um caminho que possui a primeira jogada
	
		Caminho oCaminho = new Caminho(jogadaInicial);
	
	// instanciar uma fronteira
	
		Fronteira aFronteira = new Fronteira();
	
	// instanciar um gerenciador, que possui o caminho e a fronteira
	
		Gerenciador ger = new Gerenciador(oCaminho, aFronteira);
	
	// repassar o gerenciador ao proprio caminho, para transporte de caminhos para a fronteira
	
		oCaminho.setUmGerenciador(ger);
	
	// iniciar a busca
		
		int cont = 0;
			while( cont<100000000 && ! ger.verificaVencedor(ger.getUmCaminho().jogadaDoTopo())) {	
				
				ger.iniciar(); 
				cont++;
		
		}
			
			System.out.println("Solucao encontrada!\n"); ger.getUmCaminho().jogadaDoTopo().mostrarJogada();
			System.out.println("\nVeja o caminho percorrido: \n"); ger.getUmCaminho().mostrarCaminho();
			System.out.println("Tamanho da fronteira "+ger.getUmaFronteira().getCaminhos().size());
			int tam = +ger.getUmCaminho().getListaJogadas().size()-1;
			System.out.println("Jogadas realizadas "+tam);
			System.out.println("Tamanho da lista de caminhos percorridos "+ ger.getUmPercorrido().getCaminhosPercorridos().size());
			
			
			
			Date f = new Date();
			System.out.println("Horario inicial "+d);
			System.out.println("Horario final "+f);
			System.exit(0);
			
	}
	
	}
	
	
	
	


