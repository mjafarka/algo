package june;

import java.util.ArrayDeque;
import java.util.Deque;

//Count Partitions With Max-Min Difference at Most K

// onenote
public class CountPartitionWithMaxMinDiffK {


    public int countPartitions(int[] A, int k) {
        int n = A.length, mod = 1_000_000_007;
        int[] dp = new int[n + 1]; dp[0] = 1;
        int[] acc = new int[n + 2]; acc[1] = 1;

        Deque<Integer> minq = new ArrayDeque<>();
        Deque<Integer> maxq = new ArrayDeque<>();
        for (int i = 0, j = 0; j < n; ++j) {
            while (!maxq.isEmpty() && A[j] > A[maxq.peekLast()])
                maxq.pollLast();
            maxq.addLast(j);

            while (!minq.isEmpty() && A[j] < A[minq.peekLast()])
                minq.pollLast();
            minq.addLast(j);

            while (A[maxq.peekFirst()] - A[minq.peekFirst()] > k) {
                ++i;
                if (minq.peekFirst() < i)
                    minq.pollFirst();
                if (maxq.peekFirst() < i)
                    maxq.pollFirst();
            }

            dp[j + 1] = (acc[j + 1] - acc[i] + mod) % mod;
            acc[j + 2] = (acc[j + 1] + dp[j + 1]) % mod;
        }

        return dp[n];
    }
}
