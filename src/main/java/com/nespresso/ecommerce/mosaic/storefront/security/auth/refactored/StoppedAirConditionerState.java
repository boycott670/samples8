package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

class StoppedAirConditionerState implements AirConditionerState {

	@Override
	public void displayTemperature(double temperature) {
		// TODO Auto-generated method stub

		System.out.println("Climatiseur is stopped, temperature is unkown");
		
	}

	@Override
	public double increase(double temperature, double increment) {
		System.out.println("Climatiseur is not started, please start it and try again");
		return temperature;
	}

	@Override
	public double decrease(double temperature, double increment) {

		System.out.println("Climatiseur is not started, please start it and try again");
		return temperature;
		
	}

	@Override
	public AirConditionerState stop() {
		
		System.out.println("Climatiseur is already stopped, we are doing nothing");
		return this;
		
	}

	@Override
	public AirConditionerState start() {

		return new StartedAirConditionerState();
		
	}

}
