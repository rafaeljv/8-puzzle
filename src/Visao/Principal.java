package Visao;

import Controle.Gerenciador;
import Modelo.Caminho;
import Modelo.Fronteira;
import Modelo.Jogada;


public class Principal {

	public static void main(String[] args) {
		
	// instanciar uma jogada
	Jogada jogadaInicial = new Jogada();
	jogadaInicial.mostrarJogada();
	// mostrar o custo heuristico do primeiro nodo
	System.out.println("\ncusto heuristico da jogada inicial: "+jogadaInicial.calculaHeuristica());
	// instanciar um caminho que possui a primeira jogada
	Caminho oCaminho = new Caminho(jogadaInicial);
	// instanciar uma fronteira
	Fronteira aFronteira = new Fronteira();
	// instanciar um gerenciador, que possui o caminho e a fronteira
	Gerenciador ger = new Gerenciador(oCaminho, aFronteira);
	// repassar o gerenciador ao proprio caminho, para transporte de caminhos para a fronteira
	oCaminho.setUmGerenciador(ger);
	// iniciar a busca
	ger.iniciar();
	
	
	
	}

}
