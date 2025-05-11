package may;

/* Minimum Equal Sum of Two Arrays After Replacing Zeros */
/* read the code only to find the logic */
public class MinimumEqualSumAfterReplacingZeroes {
	public long minSum(int[] nums1, int[] nums2) {
		long c1 = 0;
		long s1 = 0;
		long c2 = 0;
		long s2 = 0;

		for (long n : nums1) {
			if (n == 0) {
				c1++;
			}

			s1 += n;
		}

		for (long n : nums2) {
			if (n == 0) {
				c2++;
			}

			s2 += n;
		}

		// System.out.println("before count zero addition, s1 ="+s1+", s2="+s2+", c1
		// ="+c1+", c2 ="+c2);

		if (c1 == 0 && c2 == 0) {
			if (s1 == s2) {
				return s1;
			} else {
				return -1;
			}
		}

		s1 += c1;
		s2 += c2;

		// System.out.println("after, s1 ="+s1+", s2="+s2);

		if (c1 == 0) {
			if (s1 >= s2) {
				return s1;
			} else {
				return -1;
			}
		} else if (c2 == 0) {
			if (s2 >= s1) {
				return s2;
			} else {
				return -1;
			}
		}

		return Math.max(s1, s2);
	}
}
