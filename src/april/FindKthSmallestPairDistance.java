package april;

import java.util.Arrays;
import java.util.Random;


/**
 * used sliding window + binary search, 
 * Find K-th Smallest Pair Distance
 */
public class FindKthSmallestPairDistance {
	public int smallestDistancePair(int[] nums, int k) {
		Arrays.sort(nums);
		
		int l = 0;
		
		int max = Arrays.stream(nums).max().getAsInt();
		
		int min = Arrays.stream(nums).min().getAsInt();
		
		int r = max - min;
		
		int result = -1;
		while (l < r) {
			int m = l + (r - l) / 2;
			
			int count = findCountOfPairsSW(nums,m);
			
			if (count < k) {
				l = m + 1;
			} else {
				r  = m;
				result = m;
			}
		}
		
		return result == -1 ? r : result;
	}
	
	private int findCountOfPairsSW(int[] nums, int m) {
		
		int i = 0;
		int j = 1;
		
		int n = nums.length;
		
		int count = 0;
		while (j < n) {
			if (nums[j] - nums[i] <= m) {
				count += j - i;
				j ++;
			} else {
				i++;
			}
		}
		
		return count;
	}

	private int findCountOfPairs(int[] nums, int diff) {
		int l = 0;
		int r = nums.length - 1;
		
		int count = 0;
		
		
		for (int i = nums.length - 1 ; i >= 0 ; i--) {
			int minFirst = nums[i] - diff;
			
			
			int iminFirstIdx = 0;
			
			iminFirstIdx = findIdxGrterThanMin(nums,i,minFirst);
			
			count += i - iminFirstIdx;
		}
		
		return count;
	}

	private int findIdxGrterThanMin(int[] nums,int r, int minFirst) {
		
		int l = 0;
		
//		int r = r;
		
		
		while (l < r) {
			int  m = l + (r - l) / 2;
			
			if (nums[m] >= minFirst) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		
		return r;
	}
	

}
