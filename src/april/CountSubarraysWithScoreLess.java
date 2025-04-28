package april;

//Count Subarrays With Score Less Than K
public class CountSubarraysWithScoreLess {
	
	/**
	 * good notes - check it
	 * 
	 * Note that element i forms i - j + 1 valid subarrays. This is because 
	 * subarrays [j + 1, i], [j + 2, i] ... [i, i] are valid if subarray [j, i] 
	 * is valid.
	 * @param nums
	 * @param k
	 * @return
	 */
	public long countSubarrays(int[] nums, long k) {

		long sum = 0, res = 0;
		for (int i = 0, j = 0; i < nums.length; ++i) {
			sum += nums[i];
			while (sum * (i - j + 1) >= k)
				sum -= nums[j++];
			res += i - j + 1;
		}
		return res;
	}
}
