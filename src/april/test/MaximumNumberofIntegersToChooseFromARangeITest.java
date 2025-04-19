package april.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import april.MaximumNumberofIntegersToChooseFromARangeI;

class MaximumNumberofIntegersToChooseFromARangeITest {

	
	MaximumNumberofIntegersToChooseFromARangeI m = new MaximumNumberofIntegersToChooseFromARangeI();
	@Test
	void test() {
		int[] nums = new int[] {1,6,5};
		
		int n = 5;
		
		int maxSum = 6;
		
		assertEquals(2,m.maxCount(nums, n, maxSum));
	}
	
	
	
	@Test
	void test1() {
		int[] nums = new int[] {1,2,3,4,5,6,7};
		
		int n = 8;
		
		int maxSum = 1;
		
		assertEquals(0,m.maxCount(nums, n, maxSum));
	}
	
	@Test
	void test2() {
		int[] nums = new int[] {11};
		
		int n = 7;
		
		int maxSum = 50;
		
		assertEquals(7,m.maxCount(nums, n, maxSum));
	}

}
