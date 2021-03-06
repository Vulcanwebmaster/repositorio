package br.com.caelum.orcamento;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class ICCCTest {

	@Test
	public void test() {
		Orcamento orc1 = new Orcamento( 500.0);
		Orcamento orc2 = new Orcamento(1500.0);
		Orcamento orc3 = new Orcamento(5000.0);

		ICCC iccc = new ICCC();
		
        // garantindo que a query funcionou
		assertThat(iccc.calcula(orc1), equalTo( 500.0 * 0.05));
		assertThat(iccc.calcula(orc2), equalTo(1500.0 * 0.07));
		assertThat(iccc.calcula(orc3), equalTo(5000.0 * 0.08 + 30));
	}

}
