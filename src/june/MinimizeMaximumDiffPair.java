package june;

import java.util.Arrays;


//Minimize the Maximum Difference of Pairs
//onenote
public class MinimizeMaximumDiffPair {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int low = 0;
        int high = (int) Math.pow(10,9);

        while (low < high) {
            int m = low + (high - low) / 2;

            
            int pairCount = countLessThanMPair(nums,m);
            // System.out.println("m="+m+", count="+pairCount);
            // System.out.println("low="+low+", high="+high);

            if (pairCount >= p) {
                // res = m;
                high = m;
            } else {
                low = m + 1;
            }
        }

        return high;
    }

    private int countLessThanMPair(int[] nums ,int p) {

        int i = 1;
        int c = 0;
        while (i < nums.length) {
            if (Math.abs(nums[i-1]-nums[i]) <= p) {
                c ++;
                i+=2;
            } else {
                i+=1;
            }
        }

        return c;
    }
}
