package fr.comprehensiveit.java.security.chaintransformer;

import static org.junit.Assert.*;

import org.junit.Test;
import fr.comprehensiveit.java.security.chaintransformer.Discount;

public class DiscountTest {

	@Test
	public void testTwoDiscounts() {
		System.out.println("Starting testTwoDiscounts");
		Discount discount = new Discount();
		Double price = 100.0;
		Double firstDiscount = 0.8;
		Double secondDiscount = 0.9;
		Double expectedResult = 72.0;
		Double realResult = discount.twoDiscounts(price, firstDiscount, secondDiscount);
		assertEquals(expectedResult,realResult);
		System.out.println("testTwoDiscounts returned :"+realResult);
		
	}

}
