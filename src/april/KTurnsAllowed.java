package april;

import java.util.Arrays;
import java.util.Stack;

public class KTurnsAllowed {

	/**
	 * my solution worked. but I missed to add direction also in the dp table, correct solution is below and geeks for geeks
	 * @param args
	 */
//    // static String[][] path;
//    static int[][] path;
//
//    static Stack<String> st;
//    public static int kTurnAround(int n, int m, int k) {
//        // path = new String[n][m];
//        path = new int[n][m];
//
//        st = new Stack<>();
//
//        int i = 0;
//
//        for (int[] p : path) {
//            for (int d = 0 ; d < p.length ; d ++ ){
//                p[d] = i;
//                i++;
//            }
//        }
//
//        
//        int[][][] dp = new int[n+1][m+1][k+1];
//        
//        for (int[][] d : dp ) {
//        	for (int[] s : d) {
//        		Arrays.fill(s,-1);
//        	}
//        }
//        System.out.println(Arrays.deepToString(path));
//        return kTurnsAround(0, 1, n, m, k, true,dp) + kTurnsAround(1, 0, n, m, k, false,dp);
//    }
//
//    private static int kTurnsAround(int i, int j, int n, int m, int k, boolean hori, int[][][] dp) {
//        if (i == n - 1 && j == m - 1 && k >= 0) {
//            System.out.println(st.toString());
//
//            System.out.println("k="+k+"\n\n");
//
//            return 1;
//        } else if (i == n || j == m || k < 0) {
//            return 0;
//        }  else if (dp[i][j][k] != -1) {
//        	return dp[i][j][k];
//        }
//
//        System.out.println("p="+path[i][j]+", k="+k+",  dir="+(hori ? " hori":" verti"));
//        st.push(path[i][j]+"");
//        int count = 0;
//        if (hori) {
//        	System.out.println("go same horizontaly");
//            count += kTurnsAround(i,j+1,n,m,k,hori,dp);
//            System.out.println("go different verically");
//            		count += kTurnsAround(i+1,j,n,m,k-1,!hori,dp);
//        } else {
//        	System.out.println("go same vertically");
//            count += kTurnsAround(i+1,j,n,m,k,hori,dp);
//            System.out.println("go different horizontally");
//            		count += kTurnsAround(i,j+1,n,m,k-1,!hori,dp);
//        }
//
//        System.out.println("d="+path[i][j]);
//        st.pop();
//        
//        dp[i][j][k] = count;
//        return count;
//    }
	
	static int[][][][] dp = new int[100][100][100][2];
	public static int kTurnAround(int n, int m, int k) {
		
		for (int[][][] s : dp) {
			for (int[][] e : s) {
				for (int[] p : e) {
					Arrays.fill(p, -1);
				}
			}
		}
		
		n--;
		m--;
		return countPathsUtil(n-1,m,k,1) + countPathsUtil(n,m-1,k,0);
	}
	
	static int countPathsUtil(int i, int j, int k, int d) 
	{ 
	    // If invalid row or column indexes 
	    if (i < 0 || j < 0) 
	        return 0; 
	 
	    // If current cell is top left itself 
	    if (i == 0 && j == 0) 
	        return 1; 
	 
	    // If 0 turns left 
	    if (k == 0) 
	    { 
	        // If direction is row, then we can reach here 
	        // only if direction is row and row is 0. 
	        if (d == 0 && i == 0) return 1; 
	 
	        // If direction is column, then we can reach here 
	        // only if direction is column and column is 0. 
	        if (d == 1 && j == 0) return 1; 
	 
	        return 0; 
	    } 
	 
	    // If this subproblem is already evaluated 
	    if (dp[i][j][k][d] != -1) 
	        return dp[i][j][k][d]; 
	 
	    // If current direction is row, 
	    // then count paths for two cases 
	    // 1) We reach here through previous row. 
	    // 2) We reach here through previous column, 
	    // so number of turns k reduce by 1. 
	    if (d == 0) 
	    return dp[i][j][k][d] = countPathsUtil(i, j - 1, k, d) + 
	                            countPathsUtil(i - 1, j, k - 1, d == 1 ? 0 : 1); 
	 
	    // Similar to above if direction is column 
	    return dp[i][j][k][d] = countPathsUtil(i - 1, j, k, d) + 
	                            countPathsUtil(i, j - 1, k - 1, d == 1 ? 0 : 1); 
	} 

	
	

    public static void main(String[] args) {
        

        // System.out.println(kTurnAround(3,3,2));
//         System.out.println(kTurnAround(4,5,3));

        System.out.println(kTurnAround(19,24,6));
        System.out.println(kTurnAround(14,13,21));

        System.out.println(kTurnAround(16,14,7));

        System.out.println(kTurnAround(11,24,25));
        System.out.println(kTurnAround(23,25,27));

    }
}
