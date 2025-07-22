package elements.dp;

import java.util.Arrays;


//  COMPUTE THE LEVENSHTEIN DISTANCE

// variant - 3

// check the tabular format also, which is given below
public class MinimumCharRemovalPalindrome {


    static int minimumCharacterToRemove(String A) {
        int i = 0;
        int j = A.length() -1;

        int[][] dp = new int[A.length()][A.length()];

        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));

        return minCharRemovalPali(A,i,j,dp);
    }

    static int minCharRemovalPali(String A, int i,int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (A.charAt(i) == A.charAt(j)) {
            return dp[i][j] =  minCharRemovalPali(A, i + 1, j- 1, dp);
        } else {
            return dp[i][j] =  1 +  Math.min(minCharRemovalPali(A, i + 1, j,dp),minCharRemovalPali(A, i, j-1,dp));
        }
    }

    // tabular format

    // to understand dry run using "abcb" as the input string.
    // dp[i][j] => number of character to remove, make substring from (i,j+1) a palindrome
    static int minimumCharacterRemovePaliTabular(String A) {
        int n = A.length();

        int[][] dp  = new int[n+1][n+1];

        for (int i = n - 2 ; i >= 0 ; i-- ) {
            for (int j = 1 ; j < n ; j++) {
                System.out.println("enetered loop");
                if (A.charAt(i) == A.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1]; // just contract the edges, excluding both character from the border.
                } else {
                    dp[i][j] = 1 + Math.min(dp[i+1][j],dp[i][j-1]); // move down to remove a char from left, move left to rmeove a character from right.
                }
            }
        }

        return dp[0][n-1];
    }

    // Example usage
    public static void main(String[] args) {
        String input = "ab";
        // int result = minimumCharacterToRemove(input);

        int result = minimumCharacterRemovePaliTabular(input);

        // Output: Should print 2 (remove 'b' and 'c' to get "ada")
        System.out.println("Minimum removals: " + result);
    }
}
