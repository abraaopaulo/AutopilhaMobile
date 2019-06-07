package com.abraaobarbosa.model;

public class Transicao {
	
	private Estado estadoInicial;
	private Estado estadoFinal;
	
	private String[] ler;
	private String[] consome;
	private String[] retorna;
	
	public Transicao() {}
	
	public Transicao(Estado estadoInicial, Estado estadoFinal, String[] ler, String[] consome, String[] retorna) {
		this.estadoInicial = estadoInicial;
		this.estadoFinal = estadoFinal;
		this.ler = ler;
		this.consome = consome;
		this.retorna = retorna;
	}
	public Transicao(Estado estadoInicial, Estado estadoFinal, String ler, String consome, String retorna) {
		this.estadoInicial = estadoInicial;
		this.estadoFinal = estadoFinal;
		this.ler = new String[1]; this.ler[0] = ler;
		this.consome = new String[1]; this.consome[0] = consome;
		this.retorna = new String[1]; this.retorna[0] = retorna;
	}
	public Estado getEstadoInicial() {
		return estadoInicial;
	}
	public void setEstadoInicial(Estado estadoInicial) {
		this.estadoInicial = estadoInicial;
	}
	public Estado getEstadoFinal() {
		return estadoFinal;
	}
	public void setEstadoFinal(Estado estadoFinal) {
		this.estadoFinal = estadoFinal;
	}
	public String[] getLer() {
		return ler;
	}
	public void setLer(String[] ler) {
		this.ler = ler;
	}
	public String[] getConsome() {
		return consome;
	}
	public void setConsome(String[] consome) {
		this.consome = consome;
	}
	public String[] getRetorna() {
		return retorna;
	}
	public void setRetorna(String[] retorna) {
		this.retorna = retorna;
	}
	
	
	
}
