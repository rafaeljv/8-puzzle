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
					for(int k=0;k<tamC;k++) {
				System.out.println("\n jogada "+ k+ " do caminho"+ i+" \n");
				this.getCaminhos().get(i).getListaJogadas().get(k).mostrarJogada();}
			}
	}
	
	public Caminho avaliarFronteira() {
		
	int min = 1000;
	Jogada j = new Jogada();
	Caminho n = new Caminho();
		
		int t = this.getCaminhos().size();
		for(int i = 0; i< t; i++){
					
			int custo = this.getCaminhos().get(i).calculaHeuristicaDoCaminho();
			//System.out.println("custo do caminho "+i+" da fronteira ="+custo); this.getCaminhos().get(i).jogadaDoTopo().mostrarJogada();
			
			if(custo<min){
			j = this.getCaminhos().get(i).jogadaDoTopo();
			n = this.getCaminhos().get(i);
				min = custo;
				//System.out.println("custo minimo "+custo);
			}
			
			}
	this.getCaminhos().remove(n); // remove da fronteira o caminho escolhido
	return n;		
	}
}
