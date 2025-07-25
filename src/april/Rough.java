package april;

import java.util.Arrays;

public class Rough {

    public int countWaysToReachScores(int a, int b) {
        int[][] dp = new int[a + 1][b + 1];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return countWaysToReachScores(a, b, dp);
    }

    public int countWaysToReachScores(int a, int b, int[][] dp) {
        if (a == 0 && b == 0) {
            return 1;
        } else if (a < 0 || b < 0) {
            return 0;
        }

        int cnt = countWaysToReachScores(a - 1, b, dp) + countWaysToReachScores(a, b - 1, dp);

        return cnt;
    }

    public int countWaysToReachScoresDP(int a, int b) {
        int[][] dp = new int[a + 1][b + 1];


        dp[0][0] = 1; // base case
        for (int i = 0; i < a + 1; i++) {

            for (int j = 0; j < b + 1; j++) {
                if (i > 0) {
                    dp[i][j] += dp[i-1][j];
                }  if (j > 0) {
                    dp[i][j] += dp[i][j-1];
                }
            }

        }

        return dp[a][b];
    }

    public static void main(String[] args) {

        Rough r = new Rough();

        System.out.println(r.countWaysToReachScoresDP(6, 3));
    }
}
