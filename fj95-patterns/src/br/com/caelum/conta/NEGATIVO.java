package br.com.caelum.conta;

public class NEGATIVO implements EstadoDeUmaConta {

	@Override
	public void efetuarSaque(Conta conta, double valorSaque) {
		throw new IllegalArgumentException("A conta est� negativa, ent�o n�o � poss�vel efetuar um saque");
	}

	@Override
	public void efetuarDeposito(Conta conta, double valorDeposito) {
		double saldo = conta.getSaldo();
		saldo += valorDeposito * 0.95;
		conta.setSaldo(saldo);

		if (saldo > 0) {
			conta.estado = new POSITIVO();
		}
	}

}
