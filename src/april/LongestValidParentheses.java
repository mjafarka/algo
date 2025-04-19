package april;

import java.util.Stack;

// Longest Valid Parentheses
public class LongestValidParentheses {
	
	/**
	 * wrong.
	 * @param s
	 * @return
	 */
	public int longestValidParenthesesWRONG(String s) {
		
		
		int lCount = 0;
		
		int longest = 0;
		
		int p = 0;
		for (int i = 0 ; i < s.length() ; i++ ) {
			
			
			if (s.charAt(i) == ')') {
				lCount --;

				if (lCount == 0) {
					longest = Math.max(i - p, longest);
//					p = i;
				}
				
				if (lCount < 0) {
					p = i;
					lCount = 0;
					
				}
			} else {
				lCount += 1;
			}
		}
		
		if (lCount == 0) {
			longest = Math.max(s.length() - p - 1, longest);
		}
		
		return longest;
	}
	
	
public int longestValidParenthesesCORRECT(String s) {

	// 2 ---------> (
	// 3 ---------> )
	Stack<int[]> st = new Stack<>();
	
	st.push(new int[] {3,-1});
	
	int longest = 0;
	for (int i = 0 ; i< s.length() ; i++ ) {
		if (s.charAt(i) == ')') {
			if (st.peek()[0] == 3) {
				st.push(new int[] {3,i});
			} else {
				st.pop();
				longest = Math.max(longest, i - st.peek()[1]);
			}
		} else {
			st.push(new int[] {2,i});
		}
	}
	
	return longest;
}
	
}
