package com.koko.java8.design.delegate;

import java.math.BigDecimal;
import java.util.function.Function;

public class CalculateNAV {
	private Function<String, BigDecimal> priceFinder;

	public BigDecimal computeStockWorth(
			final String ticker, final int shares) {
		return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
	}

}