package may;


//Divisible and Non-divisible Sums Difference
public class DivisibleSumDifference {

    // def differenceOfSums(self, n: int, m: int) -> int:
    //     a = n // m

    //     mMultipleSum = m * ((a * (a+1)) // 2)

    //     ttlSum = (n * (n+1)) // 2

    //     sumNotDivisible = ttlSum - mMultipleSum

    //     return sumNotDivisible - mMultipleSum

    public int differenceOfSums(int n, int m) {
        int totalSum = n * (n + 1) / 2;
        int divisibleSum = m * (n / m) * (n / m + 1);
        return totalSum - divisibleSum;
    }
}
