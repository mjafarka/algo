package april;

/**
 * NOTES : COUNT THE HIDDEN SEQUENCE (EXAMPLE) -> GOOD NOTES
 */
// Count the Hidden Sequences
public class CountTheHiddenSequences {
	
	
	public int numberOfArrays(int[] differences, int lower, int upper) {
		int min = 0, max = 0, curr = 0;

		for (int d : differences) {
			curr += d;
			min = Math.min(curr, min);
			max = Math.max(curr, max);

			if (max - min > upper - lower) {
				return 0;
			}
		}
		return (upper - lower) - (max - min) + 1;
	}
	
	public static void main(String[] args) {
		int[] diff = new int[] {1,-3,4};
		
		int l = 1;
		int u = 6;
		CountTheHiddenSequences c = new CountTheHiddenSequences();
		System.out.println(c.numberOfArrays(diff, l, u));
	}
}
