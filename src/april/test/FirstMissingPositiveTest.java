package april.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import april.FirstMissingPositive;

class FirstMissingPositiveTest {

	
	FirstMissingPositive a = new FirstMissingPositive();
	@Test
	void test() {
		int[] nums = new int[] {1,2,0};
		
		assertEquals(3,a.firstMissingPositive(nums));
	}
	
	@Test
	void test1() {
		int[] nums = new int[] {3,4,-1,1};
		
		assertEquals(2,a.firstMissingPositive(nums));
	}
	
	
	@Test
	void test3() {
		int[] nums = new int[] {7,8,9,11,12};
		
		assertEquals(1,a.firstMissingPositive(nums));
	}

}
