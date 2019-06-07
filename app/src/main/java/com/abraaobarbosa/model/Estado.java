package com.abraaobarbosa.model;

import java.util.ArrayList;

public class Estado {
	
	private String nome;
	
	private ArrayList<Transicao> transicoes;
	
	private boolean estadoInicial = false;
	private boolean estadoFinal = false;
	
	public Estado(ArrayList<Transicao> transicoes, boolean estadoInicial, boolean estadoFinal, String nome) {
		this.transicoes = transicoes;
		this.estadoInicial = estadoInicial;
		this.estadoFinal = estadoFinal;
		this.nome = nome;
	}
	public Estado() {}
	public ArrayList<Transicao> getTransicoes() {
		return transicoes;
	}
	public void setTransicoes(ArrayList<Transicao> transicoes) {
		this.transicoes = transicoes;
	}
	public boolean isEstadoInicial() {
		return estadoInicial;
	}
	public void setEstadoInicial(boolean estadoInicial) {
		this.estadoInicial = estadoInicial;
	}
	public boolean isEstadoFinal() {
		return estadoFinal;
	}
	public void setEstadoFinal(boolean estadoFinal) {
		this.estadoFinal = estadoFinal;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (estadoFinal != other.estadoFinal)
			return false;
		if (estadoInicial != other.estadoInicial)
			return false;

		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (transicoes == null) {
			if (other.transicoes != null)
				return false;
		} else if (!transicoes.equals(other.transicoes))
			return false;
		return true;
	}
	
	
}
