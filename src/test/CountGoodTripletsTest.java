package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import april.CountGoodTriplets;

class CountGoodTripletsTest {
	
	CountGoodTriplets cga = new CountGoodTriplets();

	@Test
	void testCountGoodTriplets() {
		int[] arr = new int[] {3,0,1,1,9,7};
		int a = 7, b = 2, c = 3;
		
		int expected =  cga.countGoodTriplets(arr, a, b, c);
		int actual = 4;
		
		assertEquals(expected,actual);
	}

	@Test
	void testCountGoodTriplets1() {
		int[] arr = new int[] {3,0,1,1,9,7};
		int a = 7, b = 2, c = 3;
		
		int expected =  cga.countGoodTriplets1(arr, a, b, c);
		int actual = 4;
		
		assertEquals(expected,actual);
	}

}
