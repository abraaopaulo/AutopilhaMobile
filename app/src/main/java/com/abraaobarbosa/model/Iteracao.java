package com.abraaobarbosa.model;

public class Iteracao {
	
	private Estado estado;
	private Cadeia cadeia;
	private String pilha;
	
	public Iteracao() {}
	
	public Iteracao(Estado estado, Cadeia cadeia, String pilha) {
		super();
		this.estado = estado;
		this.cadeia = cadeia;
		this.pilha = pilha;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Cadeia getCadeia() {
		return cadeia;
	}
	public void setCadeia(Cadeia cadeia) {
		this.cadeia = cadeia;
	}
	public String getPilha() {
		return pilha;
	}
	public void setPilha(String pilha) {
		this.pilha = pilha;
	}
	
	

}
