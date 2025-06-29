package june;

public class CountTheNumberOfArraysWithKMatchingAdjElements {
    
    //Count the Number of Arrays with K Matching Adjacent Elements

    //notes in onenote i pad may be synced in mac
    long[] fact, invFact;

    int mod = (int) (Math.pow(10,9) + 7);
    public int countGoodArrays(int n, int m, int k) {
        precomputeFactorial(n);

        int b = n - k;

        long c = nCr(n-1,b-1);

        long ans = modExp(m-1,b-1,mod);

        ans = (ans * m ) % mod;
        ans = (ans * c) % mod;

        return (int) ans;
    }

    void precomputeFactorial(int n) {
        fact = new long[n+1];
        invFact = new long[n+1];

        fact[0] = 1;

        for (int i = 1 ; i <= n ; i++) fact[i] = (fact[i-1] * i) % mod;

        invFact[n] = modExp(fact[n],mod-2,mod);

        for (int i = n - 1 ; i>= 0 ;i --) invFact[i] = (invFact[i+1] * (i+1)) % mod;

        /**
            (1/n!) * n => (1/(n-1)!)
         */
    }

    long nCr(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }

        return ((fact[n] * invFact[r]) % mod * invFact[n-r]) % mod;
    }

    long modExp(long x, long y, int m) {
        long res = 1;

        x %= m;

        while (y > 0) {
            if ((y & 1) == 1) res = (res*x) % m;
            x = (x*x) % m;
            y >>= 1;
        }

        return res;
    }
}
