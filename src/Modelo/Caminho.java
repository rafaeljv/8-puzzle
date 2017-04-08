package Modelo;

import java.util.ArrayList;
import Controle.Gerenciador;

public class Caminho implements Cloneable {
	
	ArrayList<Jogada> listaJogadas; //caminho atual sob analise
	int custoHeuristica; // custo heuristico do nodo
	Gerenciador umGerenciador;
	
	
	
	
	public Caminho(Jogada jogadaInicial){
		
		listaJogadas = new ArrayList<Jogada>(1);
		
		listaJogadas.add(jogadaInicial);
		
		custoHeuristica = jogadaInicial.calculaHeuristica();
			
		
	}
	
	public Caminho(ArrayList<Jogada> v) {
		listaJogadas = v;
		custoHeuristica = this.calculaHeuristicaDoCaminho(this);
		
	}
	
	public Caminho() {
		listaJogadas = new ArrayList<Jogada>(1);
		custoHeuristica = 20;
		
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

	public void setJogada(Jogada j)
	{
		
		this.listaJogadas.add(j);
		
		
	}
	public ArrayList<Jogada> expandirJogada() throws CloneNotSupportedException{
		
		int tam = this.getListaJogadas().size();
		Jogada j = this.getListaJogadas().get(tam-1); 
		int tamJ = j.getJogada().size();
		ArrayList<Jogada> al = new ArrayList<Jogada>();
		
	for(int i = 0; i<tamJ;i++){
		
		int peca = j.getJogada().get(i);
		
		if(peca==0)	
		{
			
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
				
				
				/*
				int t0 = this.getListaJogadas().size();
								
				Caminho ca0 = (Caminho) this.clone(); ca0.setJogada(a0);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(ca0);
				Caminho cb0 =  (Caminho) this.clone(); cb0.setJogada(b0);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(cb0);
				
				this.getListaJogadas().remove(t0-1+2);
				this.getListaJogadas().remove(t0-1+1);
				*/
				
				
				
				
				
				

				
				}break;
				
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
				/*
				
				int t1 = this.getListaJogadas().size();
				
				Caminho ca1 =  (Caminho) this.clone(); ca1.setJogada(a1);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(ca1);
				Caminho cb1 =  (Caminho) this.clone(); cb1.setJogada(b1);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(cb1);
				Caminho cc1 =  (Caminho) this.clone(); cc1.setJogada(c1);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(cc1);
				
				this.getListaJogadas().remove(t1-1+3);
				this.getListaJogadas().remove(t1-1+2);
				this.getListaJogadas().remove(t1-1+1);
				
				
				*/
				
				
				
				
				}break;
				
			case 2:
				
				{Jogada a2 = new Jogada(this.getListaJogadas().get(tam-1));
				int peca2 = this.getListaJogadas().get(tam-1).getJogada().get(1);
				//System.out.println("peca2 = "+peca2);
				a2.getJogada().set(1, 0);
				a2.getJogada().set(2, peca2);
				
				Jogada b2 = new Jogada(this.getListaJogadas().get(tam-1));
				peca2 = this.getListaJogadas().get(tam-1).getJogada().get(5);
				//System.out.println("peca2 = "+peca2);
				b2.getJogada().set(5, 0);
				b2.getJogada().set(2, peca2);
				

				al.add(a2);
				al.add(b2);
				
				
				/*
				int t2 = this.getListaJogadas().size();

				Caminho ca2= (Caminho) this.clone(); ca2.setJogada(a2);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(ca2);
				Caminho cb2 = (Caminho) this.clone(); cb2.setJogada(b2);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(cb2);
				
				this.getListaJogadas().remove(t2-1+2);
				this.getListaJogadas().remove(t2-1+1);

				*/
			
				
				
				
				
				}break;
				
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
				peca3 = this.getListaJogadas().get(tam-1).getJogada().get(7);
				c3.getJogada().set(7, 0);
				c3.getJogada().set(3, peca3);
				

				al.add(a3);
				al.add(b3);
				al.add(c3);
				
				/*
				int t3 = this.getListaJogadas().size();
				
				Caminho ca3 = (Caminho) this.clone(); ca3.setJogada(a3);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(ca3);
				Caminho cb3 = (Caminho) this.clone(); cb3.setJogada(b3);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(cb3);
				Caminho cc3 =(Caminho) this.clone(); cc3.setJogada(c3);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(cc3);
				
				
				this.getListaJogadas().remove(t3-1+3);
				this.getListaJogadas().remove(t3-1+2);
				this.getListaJogadas().remove(t3-1+1);
				
				*/
				
				
				
				
				}break;
				
				
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
				/*
				int t4 = this.getListaJogadas().size();
				
				Caminho ca4 = new Caminho(); ca4 = this; ca4.setJogada(a4);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(ca4);
				Caminho cb4 = new Caminho(); cb4 = this; cb4.setJogada(b4);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(cb4);
				Caminho cc4 = new Caminho(); cc4 = this; cc4.setJogada(c4);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(cc4);
				Caminho cd4 = new Caminho(); cd4 = this; cd4.setJogada(d4);
				
				
				this.getListaJogadas().remove(t4-1+4);
				this.getListaJogadas().remove(t4-1+3);
				this.getListaJogadas().remove(t4-1+2);
				this.getListaJogadas().remove(t4-1+1);
				*/
				
			
				
				}break;
				
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
				
