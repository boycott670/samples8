package com.nespresso.ecommerce.mosaic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nespresso.ecommerce.mosaic.storefront.security.auth.presenters.DefaultPresenter;
import com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored.AirConditioner;
import com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored.City;

public class AirConditionerContextTest {

	@Test
	public void test ()
	{
		final AirConditioner airConditionerContext1 = new AirConditioner("RABAT", new DefaultPresenter());
		
		assertEquals(airConditionerContext1.getCity(), City.RABAT);
		
		airConditionerContext1.displayTemperature();
		
		final AirConditioner airConditionerContext2 = airConditionerContext1.start();
		
		assertFalse(airConditionerContext2 == airConditionerContext1);
		
		airConditionerContext2.displayTemperature();
		
		final AirConditioner airConditionerContext3 = airConditionerContext2.increase(2);
		
		assertFalse(airConditionerContext3 == airConditionerContext2);
		
		airConditionerContext3.displayTemperature();
		
		final AirConditioner airConditionerContext4 = airConditionerContext3.stop();
		
		assertFalse(airConditionerContext4 == airConditionerContext3);
		
		final AirConditioner airConditionerContext5 = airConditionerContext4.decrease(5);
		
		assertTrue(airConditionerContext5 == airConditionerContext4);
		
		airConditionerContext5.displayTemperature();
	}
	
}
