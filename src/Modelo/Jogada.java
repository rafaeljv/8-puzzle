package Modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Jogada {

	ArrayList<Integer> jogada;
	

	public Jogada(){
		
		// populacao dos espacos, randomico.
		jogada = new ArrayList<Integer>(8);		
			for(int i = 0; i< 9;i++){
				jogada.add(i); 
				
				
				Collections.shuffle(jogada);
				
				
			}
		/*
		jogada.add(0, 5);
		jogada.add(1, 8);
		jogada.add(2, 2);
		jogada.add(3, 3);
		jogada.add(4, 4);
		jogada.add(5, 0);
		jogada.add(6, 6);
		jogada.add(7, 7);
		jogada.add(8, 1);
		
		*/
		}
	
	
	
public Jogada(Jogada umaJogada) {
	
	jogada = new ArrayList<Integer>(8);	
	for(int i = 0; i< 9;i++){
		jogada.add(umaJogada.getJogada().get(i));}
	}


public void mostrarJogada() {
		
		// mostrar estado atual		
				for(int i = 0; i<jogada.size();i++)
						if(i%3==2){System.out.print( jogada.get(i).intValue()+"\n");}
							else{System.out.print( jogada.get(i).intValue()+" ");}
	}





public ArrayList<Integer> getJogada() {
	return jogada;
}


public void setJogada(ArrayList<Integer> jogada) {
	this.jogada = jogada;
}



public int calculaHeuristica() {
	// calcula o somatorio das distancias ate o estado ideal
	int tam = this.getJogada().size();
	int cont = 0;
	
	for(int i =0; i< tam; i++){
		
		cont = cont+ Math.abs(this.getJogada().get(i) - i);
		
	}
	
	
	
	return cont;
	
}



public int calculaSegundaHeuristica() {
	
	int tam = this.getJogada().size();

	// calcula o numero de pecas fora do lugar
	
	int cont = 0;
	
	for(int j = 0; j<tam; j++){
		
		if(this.getJogada().get(j) != j){cont = cont+1;}
		
	}
	return cont;
}

	
	}
	
	
	


