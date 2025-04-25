package april;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


//Count Complete Subarrays in an Array
public class CountCompleteSubarraysInAnArray {
	
	public int countCompleteSubarrays(int[] nums) {

		Set<Integer> uniques = new HashSet<>();

		for (int num : nums) {
			uniques.add(num);
		}

		int U = uniques.size();

		// Set<Integer> currUnique = new HashSet<>();

		Map<Integer, Integer> currUnique = new HashMap<>();

		int i = 0;
		int j = 0;

		int count = 0;
		while (j < nums.length) {

			currUnique.put(nums[j], currUnique.getOrDefault(nums[j], 0) + 1);

			while (currUnique.size() == U) {
				count += nums.length - j;
				currUnique.put(nums[i], currUnique.get(nums[i]) - 1);

				if (currUnique.get(nums[i]) == 0) {
					currUnique.remove(nums[i]);
				}
				i++;
			}

			j++;
		}

		return count;
	}
}
