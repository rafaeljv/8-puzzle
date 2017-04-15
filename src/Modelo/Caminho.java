package Modelo;

import java.util.ArrayList;
import Controle.Gerenciador;

public class Caminho {
	
	ArrayList<Jogada> listaJogadas; //caminho atual sob analise
	int custoHeuristica; // custo heuristico do nodo
	Gerenciador umGerenciador; // para relacionamento com a fronteira
		
	
	public Caminho(Jogada jogadaInicial){
		
		listaJogadas = new ArrayList<Jogada>(1);
		
		listaJogadas.add(jogadaInicial);
		
		custoHeuristica = jogadaInicial.calculaHeuristica();
		}
	
	
	
	public Caminho(ArrayList<Jogada> v) {
		listaJogadas = v;
		custoHeuristica = this.calculaHeuristicaDoCaminho();
		}
	
	public Caminho() {
		listaJogadas = new ArrayList<Jogada>(1);
		custoHeuristica = 600;
		}
	
	public Gerenciador getUmGerenciador() {
		return umGerenciador;
	}


	public void setUmGerenciador(Gerenciador umGerenciador) {
		this.umGerenciador = umGerenciador;
	}

	public int getCustoHeuristica() {
		return custoHeuristica;
	}

	public void setCustoHeuristica(int custoHeuristica) {
		this.custoHeuristica = custoHeuristica;
	}

	public ArrayList<Jogada> getListaJogadas() {
		return listaJogadas;
	}

	public void setListaJogadas(ArrayList<Jogada> caminhoAtual) {
		this.listaJogadas = caminhoAtual;
	}

	public void setJogada(Jogada j) {
		this.listaJogadas.add(j);
	}
	
