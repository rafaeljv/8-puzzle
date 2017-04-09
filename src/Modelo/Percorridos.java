package Modelo;

import java.util.ArrayList;

public class Percorridos {
	
	
	ArrayList<Caminho> caminhosPercorridos;
	
	
	
	
	public Percorridos() {
		
		
		caminhosPercorridos = new ArrayList<Caminho>(1);	
		
		
		
	}




	public ArrayList<Caminho> getCaminhosPercorridos() {
		return caminhosPercorridos;
	}




	public void setCaminhosPercorridos(ArrayList<Caminho> caminhosPercorridos) {
		this.caminhosPercorridos = caminhosPercorridos;
	}
	

	
	
	
	
	

}
