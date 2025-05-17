package may;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjascentGroup2 {
	
	/*this will get time limit exceeded -> (2 ** n) */
	String[] words;
	int[] groups;
	List<String> res;
	int n;

	public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
		this.words = words;
		this.groups = groups;
		n = groups.length;

		res = new ArrayList<>();

		dfs(new ArrayList<String>(), 0, -1);
		
		return res;
	}

	private void dfs(List<String> arr , int ix,int grp) {
        if (ix == n) {
            if (arr.size() > res.size()) {
                res = new ArrayList<>(arr);
            }
            return;
        }

        if (arr.isEmpty() || valid(ix,arr,grp)) {
            arr.add(words[ix]);
            dfs(arr,ix+1,groups[ix]);

            arr.remove(arr.size()-1);
        }


        dfs(arr,ix+1,grp);


    }

	private boolean valid(int i, List<String> arr, int pGrp) {
		if (groups[i] == pGrp) {
			return false;
		} else if (!isHammingValid(arr.get(arr.size() - 1), words[i])) {
			return false;
		} else {
			return true;
		}
	}

	private boolean isHammingValid(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}

		int count = 0;
		for (int i = 0; i < a.length(); i++) {

			if (a.charAt(i) != b.charAt(i)) {
				count++;
			}
			if (count > 1) {
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"bab","dab","cab"};
		
		int[] groups = new int[] {1,2,2};
		
		LongestUnequalAdjascentGroup2 l = new LongestUnequalAdjascentGroup2();
		
		System.out.println(l.getWordsInLongestSubsequence(words, groups));
		
		
String[] words1 = {"a","b","c","d"};
		
		int[] groups1 = new int[] {1,2,3,4};
		
		System.out.println(l.getWordsInLongestSubsequence(words1, groups1));
	}
}
