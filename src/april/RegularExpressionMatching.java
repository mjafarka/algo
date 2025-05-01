package april;

import java.util.Arrays;

//Regular Expression Matching


/**
 * check 'patter#123' in goodnotes to find why those lines are important
 * 
 * check out below isMatchDP solution as well.
 */
public class RegularExpressionMatching {
	
	public boolean isMatch(String text, String pattern) {
		int[][] dp = new int[text.length()][pattern.length()];
		
		for (int[] d : dp) {
			Arrays.fill(d, -1);;
		}
		
		return isMatch(text,0,pattern,0,dp);
	}
	private boolean isMatch(String text, int i, String pattern, int j, int[][] dp) {
		
		if (j == pattern.length()) {
			return i == text.length();//------------------------------------------------imp line
		}
		
		if (i < text.length() && dp[i][j] != -1) {
			return dp[i][j] == 1;
		}
		
		boolean res = false;
		boolean firstMatch = i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'); //------------------------------------------------imp line
		
		if (j < pattern.length() - 1 && pattern.charAt(j + 1) == '*') {
			res =  isMatch(text,i,pattern,j+2,dp) || firstMatch && isMatch(text,i+1,pattern,j,dp); 
		} else {
			res =  firstMatch && isMatch(text,i+1,pattern,j+1,dp);
		}
		if (i < text.length())
		dp[i][j] = res ? 1 : 0;
		
		return res;
	}
	
	/**
	 * good notes "is match dp"
	 * @param text
	 * @param pattern
	 * @return
	 */
	public boolean isMatchDP(String text, String pattern) {
	    int m = text.length();
	    int n = pattern.length();
	    boolean[][] dp = new boolean[m + 1][n + 1];

	    // Base case: empty text and empty pattern match
	    dp[m][n] = true;

	    // Fill the table from bottom to top, right to left
	    for (int i = m; i >= 0; i--) {
	        for (int j = n - 1; j >= 0; j--) {
	            boolean firstMatch = (i < m) && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.');

	            if (j + 1 < n && pattern.charAt(j + 1) == '*') {
	                dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
	            } else {
	                dp[i][j] = firstMatch && dp[i + 1][j + 1];
	            }
	        }
	    }

	    System.out.println(Arrays.deepToString(dp));

	    return dp[0][0];
	}
	
	public static void main(String[] args) {
		String a = "aa";
		String b = "a*";
		
		System.out.println();
	}
}
