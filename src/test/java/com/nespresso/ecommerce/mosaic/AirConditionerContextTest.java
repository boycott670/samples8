package com.nespresso.ecommerce.mosaic;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nespresso.ecommerce.mosaic.storefront.security.auth.presenters.DefaultPresenter;
import com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored.AirConditionerContext;

public class AirConditionerContextTest {

	@Test
	public void test ()
	{
		final AirConditionerContext airConditioner = new AirConditionerContext("RABAT", new DefaultPresenter());
		
		airConditioner.displayTemperature();
		
		airConditioner.start();
		
		airConditioner.displayTemperature();
		
		airConditioner.increase(2);
		
		airConditioner.displayTemperature();
		
		airConditioner.stop();
		
		airConditioner.decrease(5);
		
		airConditioner.displayTemperature();
		
		assertTrue(true);
	}
	
}
