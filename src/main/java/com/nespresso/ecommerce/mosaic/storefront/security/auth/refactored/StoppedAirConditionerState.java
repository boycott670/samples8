package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

import com.nespresso.ecommerce.mosaic.storefront.security.auth.presenters.Presenter;

class StoppedAirConditionerState implements AirConditionerState {

	@Override
	public void displayTemperature(double temperature, Presenter presenter) {
		// TODO Auto-generated method stub

		presenter.displayMessage("Climatiseur is stopped, temperature is unkown");
		
	}

	@Override
	public double increase(double temperature, double increment, final Presenter presenter) {
		presenter.displayMessage("Climatiseur is not started, please start it and try again");
		return temperature;
	}

	@Override
	public double decrease(double temperature, double increment, final Presenter presenter) {

		presenter.displayMessage("Climatiseur is not started, please start it and try again");
		return temperature;
		
	}

	@Override
	public AirConditionerState stop(final Presenter presenter) {
		
		presenter.displayMessage("Climatiseur is already stopped, we are doing nothing");
		return this;
		
	}

	@Override
	public AirConditionerState start(final Presenter presenter) {

		return new StartedAirConditionerState();
		
	}

}
