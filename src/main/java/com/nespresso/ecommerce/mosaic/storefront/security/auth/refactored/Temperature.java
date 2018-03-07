package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

import java.util.Arrays;

public enum Temperature {

	LOW ("Low"),
	MEDIUM ("Medium"),
	ABOVE_MEDIUM ("Above medium"),
	HIGH ("High");
	
	private final String representationValue;
	
	private Temperature(String representationValue)
	{
		this.representationValue = representationValue;
	}

	public Temperature getNext ()
	{
		int indexOfNextTemperature = Arrays.asList(values()).indexOf(this) + 1;
		
		if (indexOfNextTemperature >= values().length)
		{
			indexOfNextTemperature = values().length - 1;
		}
		
		return values() [indexOfNextTemperature];
	}
	
	public Temperature getPrevious ()
	{
		int indexOfPreviousTemperature = Arrays.asList(values()).indexOf(this) - 1;
		
		if (indexOfPreviousTemperature < 0)
		{
			indexOfPreviousTemperature = 0;
		}
		
		return values() [indexOfPreviousTemperature];
	}
	
	@Override
	public String toString()
	{
		return representationValue;
	}
}
