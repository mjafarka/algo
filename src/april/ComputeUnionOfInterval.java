package april;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval implements Comparable<Interval> {

	int strt;
	int end;
	char sEnd;
	char eEnd;

	public Interval(int strt, int end, char sEnd, char eEnd) {
		this.strt = strt;
		this.end = end;
		this.sEnd = sEnd;
		this.eEnd = eEnd;
	}

	@Override
	public int compareTo(Interval o) {
		if (strt == o.strt) {
			if (sEnd == 'O') return 1; 
			else return -1;
		}
		return Integer.compare(strt, o.strt);
	}
}

/**
 * my solution
 */
public class ComputeUnionOfInterval {

	
	/**
	 * my solution. which is working in my view. O(n)
	 * @param intervals
	 * @return
	 * 
	 * only merge if one of the end extending is open. their solution is not correctly legible
	 * 
	 */
	public List<Interval> computeUnionOfInterval(List<Interval> intervals) {

		Collections.sort(intervals);

		
		Interval first = intervals.get(0);
		int start = first.strt;
		int end = first.end;
		
		int maxOpen = 0;
		int maxClose = 0;
		
		if (first.eEnd == 'C') maxClose = Math.max(maxClose, first.end);
		else if (first.eEnd == 'O') maxOpen = Math.max(maxOpen, first.end);
		
		List<Interval> result = new ArrayList<>();
		for (Interval inter : intervals) {
			if (inter.sEnd == 'O' && (maxOpen >= inter.strt || maxClose >= inter.strt)) {
					
					if (inter.eEnd == 'C') maxClose = Math.max(maxClose, inter.end);
					else if (inter.eEnd == 'O') maxOpen = Math.max(inter.strt,Math.max(maxOpen, inter.end));
					
					end = Math.max(maxOpen, maxClose);
				
			} else if (inter.sEnd == 'C' && maxOpen >= inter.strt) {
					if (inter.eEnd == 'C') maxClose = Math.max(maxClose, inter.end);
					else if (inter.eEnd == 'O') maxOpen = Math.max(maxOpen, inter.end);
					
					end = Math.max(maxOpen, maxClose);
			} else {
				Interval merged = new Interval(start,end,'C','C');
				
				result.add(merged);
				start = inter.strt;
				end = inter.end;
				
				if (inter.eEnd == 'C') maxClose = Math.max(maxClose, inter.end);
				else if (inter.eEnd == 'O') maxOpen = Math.max(maxOpen, inter.end);
			}
		}
		
		
		result.add(new Interval(start,end,'C','C'));
		
		return result;
	}
	
	

	public static void main(String[] args) {
		ComputeUnionOfInterval cuoi = new ComputeUnionOfInterval();
		
		List<Interval> test = new ArrayList<>();
		
//		test.add(new Interval(0,3,'O','O'));
//		test.add(new Interval(1,1,'C','C'));
//		test.add(new Interval(2,4,'C','C'));
//		test.add(new Interval(3,4,'C','O'));
//		test.add(new Interval(5,7,'C','O'));
//		test.add(new Interval(7,8,'C','O'));
//		test.add(new Interval(8,11,'C','O'));
//		test.add(new Interval(9,11,'O','C'));
//		test.add(new Interval(12,16,'O','C'));
//		test.add(new Interval(12,14,'C','C'));
//		test.add(new Interval(13,15,'O','O'));
//		test.add(new Interval(16,17,'O','O'));
		
		
		test.add(new Interval(0,3,'O','C'));
		test.add(new Interval(3,4,'C','O'));
		
		
		List<Interval> result = cuoi.computeUnionOfInterval(test);
		
		System.out.println(result);
	}
}
