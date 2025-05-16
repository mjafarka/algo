package may;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TotalCharacterInStringTransformation2Test {

	TotalCharacterInStringTransformation2 a = new TotalCharacterInStringTransformation2();

	@Test
	void test() {
		String s = "abcyy";
		int t = 2;
		List<Integer> nums = new ArrayList<>(
				List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2));

		long actual = a.lengthAfterTransformations(s, t, nums);

		long expected = 7;

		assertEquals(expected, actual);
	}

	@Test
	void test1() {
		String s = "azbk";
		int t = 1;
		List<Integer> nums = new ArrayList<>(
				List.of(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2));

		long actual = a.lengthAfterTransformations(s, t, nums);

		long expected = 8;

		assertEquals(expected, actual);
	}
	
	@Test
	void test3() {
		String s = "k";
		int t = 1;
		List<Integer> nums = new ArrayList<>(
				List.of(2,2,1,3,1,1,2,3,3,2,1,2,2,1,1,3,1,2,2,1,3,3,3,2,2,1));

		
		System.out.println("index of k="+('k'-'a'));
		long actual = a.lengthAfterTransformations(s, t, nums);

		long expected = 2;

		assertEquals(expected, actual);
	}

}
