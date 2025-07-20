package elements.dp;

import java.util.Arrays;

/**
 * 
 * COUNT THE NUMBER OF SCORE COMBINATIONS
 * 
 *  variant 4, counting the maximum number of lead changes.
 */
class MaximumLeadChangeTabular {
    private static final int[] SCORES = {2,3,7};
    private static final int NEG_INF = Integer.MIN_VALUE / 2;

    /**
     * Returns the maximum number of lead changes possible
     * to reach final scores (t1, t2).
     */
    public static int maxLeadChanges(int t1, int t2) {
        // dp[i][j][l]: best lead changes reaching (i,j) with leader l∈{0,1,2}
        int[][][] dp = new int[t1 + 1][t2 + 1][3];

        // Initialize
        for (int i = 0; i <= t1; i++) {
            for (int j = 0; j <= t2; j++) {
                Arrays.fill(dp[i][j], NEG_INF);
            }
        }
        dp[0][0][0] = 0;  // Start at tie with 0 changes

        // Fill table
        for (int i = 0; i <= t1; i++) {
            for (int j = 0; j <= t2; j++) {
                for (int l = 0; l < 3; l++) {
                    if (l == 0 && (j != 0 && i != 0)) continue; // when l == 0 , only the leader is 0, otherwise the leader would be either 1 or 2.
                    int base = dp[i][j][l];
                    if (base < 0 && !(i == 0 && j == 0 && l == 0)) continue; // base < 0, it is not visited yet. in that case only, l=0,j=0 and i =0 should enter.
                                                                             // other wise we can't reach upto this score combination, so we can't make further combinations.

                    // Team 1 scores g
                    for (int g : SCORES) {
                        int ni = i + g, nj = j;
                        if (ni > t1) continue;

                        int nl = computeLeader(ni, nj, l); // if there is a tie, the previous leader would be the leader, it will help to identify the lead change. 
                        int add = (l != 0  && nl != l) ? 1 : 0;
                        dp[ni][nj][nl] = Math.max(dp[ni][nj][nl], base + add);
                    }

                    // Team 2 scores g
                    for (int g : SCORES) {
                        int ni = i, nj = j + g;
                        if (nj > t2) continue;

                        int nl = computeLeader(ni, nj, l);
                        int add = (l != 0  && nl != l) ? 1 : 0;
                        dp[ni][nj][nl] = Math.max(dp[ni][nj][nl], base + add);
                    }
                }
            }
        }

        // Extract the best among all leader states at (t1, t2)
        return Math.max(dp[t1][t2][1], dp[t1][t2][2]);
    }

    // Determine leader: 0=tie, 1=Team1, 2=Team2
    private static int computeLeader(int p1, int p2, int prev) {
        if (p1 > p2)      return 1;
        else if (p2 > p1) return 2;
        else              return prev;  
    }

    public static void main(String[] args) {
        int t1 = 19, t2 = 8;
        int maxChanges = maxLeadChanges(t1, t2);
        System.out.println("Max lead changes: " + maxChanges);
    }
}
    
