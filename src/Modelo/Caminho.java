package Modelo;

import java.util.ArrayList;

public class Caminho {
	
	ArrayList<Jogada> caminhoAtual; //caminho atual sob analise
	int custoHeuristica; // custo heuristico do nodo
	Fronteira umaFronteira;
	
	
	
	public Caminho(Jogada jogadaInicial, Fronteira umaFronteira){
		
		caminhoAtual = new ArrayList<Jogada>(100);
		
		caminhoAtual.add(jogadaInicial);
		
		custoHeuristica = jogadaInicial.calculaHeuristica();
		
		umaFronteira = new Fronteira();
		
		
	}
	
	
	public Caminho() {
		caminhoAtual = new ArrayList<Jogada>(100);
		custoHeuristica = 20;
		umaFronteira = new Fronteira();
	}


	public int getCustoHeuristica() {
		return custoHeuristica;
	}


	public void setCustoHeuristica(int custoHeuristica) {
		this.custoHeuristica = custoHeuristica;
	}


	public ArrayList<Jogada> getCaminhoAtual() {
		return caminhoAtual;
	}


	public void setCaminhoAtual(ArrayList<Jogada> caminhoAtual) {
		this.caminhoAtual = caminhoAtual;
	}


	public void expandirJogada(){
		
		int tam = this.getCaminhoAtual().size();
		
	for(int i = 0; i<tam;i++){
		
		if(this.getCaminhoAtual().get(i).equals(0))
			
		{
			
			switch(i) {
			
			case 0:
				
				Jogada a0 = new Jogada(this.getCaminhoAtual().get(tam-1));
				int peca0 = this.getCaminhoAtual().get(tam-1).getJogada().get(1);
				a0.getJogada().set(1, 0);
				a0.getJogada().set(0, peca0);
				
				Jogada b0 = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca0 = this.getCaminhoAtual().get(tam-1).getJogada().get(3);
				b0.getJogada().set(3, 0);
				b0.getJogada().set(0, peca0);
				
				this.entraNaFronteira(a0);
				this.entraNaFronteira(b0);
				
			case 1:
				
				Jogada a1 = new Jogada(this.getCaminhoAtual().get(tam-1));
				int peca1 = this.getCaminhoAtual().get(tam-1).getJogada().get(2);
				a1.getJogada().set(2, 0);
				a1.getJogada().set(1, peca1);
				
				Jogada b1 = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca1 = this.getCaminhoAtual().get(tam-1).getJogada().get(0);
				b1.getJogada().set(0, 0);
				b1.getJogada().set(1, peca1);
				
				Jogada c1 = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca1 = this.getCaminhoAtual().get(tam-1).getJogada().get(4);
				c1.getJogada().set(4, 0);
				c1.getJogada().set(1, peca1);
				
				this.entraNaFronteira(a1);
				this.entraNaFronteira(b1);
				this.entraNaFronteira(c1);
				
			case 2:
				
				Jogada a2 = new Jogada(this.getCaminhoAtual().get(tam-1));
				int peca2 = this.getCaminhoAtual().get(tam-1).getJogada().get(1);
				a2.getJogada().set(1, 0);
				a2.getJogada().set(2, peca2);
				
				Jogada b2 = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca2 = this.getCaminhoAtual().get(tam-1).getJogada().get(5);
				b2.getJogada().set(5, 0);
				b2.getJogada().set(2, peca2);
				
				this.entraNaFronteira(a2);
				this.entraNaFronteira(b2);
				
			case 3:
				
				Jogada a3 = new Jogada(this.getCaminhoAtual().get(tam-1));
				int peca3 = this.getCaminhoAtual().get(tam-1).getJogada().get(0);
				a3.getJogada().set(0, 0);
				a3.getJogada().set(3, peca3);
				
				Jogada b3 = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca3 = this.getCaminhoAtual().get(tam-1).getJogada().get(4);
				b3.getJogada().set(4, 0);
				b3.getJogada().set(3, peca3);
				
				Jogada c3 = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca3 = this.getCaminhoAtual().get(tam-1).getJogada().get(7);
				c3.getJogada().set(7, 0);
				c3.getJogada().set(3, peca3);
				
				this.entraNaFronteira(a3);
				this.entraNaFronteira(b3);
				this.entraNaFronteira(c3);
				
				
			case 4:
				
				Jogada a4 = new Jogada(this.getCaminhoAtual().get(tam-1));
				int peca4 = this.getCaminhoAtual().get(tam-1).getJogada().get(3);
				a4.getJogada().set(3, 0);
				a4.getJogada().set(4, peca4);
				
				Jogada b4 = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca4 = this.getCaminhoAtual().get(tam-1).getJogada().get(5);
				b4.getJogada().set(5, 0);
				b4.getJogada().set(4, peca4);
				
				Jogada c4 = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca4 = this.getCaminhoAtual().get(tam-1).getJogada().get(1);
				c4.getJogada().set(1, 0);
				c4.getJogada().set(4, peca4);
				
				Jogada d4 = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca4 = this.getCaminhoAtual().get(tam-1).getJogada().get(7);
				d4.getJogada().set(7, 0);
				d4.getJogada().set(4, peca4);
				
				this.entraNaFronteira(a4);
				this.entraNaFronteira(b4);
				this.entraNaFronteira(c4);
				this.entraNaFronteira(d4);
				
			case 5:
				
				Jogada a5 = new Jogada(this.getCaminhoAtual().get(tam-1));
				int peca5 = this.getCaminhoAtual().get(tam-1).getJogada().get(4);
				a5.getJogada().set(4, 0);
				a5.getJogada().set(5, peca5);
				
				Jogada b5 = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca5 = this.getCaminhoAtual().get(tam-1).getJogada().get(2);
				b5.getJogada().set(2, 0);
				b5.getJogada().set(5, peca5);
				
				Jogada c5 = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca5 = this.getCaminhoAtual().get(tam-1).getJogada().get(8);
				c5.getJogada().set(8, 0);
				c5.getJogada().set(5, peca5);
				
				this.entraNaFronteira(a5);
				this.entraNaFronteira(b5);
				this.entraNaFronteira(c5);
				
			case 6:
				
				Jogada a6 = new Jogada(this.getCaminhoAtual().get(tam-1));
				int peca6 = this.getCaminhoAtual().get(tam-1).getJogada().get(7);
				a6.getJogada().set(7, 0);
				a6.getJogada().set(6, peca6);
				
				Jogada b6 = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca6 = this.getCaminhoAtual().get(tam-1).getJogada().get(3);
				b6.getJogada().set(3, 0);
				b6.getJogada().set(6, peca6);
				
				this.entraNaFronteira(a6);
				this.entraNaFronteira(b6);
				
			case 7:
				
				Jogada a7 = new Jogada(this.getCaminhoAtual().get(tam-1));
				int peca7 = this.getCaminhoAtual().get(tam-1).getJogada().get(6);
				a7.getJogada().set(6, 0);
				a7.getJogada().set(7, peca7);
				
				Jogada b7 = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca7 = this.getCaminhoAtual().get(tam-1).getJogada().get(8);
				b7.getJogada().set(8, 0);
				b7.getJogada().set(7, peca7);
				
				Jogada c7 = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca7 = this.getCaminhoAtual().get(tam-1).getJogada().get(4);
				c7.getJogada().set(4, 0);
				c7.getJogada().set(7, peca7);
				
				this.entraNaFronteira(a7);
				this.entraNaFronteira(b7);
				this.entraNaFronteira(c7);
				
			case 8:
			
				Jogada a8 = new Jogada(this.getCaminhoAtual().get(tam-1));
				int peca8 = this.getCaminhoAtual().get(tam-1).getJogada().get(5);
				a8.getJogada().set(5, 0);
				a8.getJogada().set(8, peca8);
				
				Jogada b8 = new Jogada(this.getCaminhoAtual().get(tam-1));
				peca8 = this.getCaminhoAtual().get(tam-1).getJogada().get(7);
				b8.getJogada().set(7, 0);
				b8.getJogada().set(8, peca8);
				
				this.entraNaFronteira(a8);
				this.entraNaFronteira(b8);
			
			}
			
			
			
			
			
			
		}
		
	}	
		
		
	}


	public Fronteira getUmaFronteira() {
		return umaFronteira;
	}


	public void setUmaFronteira(Fronteira umaFronteira) {
		this.umaFronteira = umaFronteira;
	}


	private void entraNaFronteira(Jogada a) {
		Caminho c = new Caminho();
		c.setCaminhoAtual(caminhoAtual);
		c.getCaminhoAtual().add(a);
		this.getUmaFronteira().getCaminhos().add(c);
		
	}
	
	
	
	

}
