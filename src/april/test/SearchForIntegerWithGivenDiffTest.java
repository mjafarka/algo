package april.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import april.SearchForIntegerWithGivenDiff;

class SearchForIntegerWithGivenDiffTest {

	
	SearchForIntegerWithGivenDiff a = new SearchForIntegerWithGivenDiff();
	@Test
	void test1() {
		ArrayList<Integer> nums = new ArrayList<>(List.of(2,5,6,7));
		
		int k = 1;
		int m = 2;
		
		ArrayList<Integer> res = SearchForIntegerWithGivenDiff.indicesAtGivenDistance(nums, 4, k, m);

		
		boolean isCorrect = false;
		
		if (res.size() == 0 || res.get(0) == -1) {
			isCorrect = false;
		} else {
			if (Math.abs(res.get(0)-res.get(1)) > k || Math.abs(nums.get(res.get(0)) - nums.get(res.get(1))) > m) {
				isCorrect = false;
			} else {
				isCorrect = true;
			}
		}
		
	assertEquals(true, isCorrect);
				
	}
	
	@Test
	void test2() {
		ArrayList<Integer> nums = new ArrayList<>(List.of(2,3,4));
		
		int k = 2;
		int m = 2;
		
		ArrayList<Integer> res = SearchForIntegerWithGivenDiff.indicesAtGivenDistance(nums, 3, k, m);

		
		boolean isCorrect = false;
		
		if (res.size() == 0 || res.get(0) == -1) {
			isCorrect = false;
		} else {
			if (Math.abs(res.get(0)-res.get(1)) > k || Math.abs(nums.get(res.get(0)) - nums.get(res.get(1))) > m) {
				isCorrect = false;
			} else {
				isCorrect = true;
			}
		}
		
	assertEquals(true, isCorrect);
				
	}

	
	
	@Test
	void test3() {
		ArrayList<Integer> nums = new ArrayList<>(List.of(28, 27, 33, 6, 23, 3, 7, 18, 10, 12, 39, 44, 42, 25, 48
));
		
		int k = 5;
		int m = 13;
		
		ArrayList<Integer> res = SearchForIntegerWithGivenDiff.indicesAtGivenDistance(nums, 15, 5, 13);

		
		boolean isCorrect = false;
		
		if (res.size() == 0 || res.get(0) == -1) {
			isCorrect = false;
		} else {
			if (Math.abs(res.get(0)-res.get(1)) > k || Math.abs(nums.get(res.get(0)) - nums.get(res.get(1))) > m) {
				isCorrect = false;
			} else {
				isCorrect = true;
			}
		}
		
	assertEquals(true, isCorrect);
				
	}

}
