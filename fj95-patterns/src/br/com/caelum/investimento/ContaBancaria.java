package br.com.caelum.investimento;

public class ContaBancaria {
	private double saldo;

	public ContaBancaria(double saldo) {
		this.saldo = saldo;
		System.out.println("Conta inicializada com saldo:[" + saldo + "]");
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}