package br.com.caelum.orcamento;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class DescontoExtraTest {

	/**
	 * 
	 */
	@Test
	public void test() {

		Orcamento reforma = new Orcamento(500.0);

		reforma.aplicaDescontoExtra();

		assertThat(475.0, equalTo(reforma.getValor()));

		reforma.aprova(); // aprova nota!

		assertThat(reforma.estadoAtual, instanceOf(Aprovado.class));

		reforma.aplicaDescontoExtra();

		assertThat(465.5, equalTo(reforma.getValor()));

		reforma.finaliza();

		assertThat(reforma.estadoAtual, instanceOf(Finalizado.class));

		// reforma.aplicaDescontoExtra(); lancaria excecao, pois n�o pode dar
		// desconto nesse estado
		// reforma.aprova(); lan�a exce��o, pois n�o pode ir para aprovado

	}

}
