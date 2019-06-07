package com.abraaobarbosa.automato;

import com.abraaobarbosa.model.Cadeia;
import com.abraaobarbosa.model.Estado;
import com.abraaobarbosa.model.Transicao;

import java.util.ArrayList;
import java.util.Stack;



public class Automato {
	
	private ArrayList<Estado> estados;

	private Estado estadoDePartida;
	private Estado estadoDeFinalizacao;
	
	private Cadeia cadeia;
	
	private Stack<String> pilha;

	public Automato(ArrayList<Estado> estados, Cadeia cadeia) {
		super();
		this.estados = estados;
		this.cadeia = cadeia;
		this.pilha = new Stack<String>();	
	}
	
	public ArrayList<String> run() {
		pilha.push("$");
		//buscando o estado inicial e final
		for(Estado e : estados) {
			if(e.isEstadoInicial()) {
				this.estadoDePartida = e;
			}else if(e.isEstadoFinal()) {
				this.estadoDeFinalizacao = e;
			}
		}
		
		return iterar(estadoDePartida, cadeia,new ArrayList<String>());
	}
	public ArrayList<String> iterar(Estado estado,Cadeia restoCadeia,ArrayList<String> iteracoes) {
		
		ArrayList<Transicao> listaDeTansicoes = estado.getTransicoes();
		//auxilio para saber quando ter que ler vazio
		boolean ninguemTemOQLeio = true;
		Estado estadoTransicaoVaizia  = null;
		
		String ler = "";
		String consome = "";
		String retorna = "";
		
		for(Transicao  t : listaDeTansicoes) {
			ler=""; consome=""; retorna="";
			for(String s :t.getLer())ler += s;
			for(String s :t.getConsome())consome += s;			
			for(String s :t.getRetorna())retorna += s;
					
			//se o que posso ler é igual a o primeiro item da cadeia
			if(ler.equals(restoCadeia.getPrimeiroItem())) {
				if(pilha.peek().equals(consome)) {
					pilha.pop();
				}
				if(!retorna.equals("E"))
					pilha.push(retorna);
				
				iteracoes.add("|- "+t.getEstadoFinal().getNome()+" / "+cadeia.toString()+" / "+pilha.toString());
				restoCadeia.removerprimeiroItem();
				ninguemTemOQLeio = false;				
				return iterar(t.getEstadoFinal(),restoCadeia,iteracoes);
			}else if(ler.equals("E")){
				estadoTransicaoVaizia = t.getEstadoFinal();
			}
		}
		if(ninguemTemOQLeio && estadoTransicaoVaizia != null) {
			iteracoes.add("|- "+estadoTransicaoVaizia.getNome()+" / "+cadeia.toString()+" / "+pilha.toString());
			return iterar(estadoTransicaoVaizia,restoCadeia,iteracoes);
		}
		
		
		return iteracoes;
	}

	public ArrayList<Estado> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstadoDePartida() {
		return estadoDePartida;
	}

	public void setEstadoDePartida(Estado estadoDePartida) {
		this.estadoDePartida = estadoDePartida;
	}

	public Estado getEstadoDeFinalizacao() {
		return estadoDeFinalizacao;
	}

	public void setEstadoDeFinalizacao(Estado estadoDeFinalizacao) {
		this.estadoDeFinalizacao = estadoDeFinalizacao;
	}

	public Cadeia getCadeia() {
		return cadeia;
	}

	public void setCadeia(Cadeia cadeia) {
		this.cadeia = cadeia;
	}

	public Stack<String> getPilha() {
		return pilha;
	}

	public void setPilha(Stack<String> pilha) {
		this.pilha = pilha;
	}
	
}
