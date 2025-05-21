package may;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


/*
 * 
 *   Minimum Swaps to Sort by Digit Sum
 *   
 *   
 *   how sorting helps to get minimum number of swaps ?
 *   
 *   if we swap element which is in wrong position to its correct position
 *   there is a chance that the other element will come to its correct position.
 *   
 *   if the swapped "other" element is not actually put in correct position. 
 *   
 *   with a initial single swap we can't make 
 *   that number to the correct position. at least we need two. 
 *   
 *   SHORTLY :- we are doing the swaps which are absolutely necessary. not doing unwanted swaps.
 *   
 *   
 */
public class MinimumSwapsToSortDigitSum {
	public int minSwaps(int[] nums) {

		Map<Integer, Integer> numMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			numMap.put(nums[i], i);
		}

		Integer[] temp = Arrays.stream(nums).boxed().toArray(Integer[]::new);

		Arrays.sort(temp, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				int sa = sum(a);
				int sb = sum(b);

				if (sa == sb) {
					return Integer.compare(a, b);
				} else {
					return Integer.compare(sa, sb);
				}
			}
		});

		int swap = 0;

		for (int i = 0; i < nums.length; i++) {
			if (temp[i] != nums[i]) {
				int idx = numMap.get(temp[i]);

				int t = nums[idx];
				nums[idx] = nums[i];
				nums[i] = t;

				numMap.put(nums[i], i);
				numMap.put(nums[idx], idx);

				swap++;
			}
		}

		return swap;
	}

	private int sum(int num) {
		int s = 0;

		while (num != 0) {
			s += (num % 10);
			num /= 10;
		}

		return s;
	}
}
