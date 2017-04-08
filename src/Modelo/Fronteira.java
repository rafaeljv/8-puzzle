package Modelo;

import java.util.ArrayList;

public class Fronteira {
	
	
	ArrayList<Caminho> caminhos;
	
	public Fronteira(){
		
	caminhos = new ArrayList<Caminho>(1);	
		
	}

	public ArrayList<Caminho> getCaminhos() {
		return caminhos;
	}

	public void setCaminhos(ArrayList<Caminho> caminhos) {
		this.caminhos = caminhos;
	}
	
	public void mostrarFronteira(){
		
		
		int tamF = this.getCaminhos().size();
		
		for (int i=0;i<tamF;i++){
			int tamC = this.getCaminhos().get(i).getListaJogadas().size();
			
			for(int k=0;k<tamC;k++)
			{
				System.out.println("\n jogada "+ k+ " do caminho"+ i+" \n");
				this.getCaminhos().get(i).getListaJogadas().get(k).mostrarJogada();}
			
		}
	}
	

}
