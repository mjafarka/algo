package april.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import april.FindKthSmallestPairDistance;

class FindKthSmallestPairDistanceTest {

	
	FindKthSmallestPairDistance a = new FindKthSmallestPairDistance();
	@Test
	void test() {
		int[] nums = new int[] { 1,3,1};
		
		assertEquals(0,a.smallestDistancePair(nums, 1));
	}
	
	
	@Test
	void test1() {
		int[] nums = new int[] { 1,6,1};
		
		assertEquals(5,a.smallestDistancePair(nums, 3));
	}

	
	
	@Test
	void test2() {
		int[] nums = new int[] {62,100,4};
		
		assertEquals(58,a.smallestDistancePair(nums, 2));
	}
}
