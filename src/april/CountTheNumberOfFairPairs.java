package april;

import java.util.Arrays;


/**
 * Count the Number of Fair Pairs
 * 
 * sliding window solution is at the bottom.
 * 
 * binary search solution is done by me.
 */
public class CountTheNumberOfFairPairs {
	
	/**
	 * time complexity = 2 * n logn 
	 * @param nums
	 * @param lower
	 * @param upper
	 * @return
	 */
	// --------------------- binary search starts -----------------------------------//
	public long countFairPairs(int[] nums, int lower, int upper) {
		
		
		Arrays.sort(nums);
		
		int count = 0;
		for (int i = 0 ; i < nums.length ; i ++ ) {
			int num = nums[i];
			
			int lowerIdx = findLowerIndex(i+1,nums.length -1, lower - num, nums);
			int upperIdx = findUpperIndex(i+1,nums.length -1 , upper - num, nums);
			
			if (lowerIdx == -1 || upperIdx == -1 || upperIdx < lowerIdx) {
				continue;
			}
			
			count += upperIdx - lowerIdx + 1;
			
		}
		
		return count;
	}
	
	/**
	 * find index 'k' which is just greater than target, not found then -1
	 * @param l
	 * @param r
	 * @param target
	 * @param nums
	 * @return
	 */
	private int findLowerIndex(int l, int r, int target, int[] nums) {
		
		
		while (l < r) {
			int m = l + (r - l) / 2;
			
			if (nums[m] >= target) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		
		return nums[r] >= target ? r : -1;
	}
	/**
	 * find index 'k' which is just less than or equal to target, not found return -1
	 * @param l
	 * @param r
	 * @param target
	 * @param nums
	 * @return
	 */
	private int findUpperIndex(int l, int r, int target, int[] nums) {
		
		int tempLeft = l;
		while (l <= r) {
			
			
			int m = l + (r-l) / 2;
			
			if (nums[m] > target) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		
		
		return (r < tempLeft || nums[r] > target) ? -1 : r;
	}
	
	// --------------------- binary search ends -----------------------------------//
	
	
	// --------------------- sliding window solution starts ----------------------//
public long countFairPairsSLIDINGWINDOW(int[] nums, int lower, int upper) {
		
		
		Arrays.sort(nums);
		return count(nums,upper) - count(nums,lower-1);
	}

	private long count(int[] nums, int t) {
		
		
		int left = 0;
		int right = nums.length - 1;
		
		int count = 0;
		while (left < right) {
			
			if (nums[left] + nums[right] > t) {
				right --;
			} else {
				count += right - left;
				left ++;
			}
		}

		
		return count;
	}
}
