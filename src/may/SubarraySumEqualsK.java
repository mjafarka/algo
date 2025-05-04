package may;

import java.util.HashMap;
import java.util.Map;

/*
 * Subarray Sum Equals K
 */
public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		int[] preSum = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			preSum[i] += nums[i];

			if (i > 0) {
				preSum[i] += preSum[i - 1];
			}
		}

		Map<Integer, Integer> preCount = new HashMap<>();

		preCount.put(0, 1);

		int ret = 0;
		for (int i = 0; i < preSum.length; i++) {
			int currPSum = preSum[i];

			if (preCount.get(currPSum - k) != null) {
				ret += preCount.get(currPSum - k);
			}

			preCount.put(currPSum, preCount.getOrDefault(currPSum, 0) + 1);
		}

		return ret;
	}
}
