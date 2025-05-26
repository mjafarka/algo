package may;

import java.math.BigInteger;

public class PlayerScoreSeq {
     // Function to compute factorial using BigInteger for large numbers
     public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // Function to compute nCr = n! / (r! * (n - r)!)
    public static BigInteger binomialCoefficient(int n, int r) {
        if (r > n) return BigInteger.ZERO;
        return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
    }

    public static void main(String[] args) {
        int s = 2;   // Team 1 score
        int sPrime = 3; // Team 2 score

        int totalPoints = s + sPrime;
        BigInteger numberOfSequences = binomialCoefficient(totalPoints, s);

        System.out.println("Number of distinct scoring sequences for score (" + s + ", " + sPrime + "): " + numberOfSequences);
    }
}
