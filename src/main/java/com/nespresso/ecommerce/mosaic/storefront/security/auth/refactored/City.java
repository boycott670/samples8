package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

public enum City {

	RABAT (15),
	CASABLANCA (12),
	AGADIR (25);
	
	private City(double temperature) {
		this.temperature = temperature;
	}

	private final double temperature;

	public double getTemperature() {
		return temperature;
	}
}
