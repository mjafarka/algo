package april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterleavingString {
	 public boolean isInterleave(String s1, String s2, String s3) {
			
	        if (s1.length() + s2.length() != s3.length()) 
	            return false;
			// Map<String,Integer> dp = new HashMap<>();

	        int[][] dp = new int[s1.length()+1][s2.length()+1];

	        for (int[] d : dp) {
	            Arrays.fill(d,-1);
	        }
			StringBuilder sb = new StringBuilder();
			return isInterLeave(0,0,sb,s1,s2,s3,dp);
		}
		
		private boolean isInterLeave(int i, int j,StringBuilder sb, String s1, String s2, String s3,int[][] dp) {

	        if (sb.toString().equals(s3.substring(0,sb.length())) == false ) {
				return false;
			}
			if (i == s1.length() && j == s2.length()) {
				return true;
			}

	        // String key = i+"*"+j+"*"+sb.toString();

	        if (dp[i][j] != -1) {
	            return dp[i][j] ==1;
	        }
			
			
			
			
			if (i < s1.length()) {
				sb.append(s1.charAt(i));
				i++;
				if (isInterLeave(i,j,sb,s1,s2,s3,dp)) {
					dp[i][j] = 1;
	                return true;
				}
				sb.setLength(sb.length()- 1);
				i--;
			}
			
			if (j < s2.length()) {
				sb.append(s2.charAt(j));
				j++;
				if (isInterLeave(i,j,sb,s1,s2,s3,dp)) {
					dp[i][j] = 1;
	                return true;
				}
				sb.setLength(sb.length()-1);
				j--;
			}
			
	        // dp.put(key,0);

	        dp[i][j] = 0;

	        
			
			return false;
		}
	
	public static void main(String[] args) {
		String s1 = "acac";
		String s2 = "bb";
		
		String s3 = "abcabc";
		
		InterleavingString ils = new InterleavingString();
		
		System.out.println(ils.isInterleave(s1, s2, s3));
		
		List<Integer> a = new ArrayList<>();
		
		a.add(1);
		a.add(4);
		
		a.add(1, 2);
		
		System.out.println(Arrays.toString(a.toArray()));
	}
}
