package may.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import may.PrimeSubtractionOperation;

class PrimeSubtractionOperationTest {

	PrimeSubtractionOperation p = new PrimeSubtractionOperation();
	@Test
	void test() {
		int[] nums = {4,9,6,10};
		
		boolean actual = p.primeSubOperation(nums);
		
		boolean expected = true;
		
		assertEquals(expected, actual);
		
	}
	
	
	
	@Test
	void test1() {
		int[] nums = {6,8,11,12};
		
		boolean actual = p.primeSubOperation(nums);
		
		boolean expected = true;
		
		assertEquals(expected, actual);
		
	}
	
	
	
	@Test
	void test2() {
		int[] nums = {5,8,3};
		
		boolean actual = p.primeSubOperation(nums);
		
		boolean expected = false;
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void test3() {
		int[] nums = {17,2};
		
		boolean actual = p.primeSubOperation(nums);
		
		boolean expected = false;
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void test4() {
		int[] nums = {15,20,17,7,16};
		
		boolean actual = p.primeSubOperation(nums);
		
		boolean expected = true;
		
		assertEquals(expected, actual);
		
	}
	
	
	@Test
	void test4WithoutTreeSet() {
		int[] nums = {15,20,17,7,16};
		
		boolean actual = p.primeSubOperation1(nums);
		
		boolean expected = true;
		
		assertEquals(expected, actual);
		
	}

}
