package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Jogada {

	ArrayList<Integer> jogada;
	int peca;
	
	
	public int getPeca() {
		return peca;
	}


	public void setPeca(int peca) {
		this.peca = peca;
	}


	public Jogada(){
		
		jogada = new ArrayList<Integer>(8);		
			for(int i = 0; i< 9;i++){
				jogada.add(i); Collections.shuffle(jogada);}
		}
	
	
	
public void mostrarJogada() {
		
		// mostrar estado atual		
				for(int i = 0; i<jogada.size();i++)
						if(i%3==2){System.out.print( jogada.get(i).intValue()+"\n");}
							else{System.out.print( jogada.get(i).intValue()+" ");}
	}
	
	
	
	
		
	}
	
	
	


