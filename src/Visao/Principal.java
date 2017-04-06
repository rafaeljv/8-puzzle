package Visao;

import Modelo.Jogada;


public class Principal {

	public static void main(String[] args) {
		



Jogada jogadaInicial = new Jogada();

	jogadaInicial.mostrarJogada();
	
	
	System.out.println("\ncusto heuristico da jogada inicial: "+jogadaInicial.calculaHeuristica());
	
	
	
	
	}

}
