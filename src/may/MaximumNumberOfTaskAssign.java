package may;

import java.util.Arrays;
import java.util.TreeMap;


/**
 * Maximum Number of Tasks You Can Assign
 * good notes
 */
public class MaximumNumberOfTaskAssign {
	public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
		int left = 0, right = Math.min(tasks.length, workers.length);
		Arrays.sort(tasks);
		Arrays.sort(workers);

		while (left < right) {
			int mid = (left + right + 1) / 2;
			System.out.println("mid ="+mid);
			int usedPills = 0;
			TreeMap<Integer, Integer> avail = new TreeMap<>();
			for (int i = workers.length - mid; i < workers.length; ++i)
				avail.put(workers[i], avail.getOrDefault(workers[i], 0) + 1);

			printMap(avail);
			boolean canAssign = true;
			for (int i = mid - 1; i >= 0; --i) {
				int t = tasks[i];
				int w = avail.lastKey();
				
				System.out.println("t="+t+", w="+w);
				if (w >= t) {
					decrement(avail, w);
					System.out.println("w="+w+">="+"t="+t);
				} else {
					System.out.println("do we have t-strength="+(t-strength));
					Integer key = avail.ceilingKey(t - strength);
					System.out.println("key="+key+"--"+((key == null) ? "no, so break" : "yes, so continue"));
					if (key == null || ++usedPills > pills) {
						canAssign = false;
						break;
					}
					decrement(avail, key);
				}
					
				printMap(avail);
			}

			if (canAssign)
				left = mid;
			else
				right = mid - 1;
		}

		return left;
	}

	private void printMap(TreeMap<Integer, Integer> avail) {
		
		System.out.println("avail Map");
		for (Integer key : avail.keySet()) {
			System.out.print("key:"+key+", count:"+avail.get(key)+", ");
		}
		System.out.println();
	}

	private void decrement(TreeMap<Integer, Integer> m, int k) {
		int c = m.get(k);
		if (c == 1)
			m.remove(k);
		else
			m.put(k, c - 1);
	}

	public static void main(String[] args) {
		MaximumNumberOfTaskAssign m = new MaximumNumberOfTaskAssign();
		
		int[] tasks = new int[] {3,2,1};
		int[] workers = new int[] {0,3,3};
		int pills = 1;
		int strength = 1;
		System.out.println(m.maxTaskAssign(tasks, workers, pills, strength));
		
		System.out.println("next ----------\n\n\n");

		
		test1();
		
		System.out.println("next test2 ----------\n\n\n");
		
		test2();

	}
	
	public static void test1() {
		MaximumNumberOfTaskAssign m = new MaximumNumberOfTaskAssign();

		int[] tasks = new int[] {3,2,1,9};
		int[] workers = new int[] {0,3,3,3};
		int pills = 1;
		int strength = 1;
		System.out.println(m.maxTaskAssign(tasks, workers, pills, strength));
	}
	
	public static void test2() {
		MaximumNumberOfTaskAssign m = new MaximumNumberOfTaskAssign();

		int[] tasks = new int[] {2,3};
		int[] workers = new int[] {2,1};
		int pills = 1;
		int strength = 2;
		System.out.println(m.maxTaskAssign(tasks, workers, pills, strength));
	}
	
}
