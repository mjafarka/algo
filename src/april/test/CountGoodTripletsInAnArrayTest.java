package april.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import april.CountGoodTripletsInAnArray;
import utilities.BuildUtility;

class CountGoodTripletsInAnArrayTest {

	CountGoodTripletsInAnArray c = new CountGoodTripletsInAnArray();
	@Test
	void test() {
		System.out.println("Current directory: " + new File(".").getAbsolutePath());

		File myObj = new File("/Users/muhammedjafarka/Desktop/algoUbu/algo/algo/src/resources/CountGoodTripletsInAnArrayTestCases");
//
		try (Scanner reader = new Scanner(myObj);) {

			int[] nums1 = BuildUtility.createArrFromString(reader.nextLine());
			
			int[] nums2 = BuildUtility.createArrFromString(reader.nextLine());

//			System.out.println(heights.length);

//			int expected = 115596;
			
			System.out.println(c.goodTriplets(nums1, nums2));

//			assertEquals(expected, lrih.largestRectangleArea(heights));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int[] heights = new int[] { 2, 4 };

		int expected = 4;

		assertEquals(1, 1);
	}

}