				/*
				int t5 = this.getListaJogadas().size();
				
				Caminho ca5 = new Caminho(); ca5 = (Caminho) this.clone(); 
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(ca5);
				//System.out.println("tamanho do caminho antes add "+ca5.getListaJogadas().size()); 
				ca5.setJogada(a5);
				//System.out.println("tamanho do caminho pos add "+ca5.getListaJogadas().size());
				Caminho cb5 = new Caminho(); cb5 = (Caminho) this.clone(); cb5.setJogada(b5);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(cb5);
				Caminho cc5 = new Caminho(); cc5 = (Caminho) this.clone(); cc5.setJogada(c5);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(cc5);
				
				
				this.getListaJogadas().remove(t5-1+3);
				this.getListaJogadas().remove(t5-1+2);
				this.getListaJogadas().remove(t5-1+1);
				*/
				
				
				
				
				
				
				
				
				}break;
				
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
				/*
				int t6 = this.getListaJogadas().size();
				
				Caminho ca6 = (Caminho)this.clone(); ca6.setJogada(a6);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(ca6);
				Caminho cb6 = (Caminho)this.clone(); cb6.setJogada(b6);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(cb6);
				
				this.getListaJogadas().remove(t6-1+2);
				this.getListaJogadas().remove(t6-1+1);
			
				
				*/
				
				
				
				
				}break;
				
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
				
				/*
				int t7 = this.getListaJogadas().size();
				
				Caminho ca7 = new Caminho(); ca7 = (Caminho)this.clone(); ca7.setJogada(a7);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(ca7);
				Caminho cb7 = new Caminho(); cb7 = (Caminho)this.clone(); cb7.setJogada(b7);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(cb7);
				Caminho cc7 = new Caminho(); cc7 = (Caminho)this.clone(); cc7.setJogada(c7);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(cc7);
				
				this.getListaJogadas().remove(t7-1+3);
				this.getListaJogadas().remove(t7-1+2);
				this.getListaJogadas().remove(t7-1+1);
				
				*/
				
				
				
			
				
				}break;
				
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
				
				/*
				 
				int t8 = this.getListaJogadas().size();
				
				Caminho ca8 = (Caminho) this.clone(); ca8.setJogada(a8);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(ca8);
				Caminho cb8 =  (Caminho) this.clone(); cb8.setJogada(b8);
				this.getUmGerenciador().getUmaFronteira().getCaminhos().add(cb8);
				
				this.getListaJogadas().remove(t8-1+2);
				this.getListaJogadas().remove(t8-1+1);
				*/
				
				}break;
			
			}
			
			
			
			
			
			
		}
		
		
		
	}	
	return al;
		
	}


	


	

public Jogada jogadaDoTopo(){
	int tam = this.getListaJogadas().size();
	return this.getListaJogadas().get(tam-1);
}

	
	public int calculaHeuristicaDoCaminho(Caminho c){
		// calcula a heuristica de um array de jogadas (um caminho)
		int tamC = c.getListaJogadas().size();
		int cont = 0;
		for(int i = 0; i< tamC; i++){
			
			cont = cont + this.getListaJogadas().get(i).calculaHeuristica();
			
		}
		return cont;
	}
	
	

}
