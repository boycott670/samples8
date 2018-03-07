package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

import java.util.Optional;

public enum City {

	RABAT (15),
	CASABLANCA (12),
	AGADIR (25);
	
	public static City fromString(final String city)
	{
		return Optional.ofNullable(valueOf(city)).orElseThrow(() -> new IllegalArgumentException("city not found"));
	}
	
	private City(double temperature) {
		this.temperature = temperature;
	}

	private final double temperature;

	public double getTemperature() {
		return temperature;
	}
}
