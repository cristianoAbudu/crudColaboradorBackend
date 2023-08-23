package com.backend;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Teste {
	public static void main(String[] args) {
		BigDecimal reais = new BigDecimal(23.20);
		System.out.println(reais);
		DecimalFormat simpleFormatter = new DecimalFormat("#.##");
		reais = reais.setScale(2, RoundingMode.HALF_DOWN);
		System.out.println(reais);
		System.out.println(simpleFormatter.format(reais));

		Integer centavos = 2320;
	}
}
