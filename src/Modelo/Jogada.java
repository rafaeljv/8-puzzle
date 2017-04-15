package Modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Jogada {

	ArrayList<Integer> jogada;
	

	public Jogada(){
		
		// populacao dos espacos, randomico.
		jogada = new ArrayList<Integer>(8);		
			
	//		for(int i = 0; i< 9;i++){
	//			jogada.add(i); 
	//			Collections.shuffle(jogada);
				
				
	//		}
		
		///*
		jogada.add(0, 4);
		jogada.add(1, 6);
		jogada.add(2, 2);
		jogada.add(3, 8);
		jogada.add(4, 3);
		jogada.add(5, 5);
		jogada.add(6, 7);
		jogada.add(7, 0);
		jogada.add(8, 1);
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


public int calculaTerceiraHeuristica(){
	
	
	int tam = this.getJogada().size();

	// calcula o numero de sequencias de pecas
	
	int cont = 0;
	
	for(int j = 0; j<tam; j++)
		{
		switch(j){
		case 0 : if(this.getJogada().get(1)==2 && this.getJogada().get(2) ==3 ){cont++;} break;
		case 1 : if(this.getJogada().get(0)==1 && this.getJogada().get(2) ==3 ){cont++;} break;
		case 2 : if(this.getJogada().get(0)==1 && this.getJogada().get(1) ==2 ){cont++;} break;
		case 3 : if(this.getJogada().get(4)==5 && this.getJogada().get(5) ==6 ){cont++;} break;
		case 4 : if(this.getJogada().get(3)==4 && this.getJogada().get(5) ==6 ){cont++;} break;
		case 5 : if(this.getJogada().get(3)==4 && this.getJogada().get(4) ==5 ){cont++;} break;
		//case 6 : if(this.getJogada().get(7)==8 && this.getJogada().get(8) ==0 ){cont++;} break;
		//case 7 : if(this.getJogada().get(6)==7 && this.getJogada().get(8) ==0 ){cont++;} break;
		//case 8 : if(this.getJogada().get(6)==7 && this.getJogada().get(7) ==8 ){cont++;} break;
			
			}

	
	
	
}
	return cont;
	

}



public int calculaInversoes(){
	
	
	int t = this.getJogada().size();
	int cont=0;
	
	for(int i = 0; i < t - 1; i++){
		
		
		int j = this.getJogada().get(i);
		
			for(int u = i+1; u<t; u++ ){
				int n  = this.getJogada().get(u);
			
				if(n < j && j != 0 && n!=0) {cont++;}
		}
		
	}
		
	return cont;
	
}

}
	
	
	


