package may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


//Minimum Total Distance Traveled
// notes in good notes
public class MinimumTotalDistance {

	// dp and non dp has the same  time complexity.
	// space non dp => O(n+k)
	// for dp => O(n*k)
	private List<Integer> robot;
	long[][] dp;
	private List<Integer> factList;

	public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
		Collections.sort(robot);
		Arrays.sort(factory, (a, b) -> a[0] - b[0]);

		List<Integer> factList = new ArrayList<Integer>();

		for (int[] fact : factory) {
			for (int i = 0; i < fact[1]; i++) {
				factList.add(fact[0]);
			}
		}
		this.robot = robot;
		this.factList = factList;
		f = new long[robot.size()][factory.length];

		dp = new long[robot.size() + 1][factList.size() + 1];

		for (long[] d : dp) {
			Arrays.fill(d, -1);

		}
		return dfs(0, 0);
	}

	private long dfs(int i, int j) {
		if (i == robot.size()) {
			return 0;
		}
		if (j >= factList.size()) {
			return (long) (Math.pow(10, 15) + 7);
		}
		// if (f[i][j] != 0) {
		// return (int) f[i][j];
		// }
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		long include = Long.MAX_VALUE;
		long notInclude = Long.MAX_VALUE;

		// if (factory[j][0] > 0) {
		// factory[j][0]--;
		include = Math.abs(robot.get(i) - factList.get(j)) + dfs(i + 1, j + 1);
		// factory[j][0]++;

		// }

		notInclude = dfs(i, j + 1);

		dp[i][j] = Math.min(include, notInclude);

		return dp[i][j];
	}
}
