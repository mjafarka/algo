package april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Count of Interesting Subarrays
 * 
 * notes in good notes ipad. also with techdose
 * 
 * check notes. "count of interesting subarrays (new thoughts)" in good notes
 */
public class CountInterestingSubArrays {
//	public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
//        long count = 0, equals = 0;
//        Map<Integer, Long> mpp = new HashMap<>();
//        mpp.put(0, 1L);
//        for (int i : nums) {
//            if (i % modulo == k) equals++;
//            int rem = (int)(equals % modulo);
//            int needed = (rem - k + modulo) % modulo;
//            count += mpp.getOrDefault(needed, 0L);
//            mpp.put(rem, mpp.getOrDefault(rem, 0L) + 1);
//        }
//        return count;
//    }
	
	/** 
	 * optimal
	 * @param nums
	 * @param modulo
	 * @param k
	 * @return
	 */
public long countInterestingSubarraysOptimal(List<Integer> nums, int modulo, int k) {
	
	
	Map<Integer,Integer> preCount = new HashMap<>();
	
	int pre = 0;
	
	long res = 0;
	preCount.put(0, 1); // if (pre - k) == 0, then 0 should there with count {0,1}
	
	for (int i : nums) {
		boolean valid = i % modulo == k;
		
		pre += valid ? 1 : 0;
		
		int rem = pre % modulo;
		
		int query = (rem - k + modulo) % modulo;
		
		res += preCount.getOrDefault(query, 0);
		
		preCount.put(rem, preCount.getOrDefault(rem, 0) + 1);
	}
	
	return res;
}
	
	
	/**
	 * brute force
	 * @param args
	 */
	
public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        

        int count = 0;
        for (int i = 0 ; i < nums.size() ; i++) {
            int cnt = 0;
            for (int j = i ; j < nums.size() ; j ++ ) {
                if (nums.get(j) % modulo == k) {
                    cnt ++;
                }

                if (cnt % modulo == k) 
                    count ++;
            }
        }

        return count;
    }
	public static void main(String[] args) {
		
		CountInterestingSubArrays a = new CountInterestingSubArrays();
		List<Integer> nums = new ArrayList<>(List.of(3,2,4));
		
		int modulo = 2;
		int k = 1;
		
		System.out.println(a.countInterestingSubarrays(nums, modulo, k));
	}
}
