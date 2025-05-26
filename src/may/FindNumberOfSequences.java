package may;

import java.util.Arrays;

/* ab3214 
 * 
 * note in onenote search 'ab3214'
*/
public class FindNumberOfSequences {

	//tabulation
	private int findSeqTab(int point, int[] points) {
		int[] dp = new int[point+1];

		dp[0] = 1;

		for (int i = 0 ; i <= point ; i++) {
			for (int p : points) {
				if (i >= p)
					dp[i] += dp[i - p];
			}
		}

		return dp[point];
	}

	// recursive
	public int findSeq(int point) {
		int[] dp = new int[point+1];
		
		Arrays.fill(dp,-1);
		
		findComb(point,dp);
		
		return dp[point];
	}

	private int findComb(int point, int[] dp) {
		if (point == 0) {
			return 1;
		} else if (point < 0) {
			return 0;
		}
		
		if (dp[point] != -1) {
			return dp[point];
		}
		
		int[] nums = new int[] {2,3,7};
		
		int cnt = 0;
		for (int num : nums) {
			cnt += findComb(point-num,dp);
		}
		
		dp[point] = cnt;
		
		return cnt;
		
	}
	
	public static void main(String[] args) {
		FindNumberOfSequences f = new FindNumberOfSequences();
		
		System.out.println(f.findSeq(12));
		System.out.println(f.findSeqTab(12,new int[]{2,3,7}));
	}
}
