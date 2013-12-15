package br.com.caelum.investimento;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class RealizadorDeInvestimentosTest {

	@Test
	public void test() {
        ContaBancaria conta = new ContaBancaria(10000.0);

        Investimento conservador = new Conservador();
        Investimento moderado = new Moderado();
        Investimento arrojado = new Arrojado();

        RealizadorDeInvestimentos realizador = new RealizadorDeInvestimentos();
        
        realizador.realizaInvestimento(conta, conservador);
		assertThat(conta.getSaldo(), equalTo(10600.0));
		
		conta.setSaldo(10000.0);
		
		double min = 10000.0 * (1 + (0.025 * 0.75));
		double max = 10000.0 * (1 + (0.070 * 0.75));
		
		realizador.realizaInvestimento(conta, moderado);
		assertThat(conta.getSaldo(), anyOf(equalTo(min), equalTo(max)));

		conta.setSaldo(10000.0);

		double avg = 10000.0 * (1 + (0.03 * 0.75));
		min = 10000.0 * (1 + (0.05 * 0.75));
		max = 10000.0 * (1 + (0.06 * 0.75));
		
		realizador.realizaInvestimento(conta, arrojado);
		assertThat(conta.getSaldo(), anyOf(equalTo(min), equalTo(avg), equalTo(max)));
		
	}

}
