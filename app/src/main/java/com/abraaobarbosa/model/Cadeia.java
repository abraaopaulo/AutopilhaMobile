package com.abraaobarbosa.model;

import java.util.Arrays;

public class Cadeia {
	
	private String[] itens;

	public Cadeia(String... itens) {
		this.itens = itens;
	}

	public String[] getItens() {
		return itens;
	}

	public void setItens(String... itens) {
		this.itens = itens;
	}
	public String getPrimeiroItem() {
		if(itens.length > 0 ) {
			return itens[0];
		}
		return "erro";
	}
	@Override
	public String toString() {
		return "Cadeia [itens=" + Arrays.toString(itens) + "]";
	}

	public void removerprimeiroItem() {
		String[] nova = new String[itens.length-1];
		for(int i = 1; i<itens.length; i++) {
			nova[i-1] = itens[i];
		}
		itens = nova;
	}
	
}
