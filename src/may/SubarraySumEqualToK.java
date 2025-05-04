package may;

import java.util.HashMap;
import java.util.Map;


/*
 * Subarray Sums Divisible by K
 * 
 * notes in goodnotes
 */
public class SubarraySumEqualToK {
	
	
	public int subarraysDivByK(int[] nums, int k) {
	    Map<Integer, Integer> count = new HashMap<>();
	    count.put(0, 1); // Base case: prefix sum 0 has occurred once

	    int preSum = 0;
	    int ret = 0;

	    for (int i = 0; i < nums.length; i++) {
	        preSum += nums[i];
	        int mod = ((preSum % k) + k) % k; // Ensure the modulo is non-negative

	        if (count.containsKey(mod)) {
	            ret += count.get(mod);
	        }

	        count.put(mod, count.getOrDefault(mod, 0) + 1);
	    }

	    return ret;
	}
    
    public static void main(String[] args) {
//		int[] nums = new int[] {1,1,1};
//		int k = 2;
		
		int[] nums = new int[] {1,2,3};
		int k = 3;
		
		SubarraySumEqualToK s = new SubarraySumEqualToK();
		
		System.out.println(s.subarraySum(nums, k));
	}
}
