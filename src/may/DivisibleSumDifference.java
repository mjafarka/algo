package may;


//Divisible and Non-divisible Sums Difference
public class DivisibleSumDifference {

    // def differenceOfSums(self, n: int, m: int) -> int:
    //     a = n // m

    //     mMultipleSum = m * ((a * (a+1)) // 2)

    //     ttlSum = (n * (n+1)) // 2

    //     sumNotDivisible = ttlSum - mMultipleSum

    //     return sumNotDivisible - mMultipleSum


    /**
     *  nums1 = totalSum - divisibleSum
     * 
     *  nums2 = divisibleSum
     * 
     *  result = totalSum - nums2 => totalSum - 2* divisibleSum
     * 
     *  divisibleSum calculation
     *  m + 2m+ 3m + 4m .... xm (which is just less than n)
     * 
     *  m * ( x * (x+1)  / 2 )
     * 
     *  2 will be cancelled from the numberator and denominator
     * @param n
     * @param m
     * @return
     */
    public int differenceOfSums(int n, int m) {
        int totalSum = n * (n + 1) / 2;
        int divisibleSum = m * (n / m) * (n / m + 1); 
        return totalSum - divisibleSum;
    }
}
