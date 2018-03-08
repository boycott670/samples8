package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

interface AirConditionerState {

	void displayTemperature (final double temperature);
	double increase (final double temperature, final double increment);
	double decrease (final double temperature, final double increment);
	AirConditionerState stop ();
	AirConditionerState start ();
	
}
