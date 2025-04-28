package april;

import java.util.Stack;

// Largest Rectangle in Histogram
public class MaximumAreaHistogram {
	/*
	 * short note on goodnotes
	 * solution from discussion.
	 */

	public static int largestRectangleArea(int[] heights) {
		int n = heights.length;
		int[] nextSmaller = nextSmallerElement(heights, n);
		int[] prevSmaller = prevSmallerElement(heights, n);

		int maxArea = 0;
		for (int i = 0; i < n; i++) {
			int width = nextSmaller[i] - prevSmaller[i] - 1;
			int area = width * heights[i];
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	public static int[] prevSmallerElement(int[] heights, int n) {
		Stack<Integer> stack = new Stack<>();
		int[] prevSmaller = new int[n];

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}
		return prevSmaller;
	}

	public static int[] nextSmallerElement(int[] heights, int n) {
		Stack<Integer> stack = new Stack<>();
		int[] nextSmaller = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
			stack.push(i);
		}
		return nextSmaller;
	}

}
