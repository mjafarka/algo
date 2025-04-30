package april;


//Find Numbers with Even Number of Digits
public class FindNumberWithEvenCount {
	public int findNumbers(int[] nums) {

		int count = 0;

		for (int num : nums) {
			if (evenNumber(num)) {
				count++;
			}
		}

		return count;
	}

	private boolean evenNumber(int num) {
		int siz = 0;
		while (num != 0) {
			num = num / 10;
			siz++;
		}

		return siz % 2 == 0;
	}
}
