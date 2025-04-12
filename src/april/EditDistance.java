package april;

import java.util.Arrays;

public class EditDistance {
	
	/**
	 * brute force approach
	 */
	int count;
	public int minDistance(String word1, String word2) {
		count = Integer.MAX_VALUE;
		
		minDistance(0,word1.toCharArray(),0,word2.toCharArray(),0);
		
		return count == Integer.MAX_VALUE ? 1 : count;
    }
	
	private void minDistance(int i, char[] word1, int j, char[] word2, int curCount) {
		if (i == word1.length && j == word2.length) {
			count = Math.min(count, curCount);
			return;
		} else if (i == word1.length ) {
            count = Math.min(count,curCount + (word2.length - j));
			return;
		}
		
		
		if (j < word2.length && word1[i] == word2[j]) {
			minDistance(i+1,word1,j+1,word2,curCount);
		} else {
			//replace
			if (j < word2.length) {
			minDistance(i+1,word1,j+1,word2,curCount+1);
			//insert
            minDistance(i,word1,j+1,word2,curCount+1);}
			
			if (j <= word2.length)
			//remove
			minDistance(i+1,word1,j,word2,curCount+1);
            
		}
	}
	
//	with time optimized
	
//	int count;
	/**
	 * optimal approach for fixing.
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance2(String word1, String word2) {
//		count = Integer.MAX_VALUE;
		
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		
		for (int[] d : dp) {
			Arrays.fill(d, -1);
		}
		
		return minDistance2(0,word1.toCharArray(),0,word2.toCharArray(),0,dp);
		
//		return count == Integer.MAX_VALUE ? 1 : count;
    }
	
	private int minDistance2(int i, char[] word1, int j, char[] word2, int curCount, int[][] dp) {
		if (i == word1.length && j == word2.length) {
//			count = Math.min(count, curCount);
//			return;
			return 0;
		} else if (i == word1.length ) {
//            count = Math.min(count,curCount + (word2.length - j));
			return word2.length - j;
		}
		
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		
		int counter = Integer.MAX_VALUE - 10000;
		
		
		if (j < word2.length && word1[i] == word2[j]) {
			counter = Math.min(minDistance2(i+1,word1,j+1,word2,curCount,dp),counter);
		} else {
			//replace
			if (j < word2.length) {
				counter = Math.min(minDistance2(i+1,word1,j+1,word2,curCount+1,dp)+ 1,counter);
			//insert
				counter = Math.min(minDistance2(i,word1,j+1,word2,curCount+1,dp)+1,counter);
            }
			
			if (j <= word2.length)
			//remove
				counter = Math.min(minDistance2(i+1,word1,j,word2,curCount+1,dp)+1,counter);
            
		}
		
		dp[i][j] = counter;
		
		return counter;
	}

	
//	dinitrophenylhydrazine
//	acetylphenylhydrazine
	
	public static void main(String[] args) {
		String word1 = "sea";
		String word2 = "eat";
		EditDistance ed = new EditDistance();
		
		System.out.println(ed.minDistance2(word1, word2));
	}


}
