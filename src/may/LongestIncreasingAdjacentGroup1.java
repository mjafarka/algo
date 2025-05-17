package may;

import java.util.ArrayList;
import java.util.List;


/*
 * Longest Unequal Adjacent Groups Subsequence I
 */
public class LongestIncreasingAdjacentGroup1 {
	public List<String> getLongestSubsequence(String[] words, int[] groups) {
		int maxLen = 1;
		int prev = groups[0];

		List<String> res = new ArrayList<>();
		res.add(words[0]);

		for (int i = 1; i < groups.length; i++) {
			if (prev != groups[i]) {
				// maxLen ++;
				prev = groups[i];
				res.add(words[i]);
			}
		}

		return res;
	}
}
