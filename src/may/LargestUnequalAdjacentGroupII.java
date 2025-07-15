package may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 2901. Longest Unequal Adjacent Groups Subsequence II 
 * 
 * onenote 
 * */

public class LargestUnequalAdjacentGroupII {

	// ------------------ dp solution ** recursion + memo below
	public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
		int n = groups.length;
		int[] dp = new int[n];
		int[] prev = new int[n];
		Arrays.fill(dp, 1);
		Arrays.fill(prev, -1);
		int maxIndex = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (check(words[i], words[j]) && dp[j] + 1 > dp[i] && groups[i] != groups[j]) {
					dp[i] = dp[j] + 1;
					prev[i] = j;
				}
			}
			if (dp[i] > dp[maxIndex]) {
				maxIndex = i;
			}
		}
		List<String> ans = new ArrayList<>();
		for (int i = maxIndex; i >= 0; i = prev[i]) {
			ans.add(words[i]);
		}
		Collections.reverse(ans);
		return ans;
	}

	private boolean check(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		int diff = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (++diff > 1) {
					return false;
				}
			}
		}
		return diff == 1;
	}

	// recursion + memo solution 

	/*
	 * time complexity
	 * 
	 * 	the solve function each word will be seen atmost twice, so time complexity of SOLVE is O(n);
	 * 
	 * this one will be called with different staring position so O(n) for that as well. 
	 * 
	 * checking two words will take O(L) time
	 * 
	 * so ttl time = O(n*n*L)
	 * 
	 * space complexity = O(n*n*L) ->
	 */

	private String[] words;
    private int[] groups;
    private int n;
    private Map<Integer, List<String>> memo;
    
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        this.words = words;
        this.groups = groups;
        this.n = n;
        this.memo = new HashMap<>();
        
        List<String> result = new ArrayList<>();
        
        // Try starting from each position and find the longest subsequence
        for (int i = 0; i < n; i++) {
            List<String> current = solve(i);
            if (current.size() > result.size()) {
                result = current;
            }
        }
        
        return result;
    }
    

    // Recursive function to find longest subsequence starting from index 'start'
    private List<String> solve(int start) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        
        List<String> result = new ArrayList<>();
        result.add(words[start]); // Include current word
        
        // Try all possible next positions
        for (int next = start + 1; next < n; next++) {
            if (canFollow(start, next)) {
                List<String> nextSubsequence = solve(next);
                
                // Create new subsequence by combining current + next
                List<String> combined = new ArrayList<>();
                combined.add(words[start]);
                combined.addAll(nextSubsequence);
                
                // Update result if this combination is longer
                if (combined.size() > result.size()) {
                    result = combined;
                }
            }
        }
        
        memo.put(start, result);
        return result;
    }
    
    // Check if word at index 'next' can follow word at index 'prev'
    private boolean canFollow(int prev, int next) {
        // Groups must be different
        if (groups[prev] == groups[next]) {
            return false;
        }
        
        // Words must have same length
        if (words[prev].length() != words[next].length()) {
            return false;
        }
        
        // Hamming distance must be exactly 1
        return hammingDistance(words[prev], words[next]) == 1;
    }
    
    // Calculate hamming distance between two strings of equal length
    private int hammingDistance(String s1, String s2) {
        int distance = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}
