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
	
		int custo = +jogadaInicial.calculaHeuristica()+jogadaInicial.calculaSegundaHeuristica();
		System.out.println("\ncusto heuristico da jogada inicial: "+custo);
	
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
			while( ! ger.verificaVencedor(ger.getUmCaminho().jogadaDoTopo())) {	
				
				ger.iniciar(); cont++;
		
		}
			Date f = new Date();
			System.out.println("Horario inicial "+d);
			System.out.println("Horario final "+f);
			System.exit(0);
			
	}
	
	}
	
	
	
	


