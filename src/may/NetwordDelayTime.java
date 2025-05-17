package may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


/* Network Delay Time */

/*
 * tc = O(Elog(E))
 * 
 * 
 * because in heap we can have duplicate elements, and we are not checking 
 * duplicates while adding element into the heap.
 */

public class NetwordDelayTime {
	public int networkDelayTime(int[][] times, int n, int k) {
		Map<Integer, List<int[]>> graph = new HashMap<>();

		for (int[] time : times) {
			graph.putIfAbsent(time[0], new ArrayList<>());
			// graph.computeIfPresent(time[0], (z,v) -> v.add(new int[]{time[1],time[2]}));
			graph.get(time[0]).add(new int[] { time[1], time[2] });
		}

		Set<Integer> visited = new HashSet<>();

		PriorityQueue<int[]> minTime = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

		minTime.add(new int[] { k, 0 });

		// visited.add(k);

		int maxTime = 0;

		while (minTime.isEmpty() == false) {
			int[] curr = minTime.poll();

			if (visited.contains(curr[0])) {
				continue;
			}

			visited.add(curr[0]);

			maxTime = Math.max(curr[1], maxTime);

			for (int[] c : graph.getOrDefault(curr[0], new ArrayList<>())) {
				if (visited.contains(c[0]) == false) {
					int newTime = curr[1] + c[1];
					minTime.add(new int[] { c[0], newTime });
				}
			}
		}

		return visited.size() < n ? -1 : maxTime;

	}
}
