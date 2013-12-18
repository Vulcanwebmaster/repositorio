package br.com.caelum.orcamento;

public class Aprovado implements EstadoDeUmOrcamento {

	private boolean descontoAplicado = false;

	public void aplicaDescontoExtra(Orcamento orcamento) {
		if (!descontoAplicado) {
			orcamento.valor -= orcamento.valor * 0.02;
			descontoAplicado = true;
		} else {
			throw new RuntimeException("Desconto j� aplicado!");
		}
	}

	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento j� est� em estado de aprova��o");
	}

	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento est� em estado de aprova��o e n�o pode ser reprovado");
	}

	public void finaliza(Orcamento orcamento) {
		orcamento.estadoAtual = new Finalizado();
	}

}
