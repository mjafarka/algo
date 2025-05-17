package may;


/* Total Characters in String After Transformations I */
/*created frequency array */
public class TotalCharacterAfterTransformation1 {
	public int lengthAfterTransformations(String s, int t) {
		int mod = (int) (Math.pow(10, 9) + 7);
		int[] freq = new int[26];

		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}

		for (int k = 0; k < t; k++) {
			int[] temp = new int[26];

			for (int i = 0; i < 26; i++) {
				if (i == 25) {
					temp[0] += freq[25];
					temp[1] += freq[25];

					temp[0] %= mod;
					temp[1] %= mod;
				} else {
					temp[i + 1] = freq[i];
					temp[i + 1] %= mod;
				}
			}

			freq = temp;

		}

		int res = 0;

		for (int f : freq) {
			res += f;
			res %= mod;
		}

		return res % mod;
	}
}
