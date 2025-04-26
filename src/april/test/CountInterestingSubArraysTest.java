package april.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import april.CountInterestingSubArrays;

class CountInterestingSubArraysTest {

	
	CountInterestingSubArrays a = new CountInterestingSubArrays();
	@Test
	void test() {
		List<Integer> nums = new ArrayList<>(List.of(3,1,9,6));
		int modulo = 3;
		
		int k = 0;
		
		assertEquals(2,a.countInterestingSubarraysOptimal(nums, modulo, k));
	}
	
	@Test
	void test1() {
		List<Integer> nums = new ArrayList<>(List.of(3,2,4));
		int modulo = 2;
		
		int k = 1;
		
		assertEquals(3,a.countInterestingSubarraysOptimal(nums, modulo, k));
	}

}
