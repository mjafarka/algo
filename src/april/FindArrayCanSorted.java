package april;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FindArrayCanSorted {

	/**
	 * this one is time consuming O(n*n)
	 * 
	 * @param nums
	 * @return
	 */
	public boolean canSortArray(int[] nums) {

		Map<Integer, Integer> countBits = new HashMap<>();

		for (int num : nums) {
			countBits.computeIfAbsent(num, k -> countBits(k));
		}

		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (nums[j] > nums[j + 1] && countBits.get(nums[j]).equals(countBits.get(nums[j + 1]))) {
					swap(j, j + 1, nums);
				}
			}
		}

		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] > nums[i]) {
				return false;
			}
		}

		return true;
	}

	private void swap(int i, int j, int[] nums) {

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

	private Integer countBits(Integer k) {

		int count = 0;
		while (k != 0) {
			int x = k - 1;

			k &= x;
			count++;
		}

		return count;
	}

	
	/**
	 * O(n) method. final. 
	 * for each segment find out the maximum number, and compare the next segment's smallest value with the previous 
	 * segments largest value. if they are not sorted then return false.
	 * @param nums
	 * @return
	 */
	private boolean canSortArrayA(int[] nums) {
		int prevMax = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {

			int count = countBits(nums[i]);

			int currMin = nums[i];
			int currMax = nums[i];

			while (i + 1 < nums.length && countBits(nums[i + 1]) == count) {
				currMin = Math.min(currMin, nums[i + 1]);
				currMax = Math.max(currMax, nums[i + 1]);
				i++;
			}

			if (prevMax > currMin) {
				return false;
			}

			prevMax = Math.max(currMax, prevMax);
		}

		return true;

	}

	public static void main(String[] args) {
		int[] q = new int[] { 8, 4, 1, 10, 11 };

		FindArrayCanSorted fac = new FindArrayCanSorted();
		System.out.println(fac.canSortArrayA(q));
	}
}
