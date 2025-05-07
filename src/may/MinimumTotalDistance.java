package may;

import java.util.List;

public class MinimumTotalDistance {
	
	// get time limit exceeds. need to update
	public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
		return minTtlDistance(0, robot, factory, 0,0);
	}

	private long minTtlDistance(int r, List<Integer> robot, int[][] factory, long distance,int level) {
		if (r == robot.size() ) {
			return distance;
		} else if (distance < 0 || distance > Math.pow(10,9)) {
			return (long) Math.pow(10, 15);
		}
		
		System.out.println("r ="+r+",distance ="+distance+", level ="+level);

		Long minDistance = Long.MAX_VALUE;
		for (int i = 0; i < factory.length; i++) {
			int[] fact = factory[i];

			if (fact[1] > 0) { // limit is there
				factory[i][1]--;
				minDistance = Math.min(minDistance,
				minTtlDistance(r + 1, robot, factory, distance +  Math.abs(factory[i][0] - robot.get(r)),level+1));
				factory[i][1]++;
			}
		}

		return minDistance;
	}
}
