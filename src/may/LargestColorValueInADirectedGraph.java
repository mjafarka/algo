package may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// Largest Color Value in a Directed Graph

// notes in onenote

// bfs and dfs approaches are there
public class LargestColorValueInADirectedGraph {


    // using depth first search
    private static final int INF = Integer.MAX_VALUE;

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges)
            adj.get(e[0]).add(e[1]);

        int[][] count = new int[n][26];
        int[] vis = new int[n];
        int ans = 0;

        for (int i = 0; i < n && ans != INF; i++) {
            ans = Math.max(ans, dfs(i, colors, adj, count, vis));
        }
        return ans == INF ? -1 : ans;
    }

    private int dfs(int node, String colors, List<List<Integer>> adj, int[][] count, int[] vis) {
        if (vis[node] == 1)
            return INF;
        if (vis[node] == 2) {
            return count[node][colors.charAt(node) - 'a'];
        }

        vis[node] = 1;
        for (int nxt : adj.get(node)) {
            int res = dfs(nxt, colors, adj, count, vis);
            if (res == INF)
                return INF;
            for (int c = 0; c < 26; c++) {
                count[node][c] = Math.max(count[node][c], count[nxt][c]);
            }
        }
        int col = colors.charAt(node) - 'a';
        count[node][col]++;
        vis[node] = 2;

        return count[node][col];
    }

    // bfs approach
     public int largestPathValueBFS(String colors, int[][] edges) {
        int n = colors.length();
        int[] indegrees = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegrees[edge[1]]++;
        }
        Queue<Integer> zeroIndegree = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                zeroIndegree.offer(i);
            }
        }
        int[][] counts = new int[n][26];
        for (int i = 0; i < n; i++) {
            counts[i][colors.charAt(i) - 'a']++;
        }
        int maxCount = 0;
        int visited = 0;
        while (!zeroIndegree.isEmpty()) {
            int u = zeroIndegree.poll();
            visited++;
            for (int v : graph.get(u)) {
                for (int i = 0; i < 26; i++) {
                    counts[v][i] = Math.max(counts[v][i], counts[u][i] + (colors.charAt(v) - 'a' == i ? 1 : 0));
                }
                indegrees[v]--;
                if (indegrees[v] == 0) {
                    zeroIndegree.offer(v);
                }
            }
            maxCount = Math.max(maxCount, Arrays.stream(counts[u]).max().getAsInt());
        }
        return visited == n ? maxCount : -1;
    }
}
