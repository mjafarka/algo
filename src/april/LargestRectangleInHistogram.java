package april;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
	
	// Largest Rectangle in Histogram
	
	// brute force approach
	public int largestRectangleArea(int[] heights) {
		
		
		int maxHeight = Arrays.stream(heights).max().getAsInt();
		
		int maxArea = 0;
		
		for (int i = 1 ; i <= maxHeight ; i ++) {
			
			
			int count = 0;
			for (int j = 0 ; j < heights.length ; j ++ ) {
				if (heights[j] < i) {
					count = 0;
				} else  {
					count ++;
					maxArea = Math.max(count * i, maxArea);
				}
			}
		}
		
		
		return maxArea;
	}

//	public Integer largestRectangleAreaEfficient(int[] heights) {
//		
//		
//		Stack<int[]> monotonic = new Stack<>();
//		
//		int maxArea = 0;
//		
//		for (int i = 0 ; i < heights.length;  i ++ ) {
//			int h = heights[i];
//			
//			if (monotonic.isEmpty() == true) {
//				maxArea = Math.max(h, maxArea);
//				monotonic.push(new int[] {h,i});
//				continue;
//			}
//			
//			while (monotonic.isEmpty() == false && monotonic.peek()[0] > h) {
//				int[] removed = monotonic.pop();
////				int n = i - removed[1] + 1;
//				
//				int prevInd = monotonic.isEmpty() == false ? monotonic.peek()[1] : 0;
//				
//				int currInd = removed[1];
//				
//				if (monotonic.isEmpty() == false && monotonic.peek() != null) {
//					monotonic.peek()[1] = currInd;
//				}
//				
//				maxArea = Math.max(maxArea, removed[0] * (currInd - prevInd));
//				
//			}
//			
//			monotonic.push(new int[] {h,i});
//			
////			if (monotonic.size() != 0) {
////				maxArea = Math.max(maxArea, monotonic.size() * h);
////			}
//			
//		}
//		
//		int len = heights.length;
//
//		
//		while (monotonic.isEmpty() == false) {
//			int[] curr = monotonic.pop();
//			maxArea = Math.max(curr[0]* (len - curr[1]) , maxArea);
//			len = curr[1] + 1;
//			
//		}
//		
//		return maxArea;
//	}
	
	/**
	 * efficient approach, using stack.
	 * @param heights
	 * @return
	 */

	
	public Integer largestRectangleAreaEfficient(int[] heights) { 
		int maxArea = 0;
		
		
		Stack<int[]> monoQ = new Stack<int[]>();
		
		
		for (int i = 0 ; i < heights.length ;i ++ ) {
			int h = heights[i];
			
			if (monoQ.isEmpty() == true ||  monoQ.peek()[0] < h) {
				monoQ.add(new int[] {h,i});
				continue;
			}
			
			
			// just adding calculation
			
			
			int lastRemovedIndex = i;
			
			while (monoQ.isEmpty() == false && monoQ.peek()[0] >= h)  {
				int[] prev = monoQ.pop();
				
				lastRemovedIndex = prev[1];
				
				maxArea = Math.max( prev[0] * (i - prev[1]) ,Math.max(maxArea, (i-prev[1] + 1) * h));
				
				
			}
			
			monoQ.push(new int[] {h,lastRemovedIndex});
		}
		
		int len = heights.length;
		
		while (monoQ.isEmpty() == false) {
			int[] last = monoQ.pop();
			
			maxArea = Math.max(maxArea, (len - last[1]) * last[0]);
		}
		
		return maxArea;
	}

}
