package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

import com.nespresso.ecommerce.mosaic.storefront.security.auth.presenters.Presenter;

public class AirConditionerContext {

	private final String city;
	private double temperature;
	private AirConditionerState state;
	private Presenter presenter;
	
	public AirConditionerContext(String city, Presenter presenter) {
		this.city = city;
		state = new StoppedAirConditionerState();
		this.presenter = presenter;
	}
	
	public void stop ()
	{
		final AirConditionerState previousState = state;
		
		state = state.stop(presenter);
		
		if (state != previousState)
		{
			temperature = 0;
		}
	}
	
	public void start ()
	{
		final AirConditionerState previousState = state;
		
		state = state.start(presenter);
		
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
		state.displayTemperature(temperature, presenter);
	}
	
	public void increase (final double increment)
	{
		temperature = state.increase(temperature, increment, presenter);
	}
	
	public void decrease (final double increment)
	{
		temperature = state.decrease(temperature, increment, presenter);
	}

	Presenter getPresenter() {
		return presenter;
	}

	void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
}
