package may;

import java.util.TreeSet;

/*
 * Prime Subtraction Operation
 * 
 * without using storage it is much more efficient, while running
 */
public class PrimeSubtractionOperation {
	public boolean primeSubOperation(int[] nums) {
        TreeSet<Integer> primes = new TreeSet<>();

        primes.add(0);
        for (int i = 2 ; i <= 1000 ; i ++ ) {
        	if (isPrime(i)) {
        		primes.add(i);
        	}
        }
        
        int prev = nums[nums.length-1];
        
        for (int i = nums.length - 2 ; i >= 0 ; i --) {
        	int leftNum = nums[i];
        	
        	if (leftNum >= prev) {
//        		int lowerPrime = primes.lower(leftNum);
        		
        		int diff = leftNum - prev;
        		
        		Integer higherPrime = primes.higher(diff);
        		
        		if (higherPrime == null || higherPrime >= leftNum) {
        			return false;
        		}
        		
        		
        		leftNum -= higherPrime;
        		
        		
        	}
        	
        	
        	
        	nums[i] = leftNum;
        	
        	prev = leftNum;
        }
        
        return true;
    }
	
	private boolean isPrime(int num) {
		int sqrt = (int) Math.sqrt(num);
		
		for (int i = sqrt ; i >= 2 ; i --) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	
	
	/* solution without storing primes*/
	
	public boolean primeSubOperation1(int[] nums) {

        
        int prev = nums[nums.length-1];
        
        for (int i = nums.length - 2 ; i >= 0 ; i --) {
        	int leftNum = nums[i];
        	
        	if (leftNum >= prev) {
//        		int lowerPrime = primes.lower(leftNum);
        		
        		int diff = leftNum - prev;
        		
        		Integer higherPrime = null;

                for (int k = diff + 1 ; k < leftNum ; k++) {
                    if (isPrime1(k)) {
                        higherPrime = k;
                        break;
                    }
                }
        		
        		if (higherPrime == null || higherPrime >= leftNum) {
        			return false;
        		}
        		
        		
        		leftNum -= higherPrime;
        		
        		
        	}
        	
        	
        	
        	nums[i] = leftNum;
        	
        	prev = leftNum;
        }
        
        return true;
    }
	
	
	private boolean isPrime1(int num) {

        if (num < 2) {
            return false;
        }
		int sqrt = (int) Math.sqrt(num);
		
		for (int i = sqrt ; i >= 2 ; i --) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	
}
