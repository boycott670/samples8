package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

public class AirConditionerContext {

	private final String city;
	private double temperature;
	private AirConditionerState state;
	
	public AirConditionerContext(String city) {
		this.city = city;
		state = new StoppedAirConditionerState();
	}
	
	public void stop ()
	{
		final AirConditionerState previousState = state;
		
		state = state.stop();
		
		if (state != previousState)
		{
			temperature = 0;
		}
	}
	
	public void start ()
	{
		final AirConditionerState previousState = state;
		
		state = state.start();
		
		if (state != previousState)
		{
			double temperature = 0;
			
			switch (city){
				case "RABAT":
					temperature = 15;
					break;
				case "CASABLANCA":
					temperature = 12;
					break;
				case "AGADIR":
					temperature = 25;
			}
			
			this.temperature = temperature;
		}
	}

	public String getCity() {
		return city;
	}
	
	public void displayTemperature ()
	{
		state.displayTemperature(temperature);
	}
	
	public void increase (final double increment)
	{
		temperature = state.increase(temperature, increment);
	}
	
	public void decrease (final double increment)
	{
		temperature = state.decrease(temperature, increment);
	}
	
}
