package april;


// Reverse Integer
public class ReverseInteger {
	public int reverse(int x) {
		int result = 0;

		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if ((newResult - tail) / 10 != result) {                 // to check the overflow
				return 0;
			}
			result = newResult;
			x = x / 10;
		}

		return result;
	}
}
