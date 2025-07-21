package elements.dp;

import java.util.Arrays;

import LLD.parkinglot.main;

public class ClimbingStairs {
    // k -> (1 -> k different types of step I can take)
    // n -> means the destination

    public int countDifferentWayClimbing(int k,int n) {
        int[] dp = new int[n+1];

        dp[0] = 1;

        /**
         * 5 -> position and you can take 2 or 3 as steps
         * 
         * 2 , 3 
         *  or 
         * 
         * 3 , 2 
         * 
         * as the differnt steps. so there is two ways to do that.
         */

        for (int dest = 1 ;  dest < n + 1 ; dest ++) {
            for (int jump = 1 ; jump < k + 1 ; jump ++) {
                if (dest - jump >= 0) {
                    dp[dest] += dp[dest - jump];
                }
            }
        }

        System.out.println("dp ="+ Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        int n = 4;
        int k = 2;

        System.out.println(c.countDifferentWayClimbing(k, n));
    }
}
