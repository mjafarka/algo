package elements.dp;

import java.util.Arrays;


// COUNT THE NUMBER OF WAYS TO TRAVERSE A 2D ARRAY
// variant 5
public class NumberOfMonotonics {

    public int countNumOfMonotonics(int k) {
        assert (k >= 1);
        int[][] dp = new int[k][10];

        for (int i = 0 ; i < 10 ; i ++) { // for k = 1, the answer would be 9, because each number is monotonic.
            dp[0][i] = 1;
        }

        for (int i = 1 ; i < k ; i ++ ) {

            for (int j = 1 ; j < 10 ; j ++) { // we take the sum of all boxes in the above row to the left, those number are the number's to 
                                            // which we can add the current number, which will give the count of number's which ends at current number which is monotonic, and 
                                            // having length blah blah blah.
                int count = 0;
                for (int d = 1 ; d < j ; d++ ) {
                    count += dp[i-1][d];
                }
                dp[i][j] = count;
            }
        }

        System.out.println(Arrays.deepToString(dp));

        int res = 0;

        for (int i = 1 ; i <= 9 ; i++) {
            res += dp[k-1][i];
        }

        return res;
    }

    // for checking my solution, which is written above.
    public static long monotoneCount(int k) {
        if (k < 1 || k > 9) {
            return 0; // No valid monotone number
        }
        return combination(9, k);
    }

    private static long combination(int n, int r) {
        if (r > n) return 0;
        long result = 1;
        for (int i = 1; i <= r; i++) {
            result = result * (n - i + 1) / i;
        }
        return result;
    }

    // public static void main(String[] args) {
    //     int k = 4; // Example input
    //     System.out.println("Number of monotone decimal numbers of length " + k + ": " + monotoneCount(k));
    // }

    public static void main(String[] args) {
        NumberOfMonotonics n = new NumberOfMonotonics();

        System.out.println(n.countNumOfMonotonics(4));
    }
    
}
