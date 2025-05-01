package may.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import may.MaximumNumberOfTaskAssign;
import utilities.BuildUtility;

class MaximumNumberOfTaskAssignTest {

	MaximumNumberOfTaskAssign a = new MaximumNumberOfTaskAssign();

	@Test
	void test() {
		System.out.println("Current directory: " + new File(".").getAbsolutePath());

		File myObj = new File("src/resources/taskAssign");
		
		
		int res = 0;
		try (Scanner reader = new Scanner(myObj);) {

			int[] task = BuildUtility.createArrFromString(reader.nextLine());
			
			int[] workers = BuildUtility.createArrFromString(reader.nextLine());

//			System.out.println(heights.length);

//			int expected = 115596;
			
			res = a.maxTaskAssign(task, workers, 98, 9370);

//			assertEquals(expected, lrih.largestRectangleArea(heights));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		

		assertEquals(86,res);
	}
}
