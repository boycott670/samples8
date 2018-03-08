package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

import java.util.Calendar;

public class StartedAirConditionerState implements AirConditionerState
{

	private AirConditionerContext context;
	
	@Override
	public void setContext(AirConditionerContext context)
	{
		this.context = context;
	}

	@Override
	public void increase(double increment)
	{
		if (Calendar.getInstance().get(2) > 9 && Calendar.getInstance().get(2) < 3)
		{
	        context.setTemperature(context.getTemperature() + increment);
	    }else
	    {
	        System.out.println("We are in warm season, you cannot add more temperature");
	    }		
	}

	@Override
	public void decrease(double increment) {

		if (Calendar.getInstance().get(2) > 4 && Calendar.getInstance().get(2) < 9) {
			context.setTemperature(context.getTemperature() - increment);
        }else{
            System.out.println("We are in warm season, you cannot add more temperature");
        }
		
	}

	@Override
	public void displayTemperature() {
		// TODO Auto-generated method stub
		
		
		System.out.println("Temperature is " + context.getTemperature());

	}

	@Override
	public void start(double initialTemperature) {
		// TODO Auto-generated method stub

		System.out.println("Climatiseur is already started, we are doing nothing");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		context.setTemperature(0);
	}
}
