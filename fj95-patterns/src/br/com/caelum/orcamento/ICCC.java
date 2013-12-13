package br.com.caelum.orcamento;

//ICCC
public class ICCC {

	public double calcula(Orcamento orcamento) {

		if (orcamento.getValor() < 1000.0) {
			return orcamento.getValor() * 0.05;
		} else if (orcamento.getValor() >= 1000.0
				&& orcamento.getValor() <= 3000.00) {
			return orcamento.getValor() * 0.07;
		} else {
			return orcamento.getValor() * 0.08 + 30;
		}
	}

	public static void main(String[] args) {

		Orcamento orc1 = new Orcamento(500.0);
		Orcamento orc2 = new Orcamento(1500.0);
		Orcamento orc3 = new Orcamento(5000.0);

		ICCC iccc = new ICCC();

		System.out.println(iccc.calcula(orc1));
		System.out.println(iccc.calcula(orc2));
		System.out.println(iccc.calcula(orc3));

	}
}