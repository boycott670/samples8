package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

public class AirConditionerContext
{

	public AirConditionerContext(String city) {
		this.city = city;
	}

	private final String city;
	private AirConditionerState state;
	private double temperature;

	double getTemperature() {
		return temperature;
	}

	void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public void start ()
	{
		double temperature = 0;
		
		switch (this.city){
			case "RABAT":
				temperature = 15;
			case "CASABLANCA":
				temperature = 12;
			case "AGADIR":
				temperature = 25;
		}
		
		state = new StartedAirConditionerState();
		state.setContext(this);
	}
	
	public void stop ()
	{
		state = new StoppedAirConditionerState();
		state.setContext(this);
	}
}
