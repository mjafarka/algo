package april;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsequetiveSequence {
//	Longest Consecutive Sequence

	/** 
	 * tc = O(n), because at most we are visited a number twice
	 * @param nums
	 * @return
	 */
	public int longestConsecutive(int[] nums) {

		Set<Integer> unique = Arrays.stream(nums).boxed().collect(Collectors.toSet());

		int max = 0;
		for (int num : nums) {
			if (unique.contains(num)) {
				int numl = num;
				unique.remove(num);
				while (unique.contains(numl - 1)) {
					unique.remove(numl - 1);
					numl--;
				}

				int numr = num;

				while (unique.contains(numr + 1)) {
					unique.remove(numr + 1);
					numr++;
				}

				max = Math.max(max, numr - numl + 1);
			}
		}

		return max;
	}
}
