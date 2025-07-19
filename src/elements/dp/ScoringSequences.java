package elements.dp;


// COUNT THE NUMBER OF SCORE COMBINATIONS

// variant - 3

// create a new method and work out here your solution and check the sample test cases works or not
public class ScoringSequences {
    public static int countWays(int target1, int target2) {
        int[] scores = {2, 3, 7};
        int[][] dp = new int[target1 + 1][target2 + 1];
        dp[0][0] = 1;

        for (int i = 0; i <= target1; i++) {
            for (int j = 0; j <= target2; j++) {
                if (dp[i][j] == 0) continue; // this score compo is not reacheable, so next sequence can't be computed from here

                for (int s : scores) {
                    if (i + s <= target1) {
                        dp[i + s][j] += dp[i][j]; // Player 1 scores
                    }
                    if (j + s <= target2) {
                        dp[i][j + s] += dp[i][j]; // Player 2 scores
                    }
                }
            }
        }

        return dp[target1][target2];
    }

    public static void main(String[] args) {
        int target1 = 6;
        int target2 = 3;
        System.out.println("Total number of scoring sequences: " + countWays(target1, target2)); // should print 7

        // int target1 = 4;
        // int target2 = 3;
        // System.out.println("Total number of scoring sequences: " + countWays(target1, target2)); // should print 3

        // int target1 = 5;
        // int target2 = 3;
        // System.out.println("Total number of scoring sequences: " + countWays(target1, target2)); // should print 6
    }
}
