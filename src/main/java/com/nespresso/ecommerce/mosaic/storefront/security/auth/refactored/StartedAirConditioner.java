package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

import java.time.Month;
import java.util.Calendar;

public final class StartedAirConditioner extends AirConditioner
{
	public StartedAirConditioner (final String city, final Presenter presenter)
	{
		super (City.fromString(city), presenter, 0.0D);
	}
	
	StartedAirConditioner (final City city, final Presenter presenter, final double temperature)
	{
		super (city, presenter, temperature);
	}
	
	@Override
	public void displayTemperature()
	{
		presenter.displayMessage(String.format("Temperature is %.0f", temperature));
	}

	@Override
	public StartedAirConditioner decrease(double delta) {

		final int currentMonth = Calendar.getInstance().get(CALENDAR_MONTH_FIELD);
		
		if (currentMonth >= Month.APRIL.getValue() && currentMonth <= Month.SEPTEMBER.getValue())
		{
			return new StartedAirConditioner(city, presenter, temperature - delta);
		}
		else
		{
			presenter.displayMessage("We are in warm season, you cannot decrease more temperature");
		}
		
		return this;
		
	}

	@Override
	public StartedAirConditioner increase(double delta) {

		final int currentMonth = Calendar.getInstance().get(CALENDAR_MONTH_FIELD);
		
		if (currentMonth >= Month.OCTOBER.getValue() || currentMonth <= Month.MARCH.getValue())
		{
			return new StartedAirConditioner(city, presenter, temperature + delta);
		}
		else
		{
			presenter.displayMessage("We are in cold season, you cannot increase more temperature");
		}
		
		return this;
		
	}
	
	public StoppedAirCondtioner stop ()
	{
		return new StoppedAirCondtioner(city, presenter, 0.0D);
	}
	
}