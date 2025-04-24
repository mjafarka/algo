package april;

//Count the Number of Ideal Arrays
public class CountTheNumberOfIdealArray {
	private static final int MOD = (int) 1e9 + 7;
	private long[][] count;
	private long[][] prefixSum;
	private long[] options;

	private void countUniqueSequences(int curr, int idx, int maxValue) {
		options[idx]++;
		for (int j = 2; curr * j <= maxValue; ++j) {
			countUniqueSequences(curr * j, idx + 1, maxValue);
		}
	}

	public int idealArrays(int n, int maxValue) {
		count = new long[15][10005];
		prefixSum = new long[15][10005];
		options = new long[15];

		// Pre-fill 1st row
		for (int i = 1; i <= 10000; ++i) {
			count[1][i] = 1;
			prefixSum[1][i] = i;
		}

		// Fill the count table
		for (int i = 2; i <= 14; ++i) {
			for (int j = i; j <= 10000; ++j) {
				count[i][j] = prefixSum[i - 1][j - 1];
				prefixSum[i][j] = (count[i][j] + prefixSum[i][j - 1]) % MOD;
				count[i][j] %= MOD;
			}
		}

		// Calculate options
		for (int i = 1; i <= maxValue; ++i) {
			countUniqueSequences(i, 1, maxValue);
		}

		// Count total ideal arrays
		long ans = 0;
		for (int i = 1; i <= 14; ++i) {
			long ways = (count[i][n] * options[i]) % MOD;
			ans = (ans + ways) % MOD;
		}
		return (int) ans;
	}

	public static void main(String[] args) {
		CountTheNumberOfIdealArray c = new CountTheNumberOfIdealArray();

		System.out.println(c.idealArrays(184, 389));
	}
}
