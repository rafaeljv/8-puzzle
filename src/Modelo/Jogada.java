package Modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Jogada {

	ArrayList<Integer> jogada;
	

	public Jogada(){
		
		// populacao dos espacos, randomico.
		jogada = new ArrayList<Integer>(8);		
			
			//for(int i = 0; i< 9;i++){
				//jogada.add(i); 
				//Collections.shuffle(jogada);
				
				
			//}
		
		///*
		jogada.add(0, 3);
		jogada.add(1, 1);
		jogada.add(2, 8);
		jogada.add(3, 5);
		jogada.add(4, 6);
		jogada.add(5, 2);
		jogada.add(6, 7);
		jogada.add(7, 4);
		jogada.add(8, 0);
		 //*/
		
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
	return jogada;}


public void setJogada(ArrayList<Integer> jogada) {
	this.jogada = jogada;}



public int calculaHeuristica() {
	// calcula o somatorio das distancias ate o estado ideal - Manhattan
	
	int tam = this.getJogada().size();
	int cont = 0;
	
	for(int i =0; i< tam; i++)
	{
		
				if(this.getJogada().get(i) != 0)
					{
					cont = cont + Math.abs(this.getJogada().get(i) - i - 1);} 
						else {
							cont = cont + Math.abs(this.getJogada().get(i) - i + 8);}
			}
	
	return cont;
	
}



public int calculaSegundaHeuristica() {
	
	int tam = this.getJogada().size();

	// calcula o numero de pecas fora do lugar
	
	int cont = 0;
	
	for(int j = 0; j<tam; j++)
		{
		
		if(this.getJogada().get(j) != 0){
			
			if(this.getJogada().get(j) != j + 1){cont = cont+1;}
										} 
		
		else
			{			
			if(this.getJogada().get(j) != j - 8){cont = cont+1;}
			}
		
		}
	
	return cont;}

	

}
	
	
	


