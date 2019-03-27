package com.hakanjava.learn;
import java.math.BigDecimal;

public class SecretCalculation {
	public BigDecimal calculate(double operand) {
		double calculatedValue = operand * 100 / Math.PI;
		BigDecimal ret = BigDecimal.valueOf(calculatedValue);
		return ret;
	}
}
