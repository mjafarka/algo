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
 * don't look at 
 * 
 * COMPUTE THE UNION OF INTERVALS
 */
public class ComputeUnionOfInterval {

	// check solution in onenote
}
