package may;

import java.util.Arrays;

/**
 * Domino and Tromino Tiling
 * 
 * notes good notes
 */
public class DominoAndTrominoTililng {
	
	/* recursive solution */
	final long mod = 1000000007;

	public int numTilings(int n) {
		int[][] dp = new int[n + 1][2];

		for (int[] d : dp) {
			Arrays.fill(d, -1);
		}
		return (int) dominoes(0, n, false, dp);
	}

	private long dominoes(int i, int n, boolean possible, int[][] dp) {
		if (i == n)
			return possible ? 0 : 1;
		if (i > n)
			return 0;

		int possNum = possible ? 0 : 1;

		if (dp[i][possNum] != -1) {
			return dp[i][possNum];
		}

		if (possible) {
			dp[i][possNum] = (int) ((dominoes(i + 1, n, false, dp) + dominoes(i + 1, n, true, dp)) % mod);
		} else {
			dp[i][possNum] = (int) ((dominoes(i + 1, n, false, dp) + dominoes(i + 2, n, false, dp)
					+ 2 * dominoes(i + 2, n, true, dp)) % mod);
		}

		return dp[i][possNum];
	}
	
	//------------------------------------------------------------
		
	/* tabulation method */
	public int numTilingsTab(int n) {

        if (n <= 2) return n;
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        int[] preSum = new int[n+1];

        preSum[0] = 1;
        preSum[1] = 2;
        preSum[2] = 4;

        for (int i = 3; i <= n ; i++) {
            dp[i] =(int) ( (1L * dp[i-1] + 1L * dp[i-2] + 2L * preSum[i-3]) % mod);

            preSum[i] = (int) ((1L * preSum[i-1] + 1L * dp[i]) % mod);
        }

        return dp[n];

    }
	
}
