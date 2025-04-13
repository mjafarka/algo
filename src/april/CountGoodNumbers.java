package april;

public class CountGoodNumbers {
	long mod = (long) (Math.pow(10,9) + 7);
    public int countGoodNumbers(long n) {
        
        
        long odd = n / 2;
        long even = (n + 1 ) / 2;

        return (int) ((pow(5,even) % mod )  * (pow(4,odd) % mod ) % mod);   // will find out  Math.pow(5,even) * Math.pow(4,odd);
    }

    private long pow(long x, long n) {            //same as pow(x,n) leetcode problem
        if (n == 0) {
            return 1;
        }

        long half = pow(x,n/2);

        if (n % 2 == 0) {
            return ((half % mod) * (half % mod)) % mod;       // this is a hack to find out mod,     (half * half) % mod == ((half % mod) * (half % mod)) % mod, but this one will not cause integer overflow
        } else {
            return (x * (half % mod) * (half % mod)) % mod;
        }
    }
    
    public static void main(String[] args) {
		CountGoodNumbers cgn = new CountGoodNumbers();
		
		System.out.println( cgn.countGoodNumbers(1) == 5);
		
		System.out.println( cgn.countGoodNumbers(4) == 400);
		
		System.out.println( cgn.countGoodNumbers(50) == 564908303);


	}
}
