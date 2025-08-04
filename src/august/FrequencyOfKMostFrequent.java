package august;

import java.util.Arrays;

// Frequency of the Most Frequent Element 

// answer discription is in the sheet inself. (done by mysel. lool )
public class FrequencyOfKMostFrequent {
    

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int[] pSum = new int[nums.length+1];
        pSum[0] = 0;

        for (int i = 0 ; i < nums.length ; i++ ) {
            pSum[i+1] = pSum[i] + nums[i];
        }

        int ans = 1;

        // n
        for (int i = 1 ; i < nums.length ; i++ ) {
            int l = 0;
            int r = i - 1;

            // logn 
            while (l <= r) {
                int m = l + (r-l) / 2;


                if (canBeMadeEqual(nums,pSum,m,i,k)) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

            ans = Math.max(i-l + 1 , ans);
        }

        return ans;
    }

    private boolean canBeMadeEqual(int[] nums,int[] pSum,int lIdx,int rIdx, int k) {

        int size = rIdx - lIdx + 1;

        int sumOfElemReq = size * nums[rIdx];

        int currSumOfRange = pSum[rIdx+1] - pSum[(lIdx+1)-1];

        int diff = sumOfElemReq - currSumOfRange;

        if (diff <= k) {
            return true;
        } else {
            return false;
        }
    }
}
