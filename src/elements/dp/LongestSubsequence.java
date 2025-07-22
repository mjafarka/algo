package elements.dp;

// COMPUTE THE LEVENSHTEIN DISTANCE

// variant - 2
public class LongestSubsequence {
    public static String longestCommonSubsequence(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];

        // Build dp matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Backtrack to find the LCS string
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
                lcs.append(A.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString(); // Don't forget to reverse it!
    }

    public static void main(String[] args) {
        String A = "rhythm";
        String B = "rashism";
        String result = longestCommonSubsequence(A, B);
        System.out.println("Longest Common Subsequence: " + result);
    }
}
