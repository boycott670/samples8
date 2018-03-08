package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

import com.nespresso.ecommerce.mosaic.storefront.security.auth.presenters.Presenter;

interface AirConditionerState {

	void displayTemperature (final double temperature, final Presenter presenter);
	double increase (final double temperature, final double increment, final Presenter presenter);
	double decrease (final double temperature, final double increment, final Presenter presenter);
	AirConditionerState stop (final Presenter presenter);
	AirConditionerState start (final Presenter presenter);
	
}
