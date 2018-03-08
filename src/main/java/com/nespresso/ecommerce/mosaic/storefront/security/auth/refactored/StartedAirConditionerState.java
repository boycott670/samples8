package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

import java.util.Calendar;

class StartedAirConditionerState implements AirConditionerState {

	@Override
	public void displayTemperature(final double temperature) {
		
		System.out.println("Temperature is " + temperature);
		
	}

	@Override
	public double increase(double temperature, double increment) {
		
		if (Calendar.getInstance().get(2) > 9 || Calendar.getInstance().get(2) < 3) {
            return temperature + increment;
        }else{
            System.out.println("We are in cold season, you cannot add more temperature");
            return temperature;
        }
	}

	@Override
	public double decrease(double temperature, double increment) {

		if (Calendar.getInstance().get(2) > 4 && Calendar.getInstance().get(2) < 9) {
            return temperature - increment;
        }else{
            System.out.println("We are in warm season, you cannot add more temperature");
            return temperature;
        }

	}

	@Override
	public AirConditionerState stop() {

		return new StoppedAirConditionerState();
		
	}

	@Override
	public AirConditionerState start() {

		System.out.println("Climatiseur is already started, we are doing nothing");
		return this;

	}

}
