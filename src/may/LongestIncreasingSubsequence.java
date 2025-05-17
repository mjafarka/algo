package may;

import java.util.ArrayList;
import java.util.List;

/*
 * Longest Increasing Subsequence
 */
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		List<Integer> incrList = new ArrayList<>();

		int maxLen = 1;
		for (int num : nums) {
			if (incrList.size() == 0 || incrList.get(incrList.size() - 1) < num) {
				incrList.add(num);
				maxLen = Math.max(maxLen, incrList.size());
				continue;
			} else {
				insertAt(incrList, num);
			}
		}

		return maxLen;
	}

	private void insertAt(List<Integer> incrList, int num) {
		int l = 0;
		int r = incrList.size() - 1;

		while (l < r) {
			int m = l + (r - l) / 2;

			if (incrList.get(m) < num) {
				l = m + 1;
			} else {
				r = m;
			}
		}

		incrList.set(r, num);
	}
}
