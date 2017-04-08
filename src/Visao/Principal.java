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
	ArrayList<Jogada> alj = new ArrayList<Jogada>();
			
	alj = oCaminho.expandirJogada();
	
	int tamL = alj.size();
	int tamC = oCaminho.getListaJogadas().size();
	
	
	for(int z=0; z< tamL;z++)
		
	{
	Caminho n = new Caminho();
	
	for(int k =0; k< tamC; k++)
	{n.getListaJogadas().add(oCaminho.getListaJogadas().get(k));}
	
	n.getListaJogadas().add(alj.get(z));
	
	aFronteira.getCaminhos().add(n);
	
	
	}
	System.out.println("tamanho da fronteira "+aFronteira.getCaminhos().size());
	System.out.println("tamanho do primeiro caminho da Fronteira "+aFronteira.getCaminhos().get(0).getListaJogadas().size());
	
	
	
	
	
	
		//ger.iniciar();
	
	}
	
	
	
	

	}
