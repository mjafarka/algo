package elements.dp;

import java.util.Arrays;

// COMPUTE THE LEVENSHTEIN DISTANCE

// variant - 5

public class InterleavingStrings {
    public boolean isInterleaving(String s1, String s2, String t) {

        int[][] dp = new int[s1.length()][s2.length()];

        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));

        if (t.length() != s1.length() + s2.length()) return false;

        return checkIsInterleaving(0,0,0,s1,s2,t, dp);
    }


    public boolean checkIsInterleaving(int i1, int i2, int i3, String s1, String s2, String t, int[][] dp) {

        if (i1 == s1.length()) {
            return s2.substring(i2,s2.length()).equals(t.substring(i3,t.length()));
        } else if (i2 == s2.length()) {
            return s1.substring(i1,s1.length()).equals(t.substring(i3, t.length()));
        } 

        if (dp[i1][i2] != -1) {
            return dp[i1][i2] == 1;
        }

        boolean res = false;

        if (s1.charAt(i1) == t.charAt(i3) && s2.charAt(i2) == t.charAt(i3)) {
            res = checkIsInterleaving(i1 + 1, i2, i3 + 1, s1, s2, t, dp) || checkIsInterleaving(i1, i2 + 1, i3 + 1, s1, s2, t,dp);
        } else if (s1.charAt(i1) == t.charAt(i3)) {
            res =  checkIsInterleaving(i1 + 1, i2, i3 + 1, s1, s2, t, dp);
        } else if (s2.charAt(i2) == t.charAt(i3)) {
            res = checkIsInterleaving(i1, i2 + 1, i3 + 1, s1, s2, t, dp);
        }

        dp[i1][i2] = res ? 1 : 0;
        return dp[i1][i2] == 1;
    }

    public boolean checkIsInterleavingTabular(String s1, String s2, String t) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        // bottom up right, from bottom to top

        int n1 = s1.length(), n2 = s2.length();

        /*
         *  IMPORTANT
         * what is dp[i][j]
         *  sub1 = substring from i -> end for the string s1
         *  sub2 = substring  from j -> end for the string s2
         *  
         * if these two substring can be made, from the string t's last part having length equals to sub1.length() + sub2.length()
         *  ab <- sub1
         *  ^
         *  ab <- sub2
         *  ^
         *  
         *  abba <- t
         *  ^
         *  
         *  can you make "abba" from the sub1 and sub2 ? that is what dp[i][j] means
         * 
         * t's index can be found by just adding i + j
         */

        for (int i = n1 ; i >= 0 ; i -- ) {
            for (int j = n2 ; j >= 0 ; j -- ) {
                if (i == n1 && j == n2) { /** no string left in both s1 and s2, so that would be interleaving */
                    dp[i][j] = 1;
                }
                if (i == n1) { /** s1 is ended, check if the remaining part of s2 is same as the remaining in t */
                    String sub = s2.substring(j,s2.length());
                    dp[i][j] = sub.equals(t.substring(t.length()-sub.length(),t.length())) == true ? 1 : 0;
                    continue;
                } else if ( j == n2) { /** doing the same as the above "if", checking the remaining */
                    String sub = s1.substring(i,s1.length());
                    dp[i][j] = sub.equals(t.substring(t.length()-sub.length(),t.length())) == true ? 1 : 0;
                    continue;
                }

                if (s1.charAt(i) == t.charAt(i+j) && s2.charAt(j) == t.charAt(i+j)) { /**
                    if current character from s1 or s2 matches with the next required character for t, try with the both cases */
                    dp[i][j] = (dp[i+1][j] == 1 || dp[i][j+1] == 1) ? 1 : 0;
                } else if ( s1.charAt(i) == t.charAt(i+j)) { /* 
                    if s1 character only matches with the required character of t, then take the next character from s1 only */
                    dp[i][j] = dp[i+1][j];
                } else if (s2.charAt(j) == t.charAt(i+j)) { /*
                    like the previous else if */
                    dp[i][j] = dp[i][j+1];
                }
            }
        }

        return dp[0][0] == 1;
    }

    public static void main(String[] args) {
        String a = "gtaa";
        String b = "atc";
        String t = "gattaca";

        InterleavingStrings k  = new InterleavingStrings();

        System.out.println(k.checkIsInterleavingTabular(a, b, t));


    }

}
