package may;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Pair {

    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }

        Pair c = (Pair) o;

        return (c.a == this.a && c.b == this.b) || (c.b == this.a && c.a == this.b);
    }

    @Override
    public int hashCode() {
        if (a > b) {
            return Objects.hash(a, b);
        } else {
            return Objects.hash(b, a);
        }
    }
}
/*Number of Equivalent Domino Pairs */
public class NumberOfEqualentDomino {

    /*
        created a hashmap using a tric
     */
    public int numEquivDominoPairsOptimal(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;

        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? (domino[0] * 10 + domino[1]) : (domino[1] * 10 + domino[0]);

            ret += num[val];
            num[val] ++;
        }

        return ret;
    }

    /*
     * my implementation.
     */
    public int numEquivDominoPairs(int[][] dominoes) {

        Map<Pair, Integer> count = new HashMap<>();

        int ttlPair = 0;

        for (int[] d : dominoes) {
            Pair curr = new Pair(d[0], d[1]);

            int curPair = count.getOrDefault(curr, 0);

            ttlPair += curPair;

            count.putIfAbsent(curr, 0);

            count.computeIfPresent(curr, (k, v) -> v + 1);
        }

        return ttlPair;
    }

    
}
