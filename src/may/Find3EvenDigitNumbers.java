package may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find3EvenDigitNumbers {
	public int[] findEvenNumbers(int[] digits) {
		Map<Integer, Integer> countDigits = new HashMap<>();

		for (int d : digits) {
			countDigits.putIfAbsent(d, 0);
			countDigits.computeIfPresent(d, (k, v) -> v + 1);
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 100; i < 999; i++) {
			if (i % 2 == 0 && canMake(i, countDigits)) {
				result.add(i);
			}
		}

		int[] resArr = new int[result.size()];

		for (int i = 0; i < result.size(); i++) {
			resArr[i] = result.get(i);
		}

		return resArr;
	}

	private boolean canMake(int n, Map<Integer, Integer> digitCount) {

		int[] digits = new int[3];

		boolean made = true;

		for (int i = 2; i >= 0; i--) {
			digits[i] = n % 10;
			n /= 10;
		}

		for (int d : digits) {
			if (digitCount.containsKey(d)) {
				digitCount.put(d, digitCount.get(d) - 1);

				made &= digitCount.get(d) >= 0;
			} else {
				made = false;
			}

		}

		for (int d : digits) {
			if (digitCount.get(d) != null)
				digitCount.put(d, digitCount.get(d) + 1);

		}

		return made;

	}
}
