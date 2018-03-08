package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

import java.util.Calendar;

import com.nespresso.ecommerce.mosaic.storefront.security.auth.presenters.Presenter;

class StartedAirConditionerState implements AirConditionerState {

	@Override
	public void displayTemperature(final double temperature, final Presenter presenter) {
		
		presenter.displayMessage("Temperature is " + temperature);
		
	}

	@Override
	public double increase(double temperature, double increment, final Presenter presenter) {
		
		if (Calendar.getInstance().get(2) > 9 || Calendar.getInstance().get(2) < 3) {
            return temperature + increment;
        }else{
            presenter.displayMessage("We are in cold season, you cannot add more temperature");
            return temperature;
        }
	}

	@Override
	public double decrease(double temperature, double increment, final Presenter presenter) {

		if (Calendar.getInstance().get(2) > 4 && Calendar.getInstance().get(2) < 9) {
            return temperature - increment;
        }else{
            presenter.displayMessage("We are in warm season, you cannot add more temperature");
            return temperature;
        }

	}

	@Override
	public AirConditionerState stop(final Presenter presenter) {

		return new StoppedAirConditionerState();
		
	}

	@Override
	public AirConditionerState start(final Presenter presenter) {

		presenter.displayMessage("Climatiseur is already started, we are doing nothing");
		return this;

	}

}
