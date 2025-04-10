package april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumEventHeight {
	
	/**
	 * brute force approach time complexity = O(n*k) , n = size of events, k = avarage length of event
	 * @param events
	 * @return
	 */
	public int maximumEventHeightB(int[][] events) { 
		
		
		Map<Integer,Integer> eventAtTime = new HashMap<>();
		
		int maxEvent = 0;
		
		for (int[] event : events) {
			for (int i = event[0] + 1 ; i <= event[1] ; i ++ ) {
				eventAtTime.putIfAbsent(i,0);
				eventAtTime.put(i, eventAtTime.get(i) + 1);
				
				maxEvent = Math.max(eventAtTime.get(i), maxEvent);
			}
		}
		
		return maxEvent;
	}
	
	
	
	/**
	 * this won't work, because for a starting point
this will only consider how many finish points we have crossed, [[1,3][4,5][2,6]] => result = 3
	 * @param events
	 * @return
	 */
	public int maximumEventHeightC(int[][] events) {
		Arrays.sort(events, (a,b) -> a[1] - b[1]);
		
		int maxCount = 0;
		
		for (int i = 1 ;i < events.length ;i ++ ) {
			
			int currMax = howManyEndCrossed(events[i][0],i,events);
			
			maxCount = Math.max(maxCount, currMax);
		}
		
		return maxCount;
	}
	
	private int howManyEndCrossed(int strt, int i, int[][]events) {
		int l = 0;
		int r = i - 1;
		
		while ( l <= r) {
			int m = l + (r-l) / 2;
			
			if (events[m][1] > strt) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		
		return i - r;
	}
	
	
	/**
	 * brute force => for all the endpoint we will find out how many intervals that it includes.
	 * optimization => if more than one endpoint starts and no one ends, then the number of concurrent is 2
	 * @param events
	 * @return
	 */
	public int maximumEventHeightA(int[][] events) {
		Arrays.sort(events, (a,b) -> {
			return a[0] - b[0];
		});
		
		
		List<int[]> eventTimes = new ArrayList<>();
		
		for (int[] event : events) {
			int[] start = new int[] {event[0],1};//1 means start
			int[] end = new int[] {event[1],0};//0 means end
			

			eventTimes.add(start);
			eventTimes.add(end);
			
		}
		
		Collections.sort(eventTimes, (a,b) -> {
			return a[0] - b[0];
		});
		
		int concurrentCount = 0;
		
		int maxConcurrentEvent = 0;
		for (int[] ends : eventTimes) {
			if (ends[1] == 1) {
				concurrentCount ++;
			} else {
				concurrentCount --;
			}
			maxConcurrentEvent = Math.max(concurrentCount, maxConcurrentEvent);

		}
		
		
		return maxConcurrentEvent;
	}
	
	
	public static void main(String[] args) {
		MaximumEventHeight m = new MaximumEventHeight();
//		int[][] event = new int[][] {{0,3},{2,5},{1,4},{4,6},{7,10},{9,11},{3,4}};
		
		int[][] event = new int[][] {{1,3},{4,5},{2,6}};
		
		int[][] nEvent = new int[][] {{1,4},{2,5},{3,6},{5,7}};
		
		System.out.println(m.maximumEventHeightA(nEvent));
	}
}
