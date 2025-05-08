package may;

import java.util.Arrays;
import java.util.PriorityQueue;

/* Find Minimum Time to Reach Last Room II */
public class MinimumTimeToReachLastRoom {
	int[][] moveTime;
	int[][] visited;
	int n;
	int m;

	public int minTimeToReach(int[][] moveTime) {
		this.moveTime = moveTime;
		n = moveTime.length;
		m = moveTime[0].length;

		visited = new int[n][m];

		for (int[] v : visited) {
			Arrays.fill(v, Integer.MAX_VALUE);
		}

		PriorityQueue<int[]> minH = new PriorityQueue<int[]>((a, b) -> {
			if (a[2] == b[2]) {
				return Integer.compare(a[3], b[3]);
			} else {
				return Integer.compare(a[2], b[2]);
			}
		});

		minH.add(new int[] { 0, 0, 0, 1 });
		visited[0][0] = -1;

		while (minH.isEmpty() == false) {
			int[] curr = minH.poll();

			if (curr[0] == n - 1 && curr[1] == m - 1) {
				return curr[2];
			}

			int[] d = new int[] { -1, 0, 1, 0, -1 };

			for (int i = 0; i < 4; i++) {
				int dx = d[i];
				int dy = d[i + 1];

				int r = curr[0] + dx;
				int c = curr[1] + dy;

				if (r >= 0 && c >= 0 && r < n && c < m && visited[r][c] == Integer.MAX_VALUE) {
					visited[r][c] = -1;
					int newTime = Math.max(moveTime[r][c], curr[2]) + curr[3];
					int nextAdditionConstant = (curr[3] == 1 ? 2 : 1);
					minH.offer(new int[] { r, c, newTime, nextAdditionConstant });
				}
			}
		}

		return -1;
	}
}
