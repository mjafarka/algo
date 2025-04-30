package april;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


//Alien Dictionary

/**
 * tc = O(n+v+e)
 * n = total length of words
 * v = total unique characters
 * e = total edges
 */
public class AlienDictionary {
	public static String foreignDictionary(String[] words) {
		Map<Character, Set<Character>> gr = new HashMap<>();

		for (String word : words) {
			for (char c : word.toCharArray()) {
				gr.put(c, new HashSet<>());
			}
		}

		outer_loop: for (int i = 0; i < words.length - 1; i++) {
			String w1 = words[i];
			String w2 = words[i + 1];

			int j = 0;
			int k = 0;

			while (j < w1.length() && k < w2.length()) {
				if (w1.charAt(j) != w2.charAt(k)) {
					gr.get(w1.charAt(j)).add(w2.charAt(k));

					System.out.println(w1.charAt(j) + "->" + w2.charAt(k));
					continue outer_loop;
				}
				j++;
				k++;
			}

			if (w1.length() > w2.length()) {
				return "";
			}
		}

		Set<Character> visited = new HashSet<>();

		Set<Character> cycle = new HashSet<>();

		Stack<Character> st = new Stack<>();

		for (Character key : gr.keySet()) {
			
			System.out.println("from for loop="+key);
			if (!topoSort(key, gr, visited, cycle, st)) {
				return "";
			}

		}

		StringBuilder res = new StringBuilder();

		while (!st.isEmpty()) {
			res.append(st.pop());
		}

		return res.toString();
	}

	private static boolean topoSort(Character key, Map<Character, Set<Character>> gr, Set<Character> visited,
			Set<Character> cycle, Stack<Character> st) {
		if (cycle.contains(key)) {
			System.out.println("key="+key+" got in cycle");
			return false;
		} else if (visited.contains(key)) {
			return true;
		}

		visited.add(key);
		cycle.add(key);
		
		System.out.println("visited="+Arrays.toString(visited.toArray()));
		System.out.println("cycle="+Arrays.toString(cycle.toArray()));
		for (Character ch : gr.get(key)) {
			if (!topoSort(ch, gr, visited, cycle, st)) {
				return false;
			}
		}

		cycle.remove(key);
		
		System.out.println("cycle after removal="+Arrays.toString(cycle.toArray()));

		st.push(key);
		return true;
	}

	public static void main(String[] args) {

		String[] words = new String[] { "bcd", "ef", "kbe", "kbf" };

		System.out.println(foreignDictionary(words));

		String[] words1 = new String[] { "bcd", "ef", "kbef", "kbe" };

		System.out.println("\"" + foreignDictionary(words1) + "\""); // ""

		String[] words2 = new String[] { "bcd", "ef", "kbe", "kbb" };

		System.out.println("\"" + foreignDictionary(words2) + "\""); // ""

	}
}
