package april.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import april.CountNumberOfGoodTripletsInAnArray;

class CountNumberOfGoodTripletsInAnArrayTest {

	CountNumberOfGoodTripletsInAnArray a = new CountNumberOfGoodTripletsInAnArray();
	@Test
	void test() {
		int[] nums1 = new int[] {2,0,1,3};
		
		int[] nums2 = new int[] {0,1,2,3};
		
		assertEquals(1,a.goodTriplets(nums1, nums2));
	}
	
	
	@Test
	void test1() {
		int[] nums1 = new int[] {4,0,1,3,2};
		
		int[] nums2 = new int[] {4,1,0,2,3};
		
		assertEquals(4,a.goodTriplets(nums1, nums2));
	}

}
