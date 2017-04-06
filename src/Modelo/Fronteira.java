package Modelo;

import java.util.ArrayList;

public class Fronteira {
	
	
	ArrayList<Caminho> caminhos;
	
	public Fronteira(){
		
	caminhos = new ArrayList<Caminho>(50);	
		
	}

	public ArrayList<Caminho> getCaminhos() {
		return caminhos;
	}

	public void setCaminhos(ArrayList<Caminho> caminhos) {
		this.caminhos = caminhos;
	}
	
	
	

}
