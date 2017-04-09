package Modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Jogada {

	ArrayList<Integer> jogada;
	

	public Jogada(){
		
		// populacao dos espacos, randomico.
		jogada = new ArrayList<Integer>(8);		
			for(int i = 0; i< 9;i++){
				jogada.add(i); Collections.shuffle(jogada);}
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
	return cont*100;
}

	
	}
	
	
	


