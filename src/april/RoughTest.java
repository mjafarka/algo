package april;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoughTest {

	Rough r = new Rough();

	@Test
	void test1() {

		int[] nums = new int[] { 2, 1, 4, 1, 1, 5 };

		int k = 10;

		long actual = r.countSubarrays(nums, k);
		
		long expected = 8;
		
		assertEquals(expected,actual);
	}
	
	@Test
	void test2() {

		int[] nums = new int[] {2,1,4,3,5};

		int k = 10;

		long actual = r.countSubarrays(nums, k);
		
		long expected = 6;
		
		assertEquals(expected,actual);
	}
	
	@Test
	void test3() {

		int[] nums = new int[] {1,1,1};

		int k = 5;

		long actual = r.countSubarrays(nums, k);
		
		long expected = 5;
		
		assertEquals(expected,actual);
	}
	
	

}
