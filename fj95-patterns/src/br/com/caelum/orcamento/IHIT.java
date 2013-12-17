package br.com.caelum.orcamento;

public class IHIT extends Imposto {

	public IHIT(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {

		if (existemDoisItensComMesmoNome(orcamento)) {
			return orcamento.getValor() * 0.13 + 100.0;
		}

		return orcamento.getValor() * 0.01 * orcamento.getItens().size();
	}

	private boolean existemDoisItensComMesmoNome(Orcamento orcamento) {

		for (int i = 0; i < orcamento.getItens().size() - 1; i++) {

			for (int j = i + 1; j < orcamento.getItens().size(); j++) {

				if (orcamento.getItens().get(i).getNome()
						.equals(orcamento.getItens().get(j).getNome())) {

					return true;

				}

			}

		}

		return false;
	}

}
