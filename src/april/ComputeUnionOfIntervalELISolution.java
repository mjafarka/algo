package april;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ComputeUnionOfIntervalELISolution {
public static class Interval implements Comparable<Interval> {
	public Endpoint left;
	public Endpoint right;
	
	public Interval(Endpoint left, Endpoint right) {
		this.left = left;
		this.right =right;
	}
	
	private static class Endpoint {
		
		public boolean isClosed;
		public int val;
		
		public Endpoint(boolean isClosed, int val) {
			this.isClosed = isClosed;
			this.val = val;
		}
		
	}
	
	public int compareTo(Interval i) {
		if (Integer.compare(left.val,i.left.val) != 0) {
			return left.val - i.left.val;
		}
		
		
		if (left.isClosed && !i.left.isClosed) {
			return -1;
		}
		
		if (!left.isClosed && i.left.isClosed) {
			return 1;
		}
		
		return 0;
	}
	
	public boolean equals(Object ob) {
		if (ob == null || ! (ob instanceof Interval)) {
			return false;
		}
		
		if (this == ob) {
			return true;
		}
		
		Interval that = (Interval) ob;
		
		return left.val == that.left.val && left.isClosed == that.left.isClosed;
	}
	
	public int hashCode() {
		return Objects.hash(left.val,left.isClosed);
	}
}

	public static List<Interval> unionOfIntervals(List<Interval> intervals) {
		if (intervals.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
		
		
		Collections.sort(intervals);
		
		Interval curr = intervals.get(0);
		
		List<Interval> result = new ArrayList<>();
		
		for (int i = 1 ; i < intervals.size();i ++ ) {
			if (intervals.get(i).left.val < curr.right.val ||
					(intervals.get(i).left.val == curr.right.val 
					&& (intervals.get(i).left.isClosed || curr.right.isClosed))) {
				if (intervals.get(i).right.val > curr.right.val ||
						(intervals.get(i).right.val == curr.right.val
						&& intervals.get(i).right.isClosed)) {
					curr.right = intervals.get(i).right;
				}
			} else {
				result.add(curr);
				curr = intervals.get(i);
			}
		}
		
		result.add(curr);
		
		return result;
	}
	
	public static void main(String[] args) {
List<Interval> test = new ArrayList<>();
		
		
		List<String> q = new ArrayList<>();
		
//		q.add("0,3,o,o");
//		q.add("1,1,c,c");
//		q.add("2,4,c,c");
//		q.add("3,4,c,o");
//		q.add("5,7,c,o");
//		q.add("7,8,c,o");
//		q.add("8,11,c,o");
//		q.add("9,11,o,c");
//		q.add("12,14,c,c");
//		q.add("12,16,o,c");
//		q.add("13,15,o,o");
//		q.add("16,17,o,o");
		
		
		
		q.add("0,3,o,c");
		q.add("4,5,0,o");
		
		
		
		List<Interval> intervals = new ArrayList<>();
		
		for (String s : q) {
			intervals.add(createInterval(s));
		}
		
		List<Interval> result = unionOfIntervals(intervals);
		
		
		System.out.println(result);
	}

	private static Interval createInterval(String s) {
		
		String[] vals = s.split(",");
		
		
		Interval.Endpoint st = new Interval.Endpoint(
				vals[2].equals("o") ? false : true
				, 
				
				Integer.parseInt(vals[0])); 
		
		Interval.Endpoint en = new Interval.Endpoint(
				vals[3].equals("o") ? false : true
				, 
				
				Integer.parseInt(vals[1])); 
		
		Interval curr = new Interval(st,en);
		
		return curr;
	}
}
