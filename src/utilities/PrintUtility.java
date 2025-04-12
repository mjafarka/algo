package utilities;

import java.util.Arrays;
import java.util.List;

public class PrintUtility {
	
	/**
	 * print out 2d list of Integer
	 * @param result , List<List<Object>>
	 */
	public void print2DList(List<List<Integer>> result) {
		for (List<Integer> ar : result) {
			System.out.println(Arrays.toString(ar.toArray()));
		}
	}
}
