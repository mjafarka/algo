package april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * 
 */
public class PathsInMazeThatLeadsToSameRoom {

	public int findConfusionScore(int n, int[][] corridor) {

		Map<Integer, Set<Integer>> fromTos = new HashMap<>();

		for (int[] corr : corridor) {
			fromTos.computeIfAbsent(corr[0], k -> new HashSet<>()).add(corr[1]);
		}

		int count = 0;

		for (int[] corr : corridor) {
			int from = corr[0];
			int to = corr[1];

			for (Integer toTo : fromTos.getOrDefault(to, new HashSet<>())) {
				if (fromTos.getOrDefault(toTo, new HashSet<>()).contains(from)) {
					count++;
				}
			}
		}

		return count / 3;
	}
	
	
	/**
	 * leetcode editorial, not understood.
	 * @param n
	 * @param corridors
	 * @return
	 */
	public int numberOfPaths(int n, int[][] corridors) {
        Set<Integer>[] g = new Set[n + 1];
        for (int i = 0; i <= n; ++i) {
            g[i] = new HashSet<>();
        }
        for (var c : corridors) {
            int a = c[0], b = c[1];
            g[a].add(b);
            g[b].add(a);
        }
        int ans = 0;
        for (int c = 1; c <= n; ++c) {
            var nxt = new ArrayList<>(g[c]);
            int m = nxt.size();
            for (int i = 0; i < m; ++i) {
                for (int j = i + 1; j < m; ++j) {
                    int a = nxt.get(i), b = nxt.get(j);
                    if (g[b].contains(a)) {
                        ++ans;
                    }
                }
            }
        }
        return ans / 3;
    }
}
