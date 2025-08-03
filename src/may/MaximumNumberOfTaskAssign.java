package may;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.TreeMap;


/**
 * Maximum Number of Tasks You Can Assign
 * good notes
 * 
 * 
 * efficient approach with deque. at last
 * ^^^^ this one is commented and shown at the end.
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
	
	
	/**
	 * efficient approach to check the k task can be completed or not
	 * 
	 * goodnotes #123145
	 * @param tasks
	 * @param workers
	 * @param pills
	 * @param strength
	 * @param taskCount
	 * @return
	 */
	private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int taskCount) {
        Deque<Integer> boosted = new ArrayDeque<>();
        int w = workers.length - 1;
        int freePills = pills;

        for (int t = taskCount - 1; t >= 0; t--) {
            int task = tasks[t];

            if (!boosted.isEmpty() && boosted.peekFirst() >= task) {
                boosted.pollFirst();
            } else if (w >= 0 && workers[w] >= task) {
                w--;
            } else {
                while (w >= 0 && workers[w] + strength >= task) {
                    boosted.addLast(workers[w--]);
                }
                if (boosted.isEmpty() || freePills == 0) {
                    return false;
                }
                boosted.pollLast();
                freePills--;
            }
        }

        return true;
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


	/**
	 * 
	 * public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int l = 0;
        int r = tasks.length;

        while (l < r) {
            int m = l + (r-l) / 2;

            System.out.println("m="+m);
            if (canComplete(m,tasks,workers, pills, strength)) {
                System.out.println("canComplete");
                l = m + 1;
            } else {
                System.out.println("cannot complete");
                r = m;
            }

            System.out.println("next");
        }

        return r;
    }

    private boolean canComplete(int m, int[] tasks, int[] workers, int p, int s) {
        
      
        int i = m;
        int j =workers.length-1;

        Deque<Integer> dq = new ArrayDeque<>();
        while (i >= 0) {

            if (dq.isEmpty() == false && dq.peekLast() >= tasks[i]) {
                i --;
                dq.removeLast();
                continue;
            } else if (j >= 0 && workers[j] >= tasks[i]) {
                j --;
                i --;
            } else {

                while (j >= 0 && workers[j] + s >= tasks[i]) {
                    dq.addFirst(workers[j--]);
                }
                
                if (p > 0 && dq.size() > 0) {
                    i --;
                    p--;
                    dq.removeFirst();
                } else {
                    return false;
                }

            }
        }

        return true;
    }
	 */
	
}
