package april;


// Reverse Integer
public class ReverseInteger {
	
	// little easier and legible one below
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
	
	public int reverseE(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (
                
                (rev == Integer.MAX_VALUE / 10 && pop > 7)
            ) return 0;
            if (
                
                (rev == Integer.MIN_VALUE / 10 && pop < -8)
            ) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
