package Visao;

import java.util.ArrayList;

import Controle.Gerenciador;
import Modelo.Caminho;
import Modelo.Fronteira;
import Modelo.Jogada;


public class Principal {

	public static void main(String[] args) throws CloneNotSupportedException  {
		
	// instanciar uma jogada
	Jogada jogadaInicial = new Jogada();
	jogadaInicial.mostrarJogada();
	// mostrar o custo heuristico do primeiro nodo
	int custo = +jogadaInicial.calculaHeuristica()+jogadaInicial.calculaSegundaHeuristica();
	System.out.println("\ncusto heuristico da jogada inicial: "+custo);
	// instanciar um caminho que possui a primeira jogada
	Caminho oCaminho = new Caminho(jogadaInicial);
	// instanciar uma fronteira
	Fronteira aFronteira = new Fronteira();
	//aFronteira.getCaminhos().add(oCaminho);
	// instanciar um gerenciador, que possui o caminho e a fronteira
	Gerenciador ger = new Gerenciador(oCaminho, aFronteira);
	// repassar o gerenciador ao proprio caminho, para transporte de caminhos para a fronteira
	oCaminho.setUmGerenciador(ger);
	// iniciar a busca
	
	
		int cont = 0;
		while(cont < 100000 && ! ger.verificaVencedor(oCaminho.jogadaDoTopo())) {	
		ger.iniciar();
		
		cont++;
		System.out.println("Em execucao ");
		System.out.println(". ");
		System.out.println(".. ");
		System.out.println("... ");
		}
	
	
	
	
	
	
	}
	
	
		
	
	}
	
	
	
	


