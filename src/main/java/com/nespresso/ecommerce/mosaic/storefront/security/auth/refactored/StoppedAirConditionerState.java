package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

public class StoppedAirConditionerState implements AirConditionerState
{

	private AirConditionerContext context;
	
	@Override
	public void setContext(AirConditionerContext context) {
		// TODO Auto-generated method stub
		
		this.context = context;
	}

	@Override
	public void increase(double increment) {
		System.out.println("Climatiseur is not started, please start it and try again");
	}
	
	@Override
	public void decrease(double increment) {
		System.out.println("Climatiseur is not started, please start it and try again");
	}

	@Override
	public void displayTemperature() {
		// TODO Auto-generated method stub

		System.out.println("Climatiseur is stopped, temperature is unkown");
	}

	@Override
	public void start(double initialTemperature) {
		// TODO Auto-generated method stub

		context.setTemperature(initialTemperature);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Climatiseur is already stopped, we are doing nothing");
	}
}
