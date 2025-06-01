package june;

import java.util.ArrayList;
import java.util.List;

//notes in onenote
// Maximize the Number of Target Nodes After Connecting Trees II

public class MaximizeTheNumberOfTargetNode2 {
    int t1Even = 0;
    int t1Odd = 0;

    int t2Even = 0;
    int t2Odd = 0;

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {

        List<List<Integer>> g1 = new ArrayList<>();

        int n1 = edges1.length + 1;

        for (int i = 0; i < n1; i++) {
            g1.add(new ArrayList<>());
        }

        for (int[] e1 : edges1) {
            g1.get(e1[0]).add(e1[1]);
            g1.get(e1[1]).add(e1[0]);
        }

        List<List<Integer>> g2 = new ArrayList<>();

        int n2 = edges2.length + 1;

        for (int i = 0; i < n2; i++) {
            g2.add(new ArrayList<>());
        }

        for (int[] e2 : edges2) {
            g2.get(e2[0]).add(e2[1]);
            g2.get(e2[1]).add(e2[0]);
        }

        boolean[] isEven = new boolean[n1 + 1];

        dfs1(0, 0, -1, g1, isEven);
        dfs2(0, 0, -1, g2);

        int best = Math.max(t2Odd, t2Even);
        // System.out.println("best="+best);

        int[] res = new int[n1];
        for (int i = 0; i < n1; i++) {

            if (isEven[i]) {
                res[i] = t1Even + best;
            } else {
                res[i] = t1Odd + best;
            }
        }

        return res;

    }

    private void dfs1(int a, int l, int p, List<List<Integer>> g1, boolean[] isEven) {

        if (l % 2 == 0) {
            isEven[a] = true;
            t1Even++;
        } else {
            t1Odd++;
        }

        for (int ch : g1.get(a)) {
            if (ch != p)
                dfs1(ch, l + 1, a, g1, isEven);
        }
    }

    private void dfs2(int a, int l, int p, List<List<Integer>> g1) {

        if (l % 2 == 0) {
            t2Even++;
        } else {
            t2Odd++;
        }

        for (int ch : g1.get(a)) {
            if (ch != p)
                dfs2(ch, l + 1, a, g1);
        }
    }
}