	public ArrayList<Jogada> expandirJogada() {
		
		int tam = this.getListaJogadas().size();
		Jogada j = this.jogadaDoTopo(); 
		int tamJ = j.getJogada().size();
		ArrayList<Jogada> al = new ArrayList<Jogada>();
		
	for(int i = 0; i<tamJ;i++){
		
		int peca = j.getJogada().get(i);
		
			if(peca==0)	{
			
			switch(i) {
			
			case 0:
				
				{Jogada a0 = new Jogada(this.getListaJogadas().get(tam-1));
				int peca0 = this.getListaJogadas().get(tam-1).getJogada().get(1);
				a0.getJogada().set(1, 0);
				a0.getJogada().set(0, peca0);
				
				Jogada b0 = new Jogada(this.getListaJogadas().get(tam-1));
				peca0 = this.getListaJogadas().get(tam-1).getJogada().get(3);
				b0.getJogada().set(3, 0);
				b0.getJogada().set(0, peca0);

				
				al.add(a0);
				al.add(b0);
				
				} break;
				
			case 1:
				
				{Jogada a1 = new Jogada(this.getListaJogadas().get(tam-1));
				int peca1 = this.getListaJogadas().get(tam-1).getJogada().get(2);
				a1.getJogada().set(2, 0);
				a1.getJogada().set(1, peca1);
				
				Jogada b1 = new Jogada(this.getListaJogadas().get(tam-1));
				peca1 = this.getListaJogadas().get(tam-1).getJogada().get(0);
				b1.getJogada().set(0, 0);
				b1.getJogada().set(1, peca1);
				
				Jogada c1 = new Jogada(this.getListaJogadas().get(tam-1));
				peca1 = this.getListaJogadas().get(tam-1).getJogada().get(4);
				c1.getJogada().set(4, 0);
				c1.getJogada().set(1, peca1);
				

				al.add(a1);
				al.add(b1);
				al.add(c1);
						
				} break;
				
			case 2:
				
				{Jogada a2 = new Jogada(this.getListaJogadas().get(tam-1));
				int peca2 = this.getListaJogadas().get(tam-1).getJogada().get(1);
				a2.getJogada().set(1, 0);
				a2.getJogada().set(2, peca2);
				
				Jogada b2 = new Jogada(this.getListaJogadas().get(tam-1));
				peca2 = this.getListaJogadas().get(tam-1).getJogada().get(5);
				b2.getJogada().set(5, 0);
				b2.getJogada().set(2, peca2);
				
				al.add(a2);
				al.add(b2);
				
				} break;
				
			case 3:
				
				{Jogada a3 = new Jogada(this.getListaJogadas().get(tam-1));
				int peca3 = this.getListaJogadas().get(tam-1).getJogada().get(0);
				a3.getJogada().set(0, 0);
				a3.getJogada().set(3, peca3);
				
				Jogada b3 = new Jogada(this.getListaJogadas().get(tam-1));
				peca3 = this.getListaJogadas().get(tam-1).getJogada().get(4);
				b3.getJogada().set(4, 0);
				b3.getJogada().set(3, peca3);
				
				Jogada c3 = new Jogada(this.getListaJogadas().get(tam-1));
				peca3 = this.getListaJogadas().get(tam-1).getJogada().get(6);
				c3.getJogada().set(6, 0);
				c3.getJogada().set(3, peca3);
				

				al.add(a3);
				al.add(b3);
				al.add(c3);
				
				} break;
				
				
			case 4:
				
				{Jogada a4 = new Jogada(this.getListaJogadas().get(tam-1));
				int peca4 = this.getListaJogadas().get(tam-1).getJogada().get(3);
				a4.getJogada().set(3, 0);
				a4.getJogada().set(4, peca4);
				
				Jogada b4 = new Jogada(this.getListaJogadas().get(tam-1));
				peca4 = this.getListaJogadas().get(tam-1).getJogada().get(5);
				b4.getJogada().set(5, 0);
				b4.getJogada().set(4, peca4);
				
				Jogada c4 = new Jogada(this.getListaJogadas().get(tam-1));
				peca4 = this.getListaJogadas().get(tam-1).getJogada().get(1);
				c4.getJogada().set(1, 0);
				c4.getJogada().set(4, peca4);
				
				Jogada d4 = new Jogada(this.getListaJogadas().get(tam-1));
				peca4 = this.getListaJogadas().get(tam-1).getJogada().get(7);
				d4.getJogada().set(7, 0);
				d4.getJogada().set(4, peca4);
				
				

				al.add(a4);
				al.add(b4);
				al.add(c4);
				al.add(d4);
				} break;
				
			case 5:
				
				{Jogada a5 = new Jogada(this.getListaJogadas().get(tam-1));
				int peca5 = this.getListaJogadas().get(tam-1).getJogada().get(4);
				a5.getJogada().set(4, 0);
				a5.getJogada().set(5, peca5);
				
				Jogada b5 = new Jogada(this.getListaJogadas().get(tam-1));
				peca5 = this.getListaJogadas().get(tam-1).getJogada().get(2);
				b5.getJogada().set(2, 0);
				b5.getJogada().set(5, peca5);
				
				Jogada c5 = new Jogada(this.getListaJogadas().get(tam-1));
				peca5 = this.getListaJogadas().get(tam-1).getJogada().get(8);
				c5.getJogada().set(8, 0);
				c5.getJogada().set(5, peca5);
				

				al.add(a5);
				al.add(b5);
				al.add(c5);
				
				} break;
				
			case 6:
				
				{Jogada a6 = new Jogada(this.getListaJogadas().get(tam-1));
				int peca6 = this.getListaJogadas().get(tam-1).getJogada().get(7);
				a6.getJogada().set(7, 0);
				a6.getJogada().set(6, peca6);
				
				Jogada b6 = new Jogada(this.getListaJogadas().get(tam-1));
				peca6 = this.getListaJogadas().get(tam-1).getJogada().get(3);
				b6.getJogada().set(3, 0);
				b6.getJogada().set(6, peca6);
				
				al.add(a6);
				al.add(b6);
					
				} break;
				
			case 7:
				
				{Jogada a7 = new Jogada(this.getListaJogadas().get(tam-1));
				int peca7 = this.getListaJogadas().get(tam-1).getJogada().get(6);
				a7.getJogada().set(6, 0);
				a7.getJogada().set(7, peca7);
				
				Jogada b7 = new Jogada(this.getListaJogadas().get(tam-1));
				peca7 = this.getListaJogadas().get(tam-1).getJogada().get(8);
				b7.getJogada().set(8, 0);
				b7.getJogada().set(7, peca7);
				
				Jogada c7 = new Jogada(this.getListaJogadas().get(tam-1));
				peca7 = this.getListaJogadas().get(tam-1).getJogada().get(4);
				c7.getJogada().set(4, 0);
				c7.getJogada().set(7, peca7);
				
				al.add(a7);
				al.add(b7);
				al.add(c7);
				
				} break;
				
			case 8:
			
				{Jogada a8 = new Jogada(this.getListaJogadas().get(tam-1));
				int peca8 = this.getListaJogadas().get(tam-1).getJogada().get(5);
				a8.getJogada().set(5, 0);
				a8.getJogada().set(8, peca8);
				
				Jogada b8 = new Jogada(this.getListaJogadas().get(tam-1));
				peca8 = this.getListaJogadas().get(tam-1).getJogada().get(7);
				b8.getJogada().set(7, 0);
				b8.getJogada().set(8, peca8);
				

				al.add(a8);
				al.add(b8);
				
				} break;
			}
		}
	}	
	return al;
		
	}


public Jogada jogadaDoTopo(){
	int tam = this.getListaJogadas().size();
	return this.getListaJogadas().get(tam-1);
}

	
public int calculaHeuristicaDoCaminho(){
		// calcula a heuristica de um array de jogadas (um caminho)
	int tamC = this.getListaJogadas().size();
	int cont = 0;
		for(int i = 0; i< tamC; i++){
			
			cont = cont+this.getListaJogadas().get(i).calculaHeuristica();
			
			//+this.jogadaDoTopo().calculaSegundaHeuristica();
					
						
						//+ this.getListaJogadas().get(i).calculaTerceiraHeuristica();
			//+  
			
		}
		return cont 
				 + this.getListaJogadas().size();
		
}

	public void mostrarCaminho() {
// mostrar as jogadas de um caminho
		int tam = this.getListaJogadas().size();
				for(int i=0;i<tam;i++){
					this.getListaJogadas().get(i).mostrarJogada(); 
					int custo = this.getListaJogadas().get(i).calculaHeuristica();
					System.out.println("Custo da jogada "+custo); System.out.println("\n");
		}
		
	}

}
