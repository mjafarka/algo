package elements.dp;

//COMPUTE THE LEVENSHTEIN DISTANCE

// variant 1

// notes also included
public class LevenshteinDistance {
    
    public int levenshteinDistanceTabular(String A, String B) {

        if (A.length() < B.length()) {
            return levenshteinDistanceTabular(B, A);
        }

        int a = A.length();
        int b = B.length();

        // int[][] dp = new int[a+1][b+1];

        int[] prev = new int[b+1];
        int[] curr = new int[b+1];

        // a row wise, b column wise

        for (int i = 0 ; i < b + 1 ; i ++) {
            prev[i] = i;
        }

        for (int i = 1 ; i < a + 1 ; i++) {
            for (int j = 0 ; j < b + 1 ; j++) {
                
                if (j == 0) {curr[j] = i; continue;}


                if (A.charAt(i-1) == B.charAt(j-1)) {
                    // dp[i][j] = dp[i-1][j-1];
                    curr[j] = prev[j-1];
                } else {
                    // dp[i][j] = 1 + Math.min(
                    //     dp[i-1][j-1],            // substitution   --> su and sp , then replace u with p and then we have to find how many changes that happened to make the left prefix "p" and "P"
                    //     Math.min( dp[i-1][j],    // deletion       --> A = su and B = sp , doing deletion on A, after removing "u" from A, need to make "s" with "sp", just look at the top value in dp
                    //     dp[i][j-1])              // addition       --> A = s   and B = su,  i = 1 and j =2, after adding "u" to A it becomes "su". still i point to 1 (imaginary) and its value is "u". after adding, both end point matches with "u", so we need to find out how many edits where there before this "u", that is simply how many edits where required to make A = "s" and B = "s".
                    // );

                    curr[j] = 1 + Math.min(prev[j-1], Math.min(prev[j],curr[j-1]));
                }
            }

            prev = curr;
            curr = new int[b+1];
        }

        return prev[b];
    }

    public static void main(String[] args) {
        LevenshteinDistance l = new LevenshteinDistance();
        String a = "Carthorse";
        String b = "Orchestra";

        System.out.println(l.levenshteinDistanceTabular(a, b));
    }
}
