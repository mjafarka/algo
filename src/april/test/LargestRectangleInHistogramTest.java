package april.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import april.LargestRectangleInHistogram;
import utilities.BuildUtility;

class LargestRectangleInHistogramTest {

	LargestRectangleInHistogram lrih = new LargestRectangleInHistogram();

	@Test
	void testLargestRectangleArea() {

		int[] heights = new int[] { 2, 1, 5, 6, 2, 3 };

		int expected = 10;

		assertEquals(expected, lrih.largestRectangleArea(heights));
	}

	@Test
	void testLargestRectangleArea1() {

		int[] heights = new int[] { 2, 4 };

		int expected = 4;

		assertEquals(expected, lrih.largestRectangleArea(heights));
	}

	@Test
	void testLargestRectangleArea3() {
		System.out.println("Current directory: " + new File(".").getAbsolutePath());

		File myObj = new File("/home/jafar/Desktop/algoNew/algo/src/resources/testFileLargestRectangleInHistogram");

		try (Scanner reader = new Scanner(myObj);) {

			int[] heights = BuildUtility.createArrFromString(reader.nextLine());

			System.out.println(heights.length);

			int expected = 115596;

			assertEquals(expected, lrih.largestRectangleArea(heights));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int[] heights = new int[] { 2, 4 };

		int expected = 4;

		assertEquals(expected, lrih.largestRectangleArea(heights));
	}

	/**
	 * EFFICIENT TESTS
	 */

	@Test
	void testLargestRectangleArea10() {

		int[] heights = new int[] { 2, 1, 5, 6, 2, 3 };

		int expected = 10;

		assertEquals(expected, lrih.largestRectangleAreaEfficient(heights));
	}

	@Test
	void testLargestRectangleArea120() {

		int[] heights = new int[] { 2, 4 };

		int expected = 4;

		assertEquals(expected, lrih.largestRectangleAreaEfficient(heights));
	}

	@Test
	void testLargestRectangleArea31() {
		int[] heights = new int[] { 1, 2, 3, 3, 1, 2, 6 };

		int expected = lrih.largestRectangleArea(heights);
		
		System.out.println("expected"+expected);

//		assertEquals(lrih.largestRectangleAreaEfficient(heights),expected);
		assertEquals(expected,lrih.largestRectangleAreaEfficient(heights));
	}

	@Test
	void testLargestRectangleArea121() {

		int[] heights = new int[] { 2, 3 };

		int expected = 4;

		assertEquals(expected, lrih.largestRectangleAreaEfficient(heights));
	}

	@Test
	void testLargestRectangleArea30() {
		System.out.println("Current directory: " + new File(".").getAbsolutePath());

		File myObj = new File("/home/jafar/Desktop/algoNew/algo/src/resources/testFileLargestRectangleInHistogram");

		try (Scanner reader = new Scanner(myObj);) {

			int[] heights = BuildUtility.createArrFromString(reader.nextLine());

			System.out.println(heights.length);

			int expected = 115596;

			assertEquals(expected, lrih.largestRectangleAreaEfficient(heights));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int[] heights = new int[] { 2, 4 };

		int expected = 4;

		assertEquals(expected, lrih.largestRectangleArea(heights));
	}

}
