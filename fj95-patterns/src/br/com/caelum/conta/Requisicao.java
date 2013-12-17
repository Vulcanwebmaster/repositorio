package br.com.caelum.conta;

public class Requisicao {
	private Formato formato;

	public Requisicao(Formato formato) {
		this.setFormato(formato);
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}
}
