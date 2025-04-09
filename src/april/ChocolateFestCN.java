package april;

import java.util.Arrays;
import java.util.Stack;

public class ChocolateFestCN {
	public static int largestRectangleArea(int[] heights) {
		int maxArea = 0;

		Stack<int[]> stack = new Stack<>();

		for (int i = 0; i < heights.length; i++) {

			int start = i;

			while (stack.isEmpty() == false && stack.peek()[1] > heights[i]) {
				int[] last = stack.pop();
				maxArea = Math.max(maxArea, last[1] * (i - last[0]));
				start = last[0];
			}

			stack.push(new int[] { start, heights[i] });
		}

		for (int i = 0; i < stack.size(); i++) {
			int[] last = stack.get(i);
			maxArea = Math.max(maxArea, last[1] * (heights.length - last[0]));
		}

		return maxArea;
	}

	public static void main(String[] args) {
		

		int[] heights = new int[] {2,3,2,5,6};
		
		
		System.out.println(largestRectangleArea(heights));
	}

}
