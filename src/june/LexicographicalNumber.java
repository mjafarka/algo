package june;

import java.util.ArrayList;
import java.util.List;

// Lexicographical Numbers

public abstract class LexicographicalNumber {

    // dfs and iterative solution

    /**
     * dfs
     * 
     * tc =O(n)
     * sc = O(logn  base 10)
     */

    public List<Integer> lexicalOrder(int n) {

        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= 9; i++)
            dfs(i, n, res);

        return res;
    }

    private void dfs(int cur, int n, List<Integer> res) {
        if (cur > n) {
            return;
        }

        res.add(cur);

        for (int i = 0; i <= 9; i++) {
            if (cur * 10 + i > n)
                break;
            dfs(cur * 10 + i, n, res);
        }
    }


    /**
     * iterative
     * 
     * 
     * tc =O(n)
     * sc = O(1)
     */

     public List<Integer> lexicalOrderIter(int n) {
        List<Integer> lexicographicalNumbers = new ArrayList<>();
        int currentNumber = 1;

        // Generate numbers from 1 to n
        for (int i = 0; i < n; ++i) {
            lexicographicalNumbers.add(currentNumber);

            // If multiplying the current number by 10 is within the limit, do it
            if (currentNumber * 10 <= n) {
                currentNumber *= 10;
            } else {
                // Adjust the current number by moving up one digit
                while (currentNumber % 10 == 9 || currentNumber >= n) {
                    currentNumber /= 10; // Remove the last digit
                }
                currentNumber += 1; // Increment the number
            }
        }

        return lexicographicalNumbers;
    }
}   
