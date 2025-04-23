package april;

import java.util.ArrayList;
import java.util.Collections;


// Count Largest Group
public class CountLargestGroup {
	public int countLargestGroup(int n) {
		ArrayList<Integer> cnt = new ArrayList<>(Collections.nCopies(37, 0));// maximum possible value is 9999

		int maxLen = 0;
		for (int i = 1; i <= n; i++) {
			int c = dSum(i);

			cnt.set(c, cnt.get(c) + 1);

			maxLen = Math.max(maxLen, cnt.get(c));
		}

//		Collections.max(cnt);           one more trick
		return Collections.frequency(cnt, maxLen);
	}

	int dSum(int n) {

		int sum = 0;

		while (n != 0) {
			sum += n % 10;
			n /= 10;
		}

		return sum;
	}
}
