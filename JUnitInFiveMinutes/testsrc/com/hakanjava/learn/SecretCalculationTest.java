package com.hakanjava.learn;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class SecretCalculationTest {

	private SecretCalculation cut;

	@Before
	public void setUp() throws Exception {
		cut = new SecretCalculation();
	}

	@Test
	public void testCalculate() {
		double initial_value = 1.1;
		BigDecimal expectedValue = BigDecimal.valueOf(1.1 * 100 / Math.PI);
		assertTrue(expectedValue.equals(cut.calculate(initial_value)));
	}

}
