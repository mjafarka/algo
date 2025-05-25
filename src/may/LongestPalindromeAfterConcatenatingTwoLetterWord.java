package may;

import java.util.HashMap;
import java.util.Map;

//Longest Palindrome by Concatenating Two Letter Words
public class LongestPalindromeAfterConcatenatingTwoLetterWord {
	public int longestPalindrome(String[] words) {
		Map<String, Integer> countWords = new HashMap<>();

		for (String s : words) {
			countWords.putIfAbsent(s, 0);

			countWords.put(s, countWords.get(s) + 1);
		}

		int res = 0;

		boolean centre = false;

		for (String k : countWords.keySet()) {
			int countA = countWords.get(k);
			int reverseCount = countWords.getOrDefault("" + k.charAt(1) + k.charAt(0), 0);

			if (k.charAt(0) == k.charAt(1)) {
				res += (countWords.get(k) / 2) * 4;

				if (countWords.get(k) % 2 == 1) {
					centre = true;
				}
			} else {
				res += Math.min(countA, reverseCount) * 2;
			}
		}

		if (centre) {
			res += 2;
		}

		return res;
	}
}
