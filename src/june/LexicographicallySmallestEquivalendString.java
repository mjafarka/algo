package june;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


//Lexicographically Smallest Equivalent String

// check union find notes in onenote
public class LexicographicallySmallestEquivalendString {


    int[] parent;

    public String smallestEquivalentStringUnion(String s1, String s2, String baseStr) {
        parent = new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            int aIdx = a - 'a';
            int bIdx = b - 'a';

            System.out.println("aIdx=" + aIdx + ", bIdx=" + bIdx);
            union(aIdx, bIdx);
        }

        StringBuilder res = new StringBuilder();

        for (char c : baseStr.toCharArray()) {
            int par = find(c - 'a');

            res.append((char) (par + 'a'));
        }

        return res.toString();
    }

    private int find(int a) {

        if (parent[a] == a) {
            return a;
        } else {
            return find(parent[a]);
        }
    }

    private void union(int a, int b) {
        if (a < b) {
            int par = find(a);
            parent[b] = par;
        } else {
            int par = find(b);
            System.out.println("par=" + par + ", b= " + b);
            parent[a] = par;
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // create graph
        // for each

        Map<Character, Set<Character>> order = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            order.putIfAbsent(c, new HashSet<>());
        }

        int n = s1.length();

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            order.get(s1.charAt(i)).add(s2.charAt(i));
            order.get(s2.charAt(i)).add(s1.charAt(i));
        }

        // for (char cc : order.keySet()) {
        // System.out.println("key="+cc+",
        // order="+Arrays.toString(order.get(cc).toArray()));
        // }
        char[] minDict = new char[26];

        Arrays.fill(minDict, '-');

        for (int i = 0; i < 26; i++) {
            char cur = (char) (i + 'a');

            if (minDict[i] == '-') {
                Set<Character> visited = new HashSet<>();
                char minChar = findMin(order, cur, '-', visited);
                visited.clear();
                updateMin(cur, minChar, minDict, order, '-', visited);
            }
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < baseStr.length(); i++) {
            res.append(minDict[baseStr.charAt(i) - 'a']);
        }

        return res.toString();
    }

    private void updateMin(char cur, char min, char[] minDict, Map<Character, Set<Character>> order, char prev,
            Set<Character> visited) {
        minDict[cur - 'a'] = min;

        if (order.get(cur).size() == 0 || visited.contains(cur)) {
            return;
        }

        visited.add(cur);

        for (char nxt : order.get(cur)) {
            if (nxt != prev) {
                updateMin(nxt, min, minDict, order, cur, visited);
            }
        }
    }

    private char findMin(Map<Character, Set<Character>> order, char curr, char prev, Set<Character> visited) {
        if (order.get(curr).size() == 0 || visited.contains(curr))
            return curr;

        visited.add(curr);
        char min = curr;

        for (char nxt : order.get(curr)) {
            if (prev != nxt) {
                char minPoss = findMin(order, nxt, curr, visited);

                if (minPoss < min) {
                    min = minPoss;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        String a = "p";
        String b = "m";
        String c = "p";

        LexicographicallySmallestEquivalendString l = new LexicographicallySmallestEquivalendString();

        System.out.println(l.smallestEquivalentStringUnion(a, b, c));
    }
}
