package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

public interface AirConditionerState {

	void setContext (final AirConditionerContext context);
	void increase (final double increment);
	void decrease (final double increment);
	void displayTemperature ();
	void start (final double initialTemperature);
	void stop ();
	
}
