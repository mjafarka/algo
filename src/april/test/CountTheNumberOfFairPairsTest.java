package april.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import april.CountTheNumberOfFairPairs;

class CountTheNumberOfFairPairsTest {

	
	CountTheNumberOfFairPairs a = new CountTheNumberOfFairPairs();
	@Test
	void test() {
		int[] nums = new int[] {0,1,7,4,4,5};
		
		int lower = 3;
		int upper = 6;
		
		
		int expected = 6;
		
		long actual = a.countFairPairs(nums, lower, upper);
		
		assertEquals(expected,actual);
	}
	
	
	@Test
	void test2() {
		int[] nums = new int[] {0,1,7,4,4,6};
		
		int lower = 3;
		int upper = 6;
		
		
		int expected = 5;
		
		long actual = a.countFairPairs(nums, lower, upper);
		
		assertEquals(expected,actual);
	}
	
	
	@Test
	void test3() {
		int[] nums = new int[] {0,0,0};
		
		int lower = 0;
		int upper = 0;
		
		
		int expected = 3;
		
		long actual = a.countFairPairs(nums, lower, upper);
		
		assertEquals(expected,actual);
	}
	
	@Test
	void test1() {
		int[] nums = new int[] {1,7,9,2,5};
		
		int lower = 11;
		int upper = 11;
		
		
		int expected = 1;
		
		long actual = a.countFairPairs(nums, lower, upper);
		
		assertEquals(expected,actual);
	}
	
	@Test
	void testSliding1() {
		int[] nums = new int[] {0,1,7,4,4,5};
		
		int lower = 3;
		int upper = 6;
		
		
		int expected = 6;
		
		long actual = a.countFairPairsSLIDINGWINDOW(nums, lower, upper);
		
		assertEquals(expected,actual);
	}
	
	
	@Test
	void testSliding2() {
		int[] nums = new int[] {0,1,7,4,4,6};
		
		int lower = 3;
		int upper = 6;
		
		
		int expected = 5;
		
		long actual = a.countFairPairsSLIDINGWINDOW(nums, lower, upper);
		
		assertEquals(expected,actual);
	}
	
	
	@Test
	void testSliding3() {
		int[] nums = new int[] {0,0,0};
		
		int lower = 0;
		int upper = 0;
		
		
		int expected = 3;
		
		long actual = a.countFairPairsSLIDINGWINDOW(nums, lower, upper);
		
		assertEquals(expected,actual);
	}
	
	@Test
	void testSliding4() {
		int[] nums = new int[] {1,7,9,2,5};
		
		int lower = 11;
		int upper = 11;
		
		
		int expected = 1;
		
		long actual = a.countFairPairsSLIDINGWINDOW(nums, lower, upper);
		
		assertEquals(expected,actual);
	}

}
