package april;

import java.util.Arrays;

public class Solution2 {
	static int findLongestFromACell(int i, int j, int[][] mat, int n, int[][] dp) {

		// Base case.
		if (i < 0 || i >= n || j < 0 || j >= n) {
			return 0;
		}

		/*
		 * Since all numbers are unique and in range from 1 to n*n, there is atmost one
		 * possible direction from any cell.
		 */
		
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		
		int maxLen = 1;
		if (j < n - 1 && ((mat[i][j] + 1) == mat[i][j + 1])) {
			maxLen =  1 + findLongestFromACell(i, j + 1, mat, n, dp);
		}

		if (j > 0 && ((mat[i][j] + 1) == mat[i][j - 1])) {
			maxLen = Math.max(maxLen, 1 + findLongestFromACell(i, j - 1, mat, n,dp ));
		}
		
		if (i < n - 1 && ((mat[i][j] + 1) == mat[i + 1][j])) {
			maxLen = Math.max(maxLen, 1 + findLongestFromACell(i + 1, j, mat, n, dp));
		}

		if (i > 0 && ((mat[i][j] + 1) == mat[i - 1][j])) {
			maxLen = Math.max(maxLen,  1 + findLongestFromACell(i - 1, j, mat, n, dp));
		}

		dp[i][j] = maxLen;

		// If none of the adjacent fours is one greater.
		return maxLen;
	}

	public static int findLongestOverAll(int[][] mat, int n) {

		// Initialize result.
		int result = 1;
		
		int[][] dp = new int[mat.length][mat[0].length];
		
		Arrays.stream(dp).forEach(k -> Arrays.fill(k, -1));

		// Compute longest path beginning from all cells.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int ans = findLongestFromACell(i, j, mat, n, dp);

				// Update result if needed.
				result = Math.max(result, ans);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] nums = new int[][] {{9,10,300},{8,100,200},{9,10,11}};
		
		System.out.println(findLongestOverAll(nums, 3));
	}
}
